package com.company;

import java.util.ArrayList;

public class Main
{
	public static void main(String[] args) {
		Mass mass = new Mass();
	    Analysis analysis = new Analysis();
		ArrayList<Analysis.ElementAnalyse> arr = analysis.compressMolecule("[Fe(CN)4]K2");
        for (Analysis.ElementAnalyse ea : arr) {
            System.out.println("Element is " + ea.Element + " valence is " + ea.Valence);
		}
	}
}
