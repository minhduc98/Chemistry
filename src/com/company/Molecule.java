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

    public String classifyCovalentMolecule(String chemistryFormula) {
        ArrayList<Analysis.ElementAnalyse> analysedMolecule = analysis.compressMolecule(chemistryFormula);
        String firstElement = analysedMolecule.get(0).Element;
        if (firstElement.equals("H")) {
            if (!chemistryFormula.equals("H2O")) {
                return "acid";
            } else {
                return "neutral-oxid";
            }
        } else {
            if (analysedMolecule.size() == 2) {
                if (analysedMolecule.get(1).Element.equals("O")) {
                    return "acid-oxid";
                }
                if (analysedMolecule.get(1).Element.equals("H")) {
                    switch (firstElement) {
                        case "C": return "hydrocarbon"; break;
                        case "B": return "borane"; break;
                        case "Si": return "silane"; break;
                    }
                }
                if (atom.findAtomPosition(analysedMolecule.get(1).Element).groupIndex.equals("VII")) return "covalent-halogenua";
                if (chemistryFormula.equals("NH3")) return "base";
            }
        }
    }
}
