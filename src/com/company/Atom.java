package com.company;

import java.util.*;
import java.util.stream.IntStream;

public class Atom {
    // Define constant
    final double protonMass = 1.0073;
    final double neutralMass = 1.0087;

    public class StableAtom {
        int protonNum;
        int neutralNum;
        double massPercentage;
        StableAtom(int protonNum, int neutralNum, double massPercentage) {
            this.protonNum = protonNum;
            this.neutralNum = neutralNum;
            this.massPercentage = massPercentage;
        }
    }

    public class ElectronClass {
        int index;  // Principal quantum number
        char className;
        int numElectron;
        ElectronClass(int index, char className, int numElectron) {
            this.index = index;
            this.className = className;
            this.numElectron = numElectron;
        }
    }
    
    public class ElementGroup {
        String groupIndex; 
        char groupName;
        int periodIndex;
        boolean isLantanoid = false;
        boolean isActinide = false;
    }
    
    public ArrayList<StableAtom> findStableAtom(String atomicSymbol) {
        ArrayList<StableAtom> isotopes = new ArrayList<>();
        switch (atomicSymbol) {
            case "H":
                isotopes.add(new StableAtom(1, 0, 99.99));
                isotopes.add(new StableAtom(1, 1, 0.01));
                break;
        }
        return isotopes;
    }

    public int findAtomIndex(String atomicSymbol) {
        int atomIndex = 0;
        switch (atomicSymbol) {
            case "H": atomIndex = 1; break;
            case "He": atomIndex = 2; break;
            case "Li": atomIndex = 3; break;
            case "Be": atomIndex = 4; break;
            case "B": atomIndex = 5; break;
            case "C": atomIndex = 6; break;
            case "N": atomIndex = 7; break;
            case "O": atomIndex = 8; break;
            case "F": atomIndex = 9; break;
            case "Ne": atomIndex = 10; break;
            case "Na": atomIndex = 11; break;
            case "Mg": atomIndex = 12; break;
            case "Al": atomIndex = 13; break;
            case "Si": atomIndex = 14; break;
            case "P": atomIndex = 15; break;
            case "S": atomIndex = 16; break;
            case "Cl": atomIndex = 17; break;
            case "Ar": atomIndex = 18; break;
            case "K": atomIndex = 19; break;
            case "Ca": atomIndex = 20; break;
            case "Sc": atomIndex = 21; break;
            case "Ti": atomIndex = 22; break;
            case "V": atomIndex = 23; break;
            case "Cr": atomIndex = 24; break;
            case "Mn": atomIndex = 25; break;
            case "Fe": atomIndex = 26; break;
            case "Co": atomIndex = 27; break;
            case "Ni": atomIndex = 28; break;
            case "Cu": atomIndex = 29; break;
            case "Zn": atomIndex = 30; break;
            case "As": atomIndex = 33; break;
            case "Se": atomIndex = 34; break;
            case "Br": atomIndex = 35; break;
            case "Kr": atomIndex = 36; break;
            case "Rb": atomIndex = 37; break;
            case "Sr": atomIndex = 38; break;
            case "Nb": atomIndex = 41; break;
            case "Mo": atomIndex = 42; break;
            case "Ru": atomIndex = 44; break;
            case "Rh": atomIndex = 45; break;
            case "Pd": atomIndex = 46; break;
            case "Ag": atomIndex = 47; break;
            case "Cd": atomIndex = 48; break;
            case "Sn": atomIndex = 50; break;
            case "I": atomIndex = 53; break;
            case "Xe": atomIndex = 54; break;
            case "Cs": atomIndex = 55; break;
            case "Ba": atomIndex = 56; break;
            case "La": atomIndex = 57; break;
            case "Ce": atomIndex = 58; break;
            case "Gd": atomIndex = 64; break;
            case "Pt": atomIndex = 78; break;
            case "Au": atomIndex = 79; break;
            case "Hg": atomIndex = 80; break;
            case "Pb": atomIndex = 82; break;
            case "Po": atomIndex = 84; break;
            case "Rn": atomIndex = 86; break;
            case "Fr": atomIndex = 87; break;
            case "Ra": atomIndex = 88; break;
            case "Ac": atomIndex = 89; break;
            case "Th": atomIndex = 90; break;
            case "Pa": atomIndex = 91; break;
            case "U": atomIndex = 92; break;
            case "Np": atomIndex = 93; break;
            case "Cm": atomIndex = 96; break;
            case "Lr": atomIndex = 103; break;
        }
        return atomIndex;
    }

