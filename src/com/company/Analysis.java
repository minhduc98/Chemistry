package com.company;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Analysis {
    public class ElementAnalyse {
        String Element;
        int Valence;

        ElementAnalyse(String element, int valence) {
            this.Element = element;
            this.Valence = valence;
        }
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
}