package com.company;

import java.util.ArrayList;

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
        }
        return atomIndex;
    }
    /*
        s: 2; p: 6; d: 10; f: 14
        1s → 2s → 2p → 3s → 3p → 4s → 3d → 4p → 5s → 4d → 5p → 6s → 4f → 5d → 6p → 7s → 5f → 6d → 7p → 8s
     */
    public ArrayList<ElectronClass> findAtomElectronStructure(String atomName) {
        ArrayList<ElectronClass> electronStructure = new ArrayList<>();
        int numElectron = findAtomIndex(atomName);
        if (numElectron < 3) {  // 1s class
            electronStructure.add(new ElectronClass(1, 's', numElectron));
        } else {
            electronStructure.add(new ElectronClass(1, 's', 2));
            if (numElectron < 5) {  // 2s class
                electronStructure.add(new ElectronClass(2, 's', numElectron - 2));
            } else {
                electronStructure.add(new ElectronClass(2, 's', 2));
                if (numElectron < 11) {     // 2p class
                    electronStructure.add(new ElectronClass(2, 'p', numElectron - 4));
                } else {
                    electronStructure.add(new ElectronClass(2, 'p', 6));
                    // Will do in rest time
                }
            }
        }
        return electronStructure;
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

    public QuantumNumber findLastElectronQuantumNumber(String atomName) {
        QuantumNumber lastElectronQuantumNumber = new QuantumNumber();
        int numElectron = findAtomIndex(atomName);
        return lastElectronQuantumNumber;
    }
}
