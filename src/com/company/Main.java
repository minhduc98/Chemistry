package com.company;

import java.util.ArrayList;

public class Main
{
	public static void main(String[] args) {
	    
	    Mass mass = new Mass();
		ArrayList<Mass.ElementAnalyse> arr = mass.compressMolecule("HCCH");
        for (Mass.ElementAnalyse ea : arr) {
            System.out.println("Element is " + ea.Element + " valence is " + ea.Valence);
        }
        // double test = mass.findProportion("H2", "Air");
        // System.out.println(test);
	}
}