    public String findAtomName(String atomicSymbol) {
        String atomName = "";
        switch (atomicSymbol) {
            case "H": atomName = "Hydrogen"; break;
            case "He": atomName = "Helium"; break;
        }
        return atomName;
    }

    /*
        s: 2; p: 6; d: 10; f: 14
        1s → 2s → 2p → 3s → 3p → 4s → 3d → 4p → 5s → 4d → 5p → 6s → 4f → 5d → 6p → 7s → 5f → 6d → 7p → 8s
     */
    public ArrayList<ElectronClass> findAtomElectronStructure(String atomicSymbol) {
        // Declare array list of electron class
        ArrayList<ElectronClass> electronClassOrder = new ArrayList<>();
        electronClassOrder.add(new ElectronClass(1, 's', 2));
        electronClassOrder.add(new ElectronClass(2, 's', 2));
        electronClassOrder.add(new ElectronClass(2, 'p', 6));
        electronClassOrder.add(new ElectronClass(3, 's', 2));
        electronClassOrder.add(new ElectronClass(3, 'p', 6));
        electronClassOrder.add(new ElectronClass(4, 's', 2));
        electronClassOrder.add(new ElectronClass(3, 'd', 10));
        electronClassOrder.add(new ElectronClass(4, 'p', 6));
        electronClassOrder.add(new ElectronClass(5, 's', 2));
        electronClassOrder.add(new ElectronClass(4, 'd', 10));
        electronClassOrder.add(new ElectronClass(5, 'p', 6));
        electronClassOrder.add(new ElectronClass(6, 's', 2));
        electronClassOrder.add(new ElectronClass(4, 'f', 14));
        electronClassOrder.add(new ElectronClass(5, 'd', 10));
        electronClassOrder.add(new ElectronClass(6, 'p', 6));
        electronClassOrder.add(new ElectronClass(7, 's', 2));
        electronClassOrder.add(new ElectronClass(5, 'f', 14));
        electronClassOrder.add(new ElectronClass(6, 'd', 10));
        electronClassOrder.add(new ElectronClass(7, 'p', 6));
        electronClassOrder.add(new ElectronClass(8, 's', 2));
        
        // Find number of the atom's electrons
        int numElectron = findAtomIndex(atomicSymbol);
        // The array list to contain the result
        ArrayList<ElectronClass> result = new ArrayList<>();
        // Start algorithm here
        for (int i = 0; i < electronClassOrder.size(); i++) {
            ElectronClass currentElectronClass = electronClassOrder.get(i);
            if (numElectron <= currentElectronClass.numElectron) {
                if (currentElectronClass.className == 'd' && currentElectronClass.index == 3) { // special case for 3d class
                    if (numElectron == 4 || numElectron == 9) { // Case Cr and Cu
                        ElectronClass sElectronClass = electronClassOrder.get(5);
                        sElectronClass.numElectron = 1;
                        result.add(new ElectronClass(currentElectronClass.index, currentElectronClass.className, numElectron + 1));
                        result.set(5, sElectronClass);
                        break;
                    }
                    result.add(new ElectronClass(currentElectronClass.index, currentElectronClass.className, numElectron));
                    break;
                }
                if (currentElectronClass.className == 'd' && currentElectronClass.index == 4) { // special case for 4d class
                    if (numElectron == 3 || numElectron == 4 || numElectron == 6 || numElectron == 7 || numElectron == 9) { // Case Nb, Mo, Ru, Rh, Ag
                        ElectronClass sElectronClass = electronClassOrder.get(8);
                        sElectronClass.numElectron = 1;
                        result.add(new ElectronClass(currentElectronClass.index, currentElectronClass.className, numElectron + 1));
                        result.set(8, sElectronClass);
                        break;
                    }
                    if (numElectron == 8) { // Case Pd
                        ElectronClass sElectronClass = electronClassOrder.get(8);
                        sElectronClass.numElectron = 0;
                        result.add(new ElectronClass(currentElectronClass.index, currentElectronClass.className, 10));
                        result.set(8, sElectronClass);
                        break;
                    }
                    result.add(new ElectronClass(currentElectronClass.index, currentElectronClass.className, numElectron));
                    break;
                }
                if (currentElectronClass.className == 'f' && currentElectronClass.index == 4) { // special case for 4f class
                    if (numElectron == 1 || numElectron == 2 || numElectron == 8) { // Case La, Ce, Gd
                        ElectronClass dElectronClass = electronClassOrder.get(13);
                        dElectronClass.numElectron = 1;
                        result.add(new ElectronClass(currentElectronClass.index, currentElectronClass.className, numElectron - 1));
                        result.add(dElectronClass);
                        break;
                    }
                    result.add(new ElectronClass(currentElectronClass.index, currentElectronClass.className, numElectron));
                    break;
                }
                if (currentElectronClass.className == 'd' && currentElectronClass.index == 5) { // special case for 5d class
                    if (numElectron == 8 || numElectron == 9) { // Case Pt, Au
                        ElectronClass sElectronClass = electronClassOrder.get(11);
                        sElectronClass.numElectron = 1;
                        result.add(new ElectronClass(currentElectronClass.index, currentElectronClass.className, numElectron + 1));
                        result.set(11, sElectronClass);
                        break;
                    }
                    result.add(new ElectronClass(currentElectronClass.index, currentElectronClass.className, numElectron));
                    break;
                }
                if (currentElectronClass.className == 'f' && currentElectronClass.index == 5) { // special case for 5f class
                    if (numElectron == 1 || numElectron == 2) { // Case Ac, Th
                        ElectronClass dElectronClass = electronClassOrder.get(17);
                        dElectronClass.numElectron = numElectron;
                        result.add(new ElectronClass(currentElectronClass.index, currentElectronClass.className, 0));
                        result.add(dElectronClass);
                        break;
                    }
                    if (numElectron == 3 || numElectron == 4 || numElectron == 5 || numElectron == 8) { // Case Pa, U, Np, Cm
                        ElectronClass dElectronClass = electronClassOrder.get(17);
                        dElectronClass.numElectron = 1;
                        result.add(new ElectronClass(currentElectronClass.index, currentElectronClass.className, numElectron - 1));
                        result.add(dElectronClass);
                        break;
                    }
                    result.add(new ElectronClass(currentElectronClass.index, currentElectronClass.className, numElectron));
                    break;
                }
                if (currentElectronClass.className == 'd' && currentElectronClass.index == 6) { // special case for 6d class
                    if (numElectron == 1) { // Case Lr
                        ElectronClass pElectronClass = electronClassOrder.get(18);
                        pElectronClass.numElectron = 1;
                        result.add(new ElectronClass(currentElectronClass.index, currentElectronClass.className, 0));
                        result.add(pElectronClass);
                        break;
                    }
                    result.add(new ElectronClass(currentElectronClass.index, currentElectronClass.className, numElectron));
                    break;
                }
                result.add(new ElectronClass(currentElectronClass.index, currentElectronClass.className, numElectron));
                break;
            } else {
                result.add(currentElectronClass);
                numElectron = numElectron - currentElectronClass.numElectron;
            }
        }
        return result;
    }

