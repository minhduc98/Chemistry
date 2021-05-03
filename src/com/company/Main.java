package com.company;

public class Main {

    public static void main(String[] args) {
        Mass mass = new Mass();
// 	    Analysis analysis = new Analysis();
// 		ArrayList<Analysis.ElementAnalyse> arr = analysis.compressMolecule("CH3COONa");
//         for (Analysis.ElementAnalyse ea : arr) {
//             System.out.println("Element is " + ea.Element + " valence is " + ea.Valence);
// 		}
        // double m = mass.findGasProportion("H2O", "H2");
        // System.out.println(m);
//        double m = mass.findMassWithMol("K2[Fe(CN)4]", 0.1);
//        System.out.println(m);

// 		double v1 = mass.findVolumeWithMol(1, "273K", "1Pa", "m3");
// 		System.out.println(v1);
        Atom atom = new Atom();
//        Atom.StableAtom a = atom.findAtom("H");
//		System.out.println(atom.displayAtomElectronStructure("Rn"));
//        System.out.println(atom.displayCompactAtomElectronStructure("Ac"));
//        atom.classifyAtom("Cu");
//		System.out.println(atom.displayAtomPosition("Au"));
//		System.out.println(atom.findAtomMass("H"));
        System.out.println(atom.classifyAtom("Cu"));
    }
}
