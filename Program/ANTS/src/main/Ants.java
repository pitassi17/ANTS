package main;

import java.io.File;

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
		InputHandler ih = new InputHandler(new File(args[0]));
		ih.readFile();
	}
}
