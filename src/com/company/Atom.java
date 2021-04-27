package com.company;

import java.util.*;

public class Atom {
    public class StableAtom {
        int protonNum;
        int neutralNom;
    }

    public class QuantumNumber {
        int n;      // Principal quantum number
        int l;      // Azimuthal quantum number
        int ml;     // Magnetic quantum number
        double ms;     // Spin quantum number
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
            case "Cr": atomIndex = 24; break;
            case "Cu": atomIndex = 29; break;
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
            electronStructure = electronStructure + ec.index + ec.className + ec.numElectron;
        }
        return electronStructure;
    }
    
    public ElementGroup classifyAtom(String atomName) {
        ElementGroup eg = new ElementGroup();
        ArrayList<ElectronClass> electronStructureList = findAtomElectronStructure(atomName);
        ElectronClass lastElectronClass = electronStructureList.get(electronStructureList.size() - 1);
        switch (lastElectronClass.className) {
            case 's': 
                eg.groupName = 'A';
                switch (lastElectronClass.numElectron) {
                    case 1: eg.numIndex = "I"; break;
                    case 2: eg.numIndex = "II"; break;
                }
                break;
            case 'p':
                eg.groupName = 'A';
                switch (lastElectronClass.numElectron) {
                    case 1: eg.numIndex = "III"; break;
                    case 2: eg.numIndex = "IV"; break;
                    case 3: eg.numIndex = "V"; break;
                    case 4: eg.numIndex = "VI"; break;
                    case 5: eg.numIndex = "VII"; break;
                    case 6: eg.numIndex = "VIII"; break;
                }
                break;
            /*case 'd':
                eg.groupName = 'B';
                ElectronClass lastElectronClass = electronStructureList.get(electronStructureList.size() - 1);
                break;
            case 'f':
                eg.groupName = 'B';
                eg.numIndex = "III";
                break;*/
        }
        return eg;
    }

    public QuantumNumber findLastElectronQuantumNumber(String atomName) {
        QuantumNumber lastElectronQuantumNumber = new QuantumNumber();
        int numElectron = findAtomIndex(atomName);
        return lastElectronQuantumNumber;
    }
}