package com.company;

import java.util.*;
import java.util.stream.IntStream;

public class Atom {
    public class StableAtom {
        int protonNum;
        int neutralNom;
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
        String numIndex; 
        char groupName;
        boolean isLantanoid = false;
        boolean isActinide = false;
    }
    
    public StableAtom findAtom(String atomName) {
        StableAtom sa = new StableAtom();
        switch (atomName) {
            case "H": sa.protonNum = 1; sa.neutralNom = 1; break;
            case "Li": sa.protonNum = 3; sa.neutralNom = 4; break;
        }
        return sa;
    }

    public int findAtomIndex(String atomName) {
        int atomIndex = 0;
        switch (atomName) {
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
    /*
        s: 2; p: 6; d: 10; f: 14
        1s → 2s → 2p → 3s → 3p → 4s → 3d → 4p → 5s → 4d → 5p → 6s → 4f → 5d → 6p → 7s → 5f → 6d → 7p → 8s
     */
    public ArrayList<ElectronClass> findAtomElectronStructure(String atomName) {
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
        int numElectron = findAtomIndex(atomName);
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

    // will remove when build app in android
    public String displayAtomElectronStructure(String atomName) {
        ArrayList<ElectronClass> electronStructureList = findAtomElectronStructure(atomName);
        String electronStructure = "";
        for (ElectronClass ec: electronStructureList) {
            electronStructure = electronStructure + ec.index + ec.className + ec.numElectron + "-";
        }
        return electronStructure;
    }
    
    public ElementGroup classifyAtom(String atomName) {
        ElementGroup eg = new ElementGroup();
        ArrayList<ElectronClass> electronStructureList = findAtomElectronStructure(atomName);
        ElectronClass lastElectronClass = electronStructureList.get(electronStructureList.size() - 1);
        int numElectron = findAtomIndex(atomName);
        if (numElectron > 56 && numElectron < 72) {
            eg.groupName = 'B';
            eg.numIndex = "III";
            eg.isLantanoid = true;
        } else if (numElectron > 88 && numElectron < 104) {
            eg.groupName = 'B';
            eg.numIndex = "III";
            eg.isActinide = true;
        } else {
            switch (lastElectronClass.className) {
                case 's':
                    eg.groupName = 'A';
                    switch (lastElectronClass.numElectron) {
                        case 1:
                            eg.numIndex = "I";
                            break;
                        case 2:
                            eg.numIndex = "II";
                            break;
                    }
                    break;
                case 'p':
                    eg.groupName = 'A';
                    switch (lastElectronClass.numElectron) {
                        case 1:
                            eg.numIndex = "III";
                            break;
                        case 2:
                            eg.numIndex = "IV";
                            break;
                        case 3:
                            eg.numIndex = "V";
                            break;
                        case 4:
                            eg.numIndex = "VI";
                            break;
                        case 5:
                            eg.numIndex = "VII";
                            break;
                        case 6:
                            eg.numIndex = "VIII";
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
                            eg.numIndex = "III";
                            break;
                        case 4:
                            eg.numIndex = "IV";
                            break;
                        case 5:
                            eg.numIndex = "V";
                            break;
                        case 6:
                            eg.numIndex = "VI";
                            break;
                        case 7:
                            eg.numIndex = "VII";
                            break;
                        case 8:
                        case 9:
                        case 10:
                            eg.numIndex = "VIII";
                            break;
                        case 11:
                            eg.numIndex = "I";
                            break;
                        case 12:
                            eg.numIndex = "II";
                            break;
                    }
                    break;
            }
        }
        return eg;
    }

    // will remove when build app in android
    public String displayAtomGroup(String atomName) {
        ElementGroup eg = classifyAtom(atomName);
        if (!eg.isLantanoid && !eg.isActinide) return eg.numIndex + eg.groupName;
        else if (eg.isLantanoid) return eg.numIndex + eg.groupName + "and is lantanoid";
        else return eg.numIndex + eg.groupName + "and is actinide";
    }
}