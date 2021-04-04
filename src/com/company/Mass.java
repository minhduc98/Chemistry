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
    public int findAtomMass(String element) {
        int mass = 0;
        switch (element) {
            case "H": mass = 1; break;
            case "O": mass = 8; break;
            case "Na": mass = 23; break;
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

        HashSet<String> set = new HashSet<>();
        for (ElementAnalyse pm : precompressedMolecule) {
            if (!set.contains(pm.Element)) {
                set.add(pm.Element);
            }
        }

        List<String> newElements = set.stream().collect(Collectors.toList());
        System.out.println(newElements);
        return compressedMolecule;
    }


}
