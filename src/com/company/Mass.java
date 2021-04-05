package com.company;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Mass {
    public class ElementAnalyse {
        String Element;
        int Valence;

        ElementAnalyse(String element, int valence) {
            this.Element = element;
            this.Valence = valence;
        }
    }
    public double findAtomMass(String element) {
        double mass = 0;
        switch (element) {
            case "H": mass = 1; break;
            case "Li": mass = 7; break;
            case "B": mass = 11; break;
            case "C": mass = 12; break;
            case "N": mass = 14; break;
            case "O": mass = 16; break;
            case "F": mass = 19; break;
            case "Na": mass = 23; break;
            case "Mg": mass = 24; break;
            case "Al": mass = 27; break;
            case "Si": mass = 28; break;
            case "P": mass = 31; break;
            case "S": mass = 32; break;
            case "Cl": mass = 35.5; break;
            case "K": mass = 39; break;
            case "Ca": mass = 40; break;
            case "Cr": mass = 52; break;
            case "Mn": mass = 55; break;
            case "Fe": mass = 56; break;
            case "Co": mass = 59; break;
            case "Ni": mass = 59; break;
            case "Cu": mass = 64; break;
            case "Zn": mass = 65; break;
            case "Br": mass = 80; break;
            case "Rb": mass = 85; break;
            case "Ag": mass = 108; break;
            case "Cd": mass = 112; break;
            case "Sn": mass = 119; break;
            case "I": mass = 127; break;
            case "Cs": mass = 133; break;
            case "Ba": mass = 137; break;
            case "Pt": mass = 195; break;
            case "Au": mass = 197; break;
            case "Hg": mass = 201; break;
            case "Pb": mass = 207; break;
        }
        return mass;
    }

    public ArrayList<ElementAnalyse> analyzeMolecule(String chemistryFormula) {
        char[] chem = chemistryFormula.toCharArray();
        ArrayList<ElementAnalyse> elementAnalyses = new ArrayList<>();
        for (int i = 0; i < chem.length; i++) {
            if (Character.isUpperCase(chem[i])) {
                // Not the last digit
                if (i != chem.length - 1) {
                    // If the element has 1 letter
                    if (Character.isDigit(chem[i + 1])) {
                        if ((i + 1) < chem.length - 1) {  // Check if that element's valence > 10
                            if (Character.isDigit(chem[i+2])) {
                                StringBuffer valence = new StringBuffer().append(chem[i+1]).append(chem[i+2]);
                                String valenceString = valence.toString();
                                elementAnalyses.add(new ElementAnalyse(Character.toString(chem[i]), Integer.valueOf(valenceString)));
                            } else {
                                elementAnalyses.add(new ElementAnalyse(Character.toString(chem[i]), Character.getNumericValue(chem[i + 1])));
                            }
                        } else {
                            elementAnalyses.add(new ElementAnalyse(Character.toString(chem[i]), Character.getNumericValue(chem[i + 1])));
                        }
                    }
                    // If that element has 2 letter
                    if (Character.isLowerCase(chem[i+1])) {
                        if ((i + 1) < chem.length - 1) { // If the element is not an end
                            if (Character.isDigit(chem[i+2])) {     // If that element's valence > 1
                                StringBuffer ele = new StringBuffer().append(chem[i]).append(chem[i+1]);
                                if ((i + 3) < chem.length - 1) {    // If that element's valence > 9
                                    if (Character.isDigit(chem[i+3])) {
                                        StringBuffer valence = new StringBuffer().append(chem[i+2]).append(chem[i+3]);
                                        String valenceString = valence.toString();
                                        elementAnalyses.add(new ElementAnalyse(ele.toString(), Integer.valueOf(valenceString)));
                                    } else {
                                        elementAnalyses.add(new ElementAnalyse(ele.toString(), Character.getNumericValue(chem[i + 2])));
                                    }
                                } else {
                                    elementAnalyses.add(new ElementAnalyse(ele.toString(), Character.getNumericValue(chem[i + 2])));
                                }
                            } else if (Character.isUpperCase(chem[i+2])) {      // If that element's valence = 1
                                StringBuffer ele = new StringBuffer().append(chem[i]).append(chem[i+1]);
                                elementAnalyses.add(new ElementAnalyse(ele.toString(), 1));
                            }
                        } else {
                            StringBuffer ele = new StringBuffer().append(chem[i]).append(chem[i+1]);
                            elementAnalyses.add(new ElementAnalyse(ele.toString(), 1));
                        }

                    }
                    // If next to it is the other element
                    if (Character.isUpperCase(chem[i+1])) {
                        elementAnalyses.add(new ElementAnalyse(Character.toString(chem[i]), 1));
                    }
                } else { // The last digit
                    elementAnalyses.add(new ElementAnalyse(Character.toString(chem[i]), 1));
                }
            }
        }
        return elementAnalyses;
    }

    public ArrayList<ElementAnalyse> compressMolecule(String chemistryFormula) {
        ArrayList<ElementAnalyse> precompressedMolecule = analyzeMolecule(chemistryFormula);
        ArrayList<ElementAnalyse> compressedMolecule = new ArrayList<>();

        LinkedHashSet<String> setElement = new LinkedHashSet<>();
        for (ElementAnalyse pm : precompressedMolecule) {
            if (!setElement.contains(pm.Element)) {
                setElement.add(pm.Element);
            }
        }
        

        List<String> newElements = setElement.stream().collect(Collectors.toList());
        
        for (String ne : newElements) {
            int newValence = 0;
            for (ElementAnalyse pm: precompressedMolecule) {
                if (ne.equals(pm.Element)) {
                    newValence = newValence + pm.Valence;
                }
            }
            compressedMolecule.add(new ElementAnalyse(ne, newValence));
        }
        
        return compressedMolecule;
    }
    
    public double findMoleculeMass(String chemistryFormula) {
        ArrayList<ElementAnalyse> chemFormula = compressMolecule(chemistryFormula);
        double mass = 0;
        for (ElementAnalyse cf : chemFormula) {
            mass += findAtomMass(cf.Element) * cf.Valence;
        }
        return mass;
    }
    
    public double findProportion(String chemistryFormula1, String chemistryFormula2) {
        double ratio;
        double m1 = findMoleculeMass(chemistryFormula1);
        if (chemistryFormula2.equals("Air")) {
            ratio = m1 / 29;
        } else {
            double m2 = findMoleculeMass(chemistryFormula2);
            ratio = m1/m2;
        }
        return ratio;
    }


}
