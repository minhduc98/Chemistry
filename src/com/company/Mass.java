package com.company;

import java.util.*;

public class Mass {
    Analysis analysis = new Analysis();
    Atom atom = new Atom();
    
    public double findMoleculeMass(String chemistryFormula) {
        ArrayList<Analysis.ElementAnalyse> chemFormula = analysis.compressMolecule(chemistryFormula);
        double mass = 0;
        for (Analysis.ElementAnalyse cf : chemFormula) {
            mass += atom.findAtomMass(cf.Element) * cf.Valence;
        }
        return mass;
    }
    
    public double findGasProportion(String chemistryFormula1, String chemistryFormula2) {
        double ratio;
        double m1 = findMoleculeMass(chemistryFormula1);
        System.out.println(m1);
        if (chemistryFormula2.equals("Air")) {
            ratio = m1 / 29;
        } else {
            double m2 = findMoleculeMass(chemistryFormula2);
            ratio = m1/m2;
        }
        return ratio;
    }
    
    public double findMassWithMol(String chemistryFormula, double mol) {
        double moleculeMass = findMoleculeMass(chemistryFormula);
        return moleculeMass * mol;
    }
    
    public double calculateRConstant(String pressureUnit, String volumeUnit) {
        double R = 0;
        if (volumeUnit.equals("m3") && pressureUnit.equals("Pa")) {
            R = 8.314;
        }
        if (volumeUnit.equals("l") && pressureUnit.equals("atm")){
            R = 0.082;
        }
        return R;
    }
    
    public double findVolumeWithMol(double mol, String temperatureWithUnit, String pressureWithUnit, String volumeUnit) {
        char[] tempWithUnitChar = temperatureWithUnit.toCharArray();
        char[] pressureWithUnitChar = pressureWithUnit.toCharArray();
        
        String pUnit = "";
        String tempNum = "";
        String pNum = "";
        char tempUnit = 'K';
        
        double temperature = 0;
        double pressure = 0;
        
        for (int i = 0; i < tempWithUnitChar.length; i++) {
            if (Character.isDigit(tempWithUnitChar[i]) || tempWithUnitChar[i] == '.') {
                tempNum += tempWithUnitChar[i];
            } else {
                tempUnit = tempWithUnitChar[i];
            }
        }
        for (int i = 0; i < pressureWithUnitChar.length; i++) {
            if (Character.isDigit(pressureWithUnitChar[i]) || pressureWithUnitChar[i] == '.') {
                pNum += pressureWithUnitChar[i];
            } else {
                pUnit += pressureWithUnitChar[i];
            }
        }
        
        temperature = Double.valueOf(tempNum);
        pressure = Double.valueOf(pNum);
        
        if (tempUnit == 'C') {
            temperature = temperature + 273;
        } else if (temperature == 'F') {
            temperature = (temperature - 32) * 5 / 9;
        }
        double R = calculateRConstant(pUnit, volumeUnit);
        
        double V = mol * R * temperature / pressure;
        
        return V;
    }


}