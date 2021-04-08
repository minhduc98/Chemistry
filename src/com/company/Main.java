package com.company;

import java.util.ArrayList;

public class Main
{
	public static void main(String[] args) {
		Mass mass = new Mass();
// 	    Analysis analysis = new Analysis();
// 		ArrayList<Analysis.ElementAnalyse> arr = analysis.compressMolecule("CH3COONa");
//         for (Analysis.ElementAnalyse ea : arr) {
//             System.out.println("Element is " + ea.Element + " valence is " + ea.Valence);
// 		}
        // double m = mass.findGasProportion("H2O", "H2");
        // System.out.println(m);
        double m = mass.findMassWithMol("K2[Fe(CN)4]", 0.1);
        System.out.println(m);
        
// 		double v1 = mass.findVolumeWithMol(1, "273K", "1Pa", "m3");
// 		System.out.println(v1);
	}
}

