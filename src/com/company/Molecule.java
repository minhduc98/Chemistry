package com.company;

import java.util.ArrayList;

public class Molecule {
    Analysis analysis = new Analysis();
    Atom atom = new Atom();

    public String rawClassifyMolecule(String chemistryFormula) {
        String moleculeBondType = "";
        ArrayList<Analysis.ElementAnalyse> analysedMolecule = analysis.compressMolecule(chemistryFormula);
        String firstElement = analysedMolecule.get(0).Element;
        String lastElement = analysedMolecule.get(analysedMolecule.size()-1).Element;
        if (atom.classifyAtom(firstElement).equals("nonmetal") || atom.classifyAtom(firstElement).equals("metalloid")) {
            if (atom.classifyAtom(lastElement).equals("metal") || chemistryFormula.contains("NH4")) {
                moleculeBondType = "ion";
            } else {
                moleculeBondType = "covalent";
            }
        } else {
            moleculeBondType = "ion";
        }
        return moleculeBondType;
    }

    public String classifyCovalentInorganicMolecule(String chemistryFormula) {
        ArrayList<Analysis.ElementAnalyse> analysedMolecule = analysis.compressMolecule(chemistryFormula);
        String inorganicMoleculeType = "";
        String firstElement = analysedMolecule.get(0).Element;
        String lastElement = analysedMolecule.get(analysedMolecule.size()-1).Element;
        if (firstElement.equals("H")) {
            if (!chemistryFormula.equals("H2O")) {
                inorganicMoleculeType = "inorganic-acid";
            } else {
                inorganicMoleculeType = "neutral-oxid";
            }
        } else {
            if (analysedMolecule.size() == 2) {
                switch (lastElement) {
                    case "F":
                    case "Cl":
                    case "Br":
                    case "I":
                        inorganicMoleculeType = "covalent-halogenua"; break;
                    case "O": inorganicMoleculeType = "acid-oxid"; break;
                    case "H":
                        switch (firstElement) {
                            case "B":
                            case "Si":
                                inorganicMoleculeType = "inorganic-acid"; break;
                            case "N": inorganicMoleculeType = "inorganic-base"; break;
                        }
                        break;
                }
            } else {
                if (chemistryFormula.contains("NH4") || chemistryFormula.contains("NH3OH")) inorganicMoleculeType = "salt";
            }
        }
        return inorganicMoleculeType;
    }
}
