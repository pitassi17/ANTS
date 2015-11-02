package main;

import Input.*;

/**
 * Main/mother class for ANTS. 
 * 
 * Arguments from command line are gathered from this class.
 * 
 * @author Bryce Matsuda
 *
 */
public class Ants {
	
	public static void main(String[] args) {
		InputHandler ih = new InputHandler();
		// Read/barf out the raw data for now
		System.out.println(ih.readFile(args[0]));
	}
}
