package com.company;

import java.util.*;

public class Mass {
    Analysis analysis = new Analysis();

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

    
    public double findMoleculeMass(String chemistryFormula) {
        ArrayList<Analysis.ElementAnalyse> chemFormula = analysis.compressMolecule(chemistryFormula);
        double mass = 0;
        for (Analysis.ElementAnalyse cf : chemFormula) {
            mass += findAtomMass(cf.Element) * cf.Valence;
        }
        return mass;
    }
    
    public double findGasProportion(String chemistryFormula1, String chemistryFormula2) {
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