    public ArrayList<ElectronClass> sortElectronStructure(String atomicSymbol) {
        ArrayList<ElectronClass> electronStructureList = findAtomElectronStructure(atomicSymbol);
        electronStructureList.sort(Comparator.comparingInt(e -> e.index));
        return electronStructureList;
    }

    // will remove when build app in android
    public String displayAtomElectronStructure(String atomicSymbol) {
        ArrayList<ElectronClass> electronStructureList = sortElectronStructure(atomicSymbol);
        String electronStructure = "";
        for (ElectronClass ec: electronStructureList) {
            electronStructure = electronStructure + ec.index + ec.className + ec.numElectron;
        }
        return electronStructure;
    }

    // will remove when build app in android
    public String displayCompactAtomElectronStructure(String atomicSymbol) {
        String fullAtomElectronStructure = displayAtomElectronStructure(atomicSymbol);
        String compactString = "";
        int numElectron = findAtomIndex(atomicSymbol);
        if (numElectron > 1 && numElectron <= 10) {      // He
            compactString = fullAtomElectronStructure.replace("1s2", "[He]");
        }
        if (numElectron > 10 && numElectron <= 18) {     // Ne
            compactString = fullAtomElectronStructure.replace("1s22s22p6", "[Ne]");
        }
        if (numElectron > 18 && numElectron <= 36) {     // Ar
            compactString = fullAtomElectronStructure.replace("1s22s22p63s23p6", "[Ar]");
        }
        if (numElectron > 36 && numElectron <= 54) {     // Kr
            compactString = fullAtomElectronStructure.replace("1s22s22p63s23p63d104s24p6", "[Kr]");
        }
        if (numElectron > 54 && numElectron <= 86) {     // Xe
            if (fullAtomElectronStructure.contains("1s22s22p63s23p63d104s24p64d105s25p6")) {
                compactString = fullAtomElectronStructure.replace("1s22s22p63s23p63d104s24p64d105s25p6", "[Xe]");
            } else {
                compactString = fullAtomElectronStructure.replace("1s22s22p63s23p63d104s24p64d10", "");
                compactString = compactString.replace("5s25p6", "");
                compactString = "[Xe]" + compactString;
            }
        }
        if (numElectron > 86) {     // Rn
            if (fullAtomElectronStructure.contains("1s22s22p63s23p63d104s24p64d104f145s25p65d106s26p6")) {
                compactString = fullAtomElectronStructure.replace("1s22s22p63s23p63d104s24p64d105s25p6", "[Rn]");
            } else {
                compactString = fullAtomElectronStructure.replace("1s22s22p63s23p63d104s24p64d104f145s25p65d10", "");
                compactString = compactString.replace("6s26p6", "");
                compactString = "[Rn]" + compactString;
            }
        }
        return compactString;
    }
    
