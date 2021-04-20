package com.company;

public class Atom {
    public class StableAtom {
        int protonNum;
        int neutralNom;
    }
    
    public StableAtom findAtom(String atomName) {
        StableAtom sa = new StableAtom();
        switch (atomName) {
            case "H": sa.protonNum = 1; sa.neutralNom = 1; break;
            case "Li": sa.protonNum = 3; sa.neutralNom = 4; break;
        }
        return sa;
    }
}
