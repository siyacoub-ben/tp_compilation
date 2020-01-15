
package tp1;
	import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.BorderLayout;
import java.io.*;
import java.text.*;
import javax.swing.*;
import java.awt.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextField;
import java.awt.TextArea;

	 
	public class cmp{
		private static JEditorPane  editor = new JEditorPane();;
	    private static  File targetFile;	    	

	public  boolean isInteger(String str){
        return str.matches("[\\-]\\d+|\\d+");
    }
	public boolean isIdent(String str) {
		return str.matches("\\b([A-Za-z][A-Za-z0-9_]*)\\b");
	}

	  public  boolean isRealNumber(String str){
	        return str.matches("[\\-\\d]\\d+\\.\\d+|\\d+\\.\\d+");
	    }
	   public boolean gui(char x ) {
	    	 if (x=='"') {
	    	 return true;}
	    	 else return false;
	     }

     public static boolean isNumeric(String str)
     {
         return str.matches("[+-]?\\d*(\\.\\d+)?" );
     }}
	    
        
	            	
	               
	                        
	  