    public ElementGroup findAtomPosition(String atomicSymbol) {
        ElementGroup eg = new ElementGroup();
        ArrayList<ElectronClass> electronStructureList = findAtomElectronStructure(atomicSymbol);
        ElectronClass lastElectronClass = electronStructureList.get(electronStructureList.size() - 1);
        int numElectron = findAtomIndex(atomicSymbol);
        if (numElectron > 56 && numElectron < 72) {
            eg.groupName = 'B';
            eg.groupIndex = "III";
            eg.isLantanoid = true;
            eg.periodIndex = 6;
        } else if (numElectron > 88 && numElectron < 104) {
            eg.groupName = 'B';
            eg.groupIndex = "III";
            eg.isActinide = true;
            eg.periodIndex = 7;
        } else {
            eg.periodIndex = sortElectronStructure(atomicSymbol).get(electronStructureList.size() - 1).index;
            switch (lastElectronClass.className) {
                case 's':
                    eg.groupName = 'A';
                    switch (lastElectronClass.numElectron) {
                        case 1:
                            eg.groupIndex = "I";
                            break;
                        case 2:
                            eg.groupIndex = "II";
                            break;
                    }
                    break;
                case 'p':
                    eg.groupName = 'A';
                    switch (lastElectronClass.numElectron) {
                        case 1:
                            eg.groupIndex = "III";
                            break;
                        case 2:
                            eg.groupIndex = "IV";
                            break;
                        case 3:
                            eg.groupIndex = "V";
                            break;
                        case 4:
                            eg.groupIndex = "VI";
                            break;
                        case 5:
                            eg.groupIndex = "VII";
                            break;
                        case 6:
                            eg.groupIndex = "VIII";
                            break;
                    }
                    break;
                case 'd':
                    eg.groupName = 'B';
                    int sIndex = IntStream.range(0, electronStructureList.size())
                            .filter(i -> electronStructureList.get(i).className == 's')
                            .filter(i -> electronStructureList.get(i).index == lastElectronClass.index + 1)
                            .findFirst().orElse(-1);
                    ElectronClass sElectronClass = electronStructureList.get(sIndex);
                    int sumValenceElectron = sElectronClass.numElectron + lastElectronClass.numElectron;
                    switch (sumValenceElectron) {
                        case 3:
                            eg.groupIndex = "III";
                            break;
                        case 4:
                            eg.groupIndex = "IV";
                            break;
                        case 5:
                            eg.groupIndex = "V";
                            break;
                        case 6:
                            eg.groupIndex = "VI";
                            break;
                        case 7:
                            eg.groupIndex = "VII";
                            break;
                        case 8:
                        case 9:
                        case 10:
                            eg.groupIndex = "VIII";
                            break;
                        case 11:
                            eg.groupIndex = "I";
                            break;
                        case 12:
                            eg.groupIndex = "II";
                            break;
                    }
                    break;
            }
        }
        return eg;
    }

    // will remove when build app in android
    public String displayAtomPosition(String atomicSymbol) {
        ElementGroup eg = findAtomPosition(atomicSymbol);
        if (!eg.isLantanoid && !eg.isActinide) return "Period is " + eg.periodIndex + ". Group name is " + eg.groupIndex + eg.groupName;
        else if (eg.isLantanoid) return "Period is " + eg.periodIndex + ". Group name is " + eg.groupIndex + eg.groupName + " and is lantanoid";
        else return "Period is " + eg.periodIndex + ". Group name is " + eg.groupIndex + eg.groupName + " and is actinide";
    }

    public double findAtomMass(String atomicSymbol) {
        double atomMass = 0;
        ArrayList<StableAtom> isotopes = findStableAtom(atomicSymbol);
        for (StableAtom sa: isotopes) {
            atomMass = atomMass + (sa.protonNum * protonMass + sa.neutralNum * neutralMass) * sa.massPercentage / 100;
        }
        return Math.round(atomMass * 10000.0) / 10000.0;
    }

    public String classifyAtom(String atomicSymbol) {
        ElementGroup eg = findAtomPosition(atomicSymbol);
        String type = "";
        switch (eg.groupName) {
            case 'B': type = "metal"; break;
            case 'A':
                int numElectron = findAtomIndex(atomicSymbol);
                if (numElectron == 5 || numElectron == 14 ||numElectron == 32 || numElectron == 33 || numElectron == 52) {  // B, Si, Ge, As, Te
                    type = "metalloid";
                } else {
                   if ((eg.groupIndex.equals("I") && numElectron != 1) || eg.groupIndex.equals("II") || eg.groupIndex.equals("III")
                           || numElectron == 50 || numElectron == 82 || numElectron == 83 || numElectron == 84 ) type = "metal";    // Sn, Pb, Bi, Po
                   else type = "nonmetal";
                }
                break;
        }
        return type;
    }

    /* Positive: Metal ; Negative: Non-metal; High index: Strong metal; Low index: Strong non-metal */
    public int rateAtomStrength(String atomicSymbol) {
        ElementGroup eg = findAtomPosition(atomicSymbol);
        int rating = 0;
        String atomType = classifyAtom(atomicSymbol);
        switch (atomType) {
            case "metal": break;
            default:
                break;
        }
        return rating;
    }
}