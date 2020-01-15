package tp1;
import java.io.*;
import java.text.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;
import java.awt.*;

import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class compilateur extends JFrame  {
	private JEditorPane editor;
    private File targetFile;
    public ArrayList<String> lignes = new ArrayList<String>();
	static ArrayList<String> mots = new ArrayList<String>();
	static ArrayList<String> motsyn = new ArrayList<String>();
	 public String motsyy[];
   public  TextArea textArea;
   public  TextArea textArea_1;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					compilateur frame = new compilateur();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public compilateur() {
	      setResizable(false);
	    editor = new JEditorPane();
		setTitle("Analyse Lexicale-Syntaxique-Semantique");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1119, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("    nom du fichier");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(339, 16, 535, 24);
		this.setLocationRelativeTo(null);
		contentPane.add(lblNewLabel);
	 textArea_1 = new TextArea();
	 textArea_1.setEditable(false);
		textArea_1.setBackground(Color.WHITE);
		textArea_1.setBounds(22, 164, 512, 408);
		textArea_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC,16));
		contentPane.add(textArea_1);
			 textArea= new TextArea();
			 textArea.setEditable(false);
			 textArea.setBackground(Color.WHITE);
			textArea.setBounds(588, 164, 500, 408);
			textArea.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC,16));
			contentPane.add(textArea);
			JLabel lblAnalyse = new JLabel("Analyse\r\n");
			lblAnalyse.setForeground(Color.WHITE);
			lblAnalyse.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
			lblAnalyse.setBounds(786, 127, 191, 31);
			contentPane.add(lblAnalyse);
		JButton btnNewButton = new JButton("Charger un fichier");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 motsyn = new ArrayList<String>();
				lblAnalyse.setText("Analyse");
				textArea.setText("");
				textArea_1.setText("");
				JFileChooser chooser=new JFileChooser("C:\\Users\\asri\\Desktop\\yacL3\\TP Kadour Yagoub\\TP1");
				/*FileNameExtensionFilter fich = new FileNameExtensionFilter("Fichiers Sna", "Snl");	
				chooser.setFileFilter(fich);*/
		
				 
		  
		    	
		    	
		    	if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
					File file = chooser.getSelectedFile();
					Scanner sc_lignes =new Scanner(System.in);
					Scanner sc_mots = new Scanner(System.in);
					try {  File f=chooser.getSelectedFile();
			    	String filename=f.getAbsolutePath();
						sc_lignes = new Scanner(f);
						sc_mots = new Scanner(f);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
					lignes.clear();
						while(sc_lignes.hasNextLine()){
							lignes.add(sc_lignes.nextLine());
						}
						while(sc_mots.hasNext()){
							mots.add(sc_mots.next());
							}
						
					sc_mots.close();
						

				
					sc_lignes.close();
					}
			for(int i=0;i<lignes.size();i++) {
				textArea_1.setText(textArea_1.getText()+"Line["+i+"] ::   ");
				textArea_1.setText(textArea_1.getText()+lignes.get(i)+"\n");
				
			}
		
			  File f=chooser.getSelectedFile();
		    	String filename=f.getAbsolutePath();
				lblNewLabel.setText(filename);
				
			}
		});
		
		btnNewButton.setBounds(66, 11, 198, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("LEXIQUALE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblAnalyse.setText("Lexicale");
				textArea.setText("");
			lex();
		
			}
		});
		btnNewButton_1.setBounds(66, 81, 285, 35);
		contentPane.add(btnNewButton_1);
		
		JButton btnSyntaxe = new JButton("SYNTAXE");
		btnSyntaxe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblAnalyse.setText("Syntaxique");
				textArea.setText("");
				Synt();
				
			}
		});
		btnSyntaxe.setBounds(423, 81, 249, 35);
		contentPane.add(btnSyntaxe);
		
		JButton btnSemantique = new JButton("SEMANTIQUE");
		btnSemantique.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblAnalyse.setText("Symantique");
				textArea.setText("");
				Symt();
			}


		});
		btnSemantique.setBounds(737, 81, 264, 35);
		contentPane.add(btnSemantique);
		
	
		JLabel lblLeCodeDu = new JLabel("le code du fichier");
		lblLeCodeDu.setForeground(Color.WHITE);
		lblLeCodeDu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblLeCodeDu.setBounds(174, 127, 222, 25);
		contentPane.add(lblLeCodeDu);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\pc.pc-PC\\Downloads\\2a5fdfcc0839f11483a45625d4c9f181.jpg"));
		lblNewLabel_1.setBounds(0, 0, 1113, 582);
		contentPane.add(lblNewLabel_1);

	}
    public  void  lex(){
    

    cmp ver = new cmp();
    int k=0;int i=0;
    for (int l=0;l<mots.size();l++) {
	int x=l-1;
	String m1="";

	String m=mots.get(l);
	if (l!=0) {m1=mots.get(x);}


if(m.equals("Start_Program")){textArea.setText(textArea.getText()+" ["+k+"]:   "+"Start_Program : mot reserver pour debut programme\n");}
else if(m.equals(",")||m.equals("<")||m.equals(">")||m.equals("<=")||m.equals(">=")||m.equals("--")) {textArea.setText(textArea.getText()+" ["+k+"]:   "+m+"  mot reserve\n");}
else if(m.equals("End_Program")){textArea.setText(textArea.getText()+" ["+k+"]:   "+"End_Program: mot reserver pour fin programme\n");}
else if(m.equals("Int_Number")){textArea.setText(textArea.getText()+" ["+k+"]:   "+"Int_Number : mot reserver pour declaration variable\n");}
else if(m.equals("Real_Number")){textArea.setText(textArea.getText()+" ["+k+"]:   "+"Real_Number : mot reserver pour declaration real\n");}
else if(m.equals("ShowMes")){textArea.setText(textArea.getText()+" ["+k+"]:   "+"ShowMess : mot reserver pour afficher mess\n");}
else if(m.equals("ShowVal")){textArea.setText(textArea.getText()+" ["+k+"]:   "+"ShowVal : mot reserver pour afficher val\n");}
else if(m.equals("Start")){textArea.setText(textArea.getText()+" ["+k+"]:   "+"Start :  mot reserver pour debut else\n");}
else if(m.equals("Else")){textArea.setText(textArea.getText()+" ["+k+"]:   "+"Else : mot reserver pour else\n");}
else if(m.equals("//.")){textArea.setText(textArea.getText()+" ["+k+"]:   "+"//. : mot reserver pour commentaire\n");}
else if(m.equals("to")){textArea.setText(textArea.getText()+" ["+k+"]:   "+"to : mot reserver pour affectation\n");}
else if(m.equals(";;")){textArea.setText(textArea.getText()+" ["+k+"]:   "+";; : mot reserver pour fin d instruction\n");}
else if(m.equals("Finish")){textArea.setText(textArea.getText()+" ["+k+"]:   "+"Finish : mot reserver pour fin de bloc else\n");}
else if(m.equals("If")){textArea.setText(textArea.getText()+" ["+k+"]:   "+"If: mot reserver pour condition\n");}
else if(m.equals("Give")){textArea.setText(textArea.getText()+" ["+k+"]:   "+"Give : mot reserver pour affecter une valeur\n");}
else if(m.equals("Affect")){textArea.setText(textArea.getText()+" ["+k+"]:   "+"Get : mot reserver pour Get\n");}
else if(m.equals("from")){textArea.setText(textArea.getText()+" ["+k+"]:   "+"From : mot reserver pour From\n");}
else if(m.equals("%")){textArea.setText(textArea.getText()+" ["+k+"]:   "+"% : mot  pour condition\n");}
else if(m.equals(":")){textArea.setText(textArea.getText()+" ["+k+"]:   "+" : mot  reserve\n");}
else if(m.startsWith("\"")){textArea.setText(textArea.getText()+" ["+k+"]:   \"  pour afficher\n");}
else if (ver.isIdent(m)) {textArea.setText(textArea.getText()+" ["+k+"]:   "+m+" identifiant\n");}
else if(ver.isInteger(m)) {textArea.setText(textArea.getText()+" ["+k+"]:   "+m+" entier\n");}
else if(ver.isRealNumber(m)) {textArea.setText(textArea.getText()+" ["+k+"]:   "+m+" real\n");}


else{textArea.setText(textArea.getText()+"["+k+"]:   "+"  erreur lexicale\n");}
x++;

k++;
}

}
	public void Symt() {
    	cmp ver = new cmp();
    	for(int i=0;i<lignes.size();i++) {
    	int h=0;
    		String k=lignes.get(i); 
    		Scanner sc_mots = new Scanner(System.in);
    		sc_mots = new Scanner(lignes.get(i));
    		ArrayList<String> motsyn = new ArrayList<String>();
			while(sc_mots.hasNext()){
				motsyn.add(sc_mots.next());
				}
			   sc_mots.close();   		
    	String x = motsyn.get(0);
    		// System.out.println(motsyn.size());
 if(x.equals("Start")&&motsyn.size()==1){textArea.append("{");}
else if(x.equals("Else")&&motsyn.size()==1){textArea.append("else");}
else if(x.equals("Finish")&&motsyn.size()==1){textArea.append("}");}
else if(x.equals("Start_Program")&&motsyn.size()==1){textArea.append("\npublic static void main(String [ ] args) {\n");}
else if(x.equals("End_Program")&&motsyn.size()==1){textArea.append("\n } \n");}
else if(x.equals("//.")){/*textArea.append("Line ["+i+"]:   "+k+" : commentaire\n");*/}
else if(x.equals("Give")&& motsyn.size()==5 && ver.isIdent(motsyn.get(1))&& motsyn.get(2).equals(":")&&(ver.isInteger(motsyn.get(3))||ver.isRealNumber(motsyn.get(3)))
&&motsyn.get(4).equals(";;")){textArea.append("\n"+motsyn.get(1)+" = "+motsyn.get(3)+";\n");	
}
else if (x.equals("ShowMes")&& motsyn.get(1).equals(":")&&motsyn.get(motsyn.size()-1).equals(";;")&& motsyn.get(2).equals("\"")&&motsyn.get(motsyn.size()-2).equals("\"") ) {
  motsyn.remove(0);
  motsyn.remove(0);
  String message="";
  motsyn.remove(motsyn.size()-1);
  for(int z=0;z<motsyn.size();z++) {
	  message = message+" "+motsyn.get(z);
  }
  textArea.append("\nSystem.out.println("+message+");\n");
}
else if (motsyn.size()==4 &&x.equals("ShowVal")&& motsyn.get(1).equals(":")&&motsyn.get(3).equals(";;")&& ver.isIdent(motsyn.get(2)))  {
	textArea.append("System.out.println( "+motsyn.get(2)+" );\n");
}
else if (motsyn.size()==5 &&x.equals("Affect")&&  ver.isIdent(motsyn.get(1))&&motsyn.get(2).equals("to")&& ver.isIdent(motsyn.get(3)))  {
	textArea.append("\n"+motsyn.get(1)+" = "+motsyn.get(3)+";");
}
else if (motsyn.size()==6 &&x.equals("If")&&motsyn.get(1).equals("--")&&motsyn.get(motsyn.size()-1).equals("--")
    && (motsyn.get(3).equals("<")||motsyn.get(3).equals(">")||motsyn.get(3).equals("<=")||motsyn.get(3).equals(">=")||motsyn.get(3).equals("==")||motsyn.get(3).equals("!="))
    && (ver.isIdent(motsyn.get(2))||ver.isInteger(motsyn.get(2))||ver.isRealNumber(motsyn.get(2)))
	&&(ver.isIdent(motsyn.get(4))||ver.isInteger(motsyn.get(4))||ver.isRealNumber(motsyn.get(4)))) {
	textArea.append("\n If ( "+motsyn.get(2)+" "+motsyn.get(3)+" "+motsyn.get(4)+" )");
}
else if(x.equals("Real_Number")&&motsyn.size()==3 && motsyn.get(2).equals(";;")&&ver.isIdent(motsyn.get(1))) {
	
	textArea.append("float "+motsyn.get(1)+";");
}
else if (x.equals("Real_Number")&&motsyn.get(1).equals(":")&&motsyn.get(motsyn.size()-1).equals(";;")) {
	int r =2; while(!motsyn.get(r).equals(";;")) {
	              if (ver.isIdent(motsyn.get(r))&&motsyn.get(r+1).equals(",")){
	            	  r =r+2;
	              }
	              else {break;}
} 
	if(r==motsyn.size()-2) {
		
		motsyn.remove(0);
		motsyn.remove(0);
		String m ="";
		motsyn.remove(motsyn.size()-1);
		  for(int z=0;z<motsyn.size();z++) {
			  m = m+motsyn.get(z);
			 
		  }
		  textArea.append("float "+m+";\n");
	}
	
}
 
else if(x.equals("Int_Number")&&motsyn.size()==3 && motsyn.get(2).equals(";;")&&ver.isIdent(motsyn.get(1))) {
	textArea.append("int "+motsyn.get(1)+";");
}
else if (x.equals("Int_Number")&&motsyn.get(1).equals(":")&&motsyn.get(motsyn.size()-1).equals(";;")) {
	int r =2; while(!motsyn.get(r).equals(";;")) {
	              if (ver.isIdent(motsyn.get(r))&&motsyn.get(r+1).equals(",")){
	            	  r =r+2;
	              }
	              else {break;}
} 
	if(r==motsyn.size()-2) {
		
		motsyn.remove(0);
		motsyn.remove(0);
		String m ="";
		motsyn.remove(motsyn.size()-1);
		  for(int z=0;z<motsyn.size();z++) {
			  m = m+motsyn.get(z);
			 
		  }
		  textArea.append("int "+m+";\n");
	}
	
}
else {
	textArea.append("\nLine ["+i+"]   :Erreur Symantique\n");
	
}}
		
	}
    
    public void Synt() {
     
    	cmp ver = new cmp();
    	for(int i=0;i<lignes.size();i++) {
    	int h=0;
    		String k=lignes.get(i); 
    		Scanner sc_mots = new Scanner(System.in);
    		sc_mots = new Scanner(lignes.get(i));
    		ArrayList<String> motsyn = new ArrayList<String>();
			while(sc_mots.hasNext()){
				motsyn.add(sc_mots.next());
				}
			   sc_mots.close();
	//for(int y=0 ;y<motsyn.size();y++)	{}
	
	
    	//	int b=motsyn.size()-1;
			   
    	
    		
    	String x = motsyn.get(0);
    		// System.out.println(motsyn.size());
 if(x.equals("Start")&&motsyn.size()==1){textArea.append("Line ["+i+"]:   "+"Start :  mot reserver pour debut else\n");}
else if(x.equals("Else")&&motsyn.size()==1){textArea.append("Line ["+i+"]:   "+"Else : mot reserver pour else\n");}
else if(x.equals("Finish")&&motsyn.size()==1){textArea.append("Line ["+i+"]:   "+"Finish : mot reserver pour fin de bloc else\n");}
else if(x.equals("Start_Program")&&motsyn.size()==1){textArea.append("Line ["+i+"]:   "+"Start_Program: mot reserver pour debut programme\n");}
else if(x.equals("End_Program")&&motsyn.size()==1){textArea.append("Line ["+i+"]:   "+"End_Program : mot reserver pour fin programme\n");}
else if(x.equals("//.")){textArea.append("Line ["+i+"]:   "+k+" : commentaire\n");}
else if(x.equals("Give")&& motsyn.size()==5 && ver.isIdent(motsyn.get(1))&& motsyn.get(2).equals(":")&&(ver.isInteger(motsyn.get(3))||ver.isRealNumber(motsyn.get(3)))
&&motsyn.get(4).equals(";;")){textArea.append("Line ["+i+"]:   "+k+"  affectation\n");	
}
else if (x.equals("ShowMes")&& motsyn.get(1).equals(":")&&motsyn.get(motsyn.size()-1).equals(";;")&& motsyn.get(2).equals("\"")&&motsyn.get(motsyn.size()-2).equals("\"") ) {
	textArea.append("Line ["+i+"]:   "+k+" :message\n");
}
else if (motsyn.size()==4 &&x.equals("ShowVal")&& motsyn.get(1).equals(":")&&motsyn.get(3).equals(";;")&& ver.isIdent(motsyn.get(2)))  {
	textArea.append("Line ["+i+"]:   "+k+" :afficher une variable\n");
}
else if (motsyn.size()==5 &&x.equals("Affect")&&  ver.isIdent(motsyn.get(1))&&motsyn.get(2).equals("to")&& ver.isIdent(motsyn.get(3)))  {
	textArea.append("Line ["+i+"]:   "+k+" :affectation\n");
}
else if (motsyn.size()==6 &&x.equals("If")&&motsyn.get(1).equals("--")&&motsyn.get(motsyn.size()-1).equals("--")
    && (motsyn.get(3).equals("<")||motsyn.get(3).equals(">")||motsyn.get(3).equals("<=")||motsyn.get(3).equals(">=")||motsyn.get(3).equals("==")||motsyn.get(3).equals("!="))
    && (ver.isIdent(motsyn.get(2))||ver.isInteger(motsyn.get(2))||ver.isRealNumber(motsyn.get(2)))
	&&(ver.isIdent(motsyn.get(4))||ver.isInteger(motsyn.get(4))||ver.isRealNumber(motsyn.get(4)))) {
	textArea.append("Line ["+i+"]:   "+k+" :condition\n");
}
else if(x.equals("Real_Number")&&motsyn.size()==3 && motsyn.get(2).equals(";;")&&ver.isIdent(motsyn.get(1))) {
	textArea.append("Line ["+i+"]:   "+k+" :declaration d'une variable\n");
}
else if (x.equals("Real_Number")&&motsyn.get(1).equals(":")&&motsyn.get(motsyn.size()-1).equals(";;")) {
	int r =2; while(!motsyn.get(r).equals(";;")) {
	              if (ver.isIdent(motsyn.get(r))&&motsyn.get(r+1).equals(",")){
	            	  r =r+2;
	              }
	              else {break;}
} 
	if(r==motsyn.size()-2) {
		
		textArea.append("Line ["+i+"]:   "+k+" :declaration des var real\n");
	}
	
}
 
else if(x.equals("Int_Number")&&motsyn.size()==3 && motsyn.get(2).equals(";;")&&ver.isIdent(motsyn.get(1))) {
	textArea.append("Line ["+i+"]:   "+k+" :declaration d'un entier\n");
}
else if (x.equals("Int_Number")&&motsyn.get(1).equals(":")&&motsyn.get(motsyn.size()-1).equals(";;")) {
	int r =2; while(!motsyn.get(r).equals(";;")) {
	              if (ver.isIdent(motsyn.get(r))&&motsyn.get(r+1).equals(",")){
	            	  r =r+2;
	              }
	              else {break;}
} 
	if(r==motsyn.size()-2) {
		
		textArea.append("Line ["+i+"]:   "+k+" :declaration des var int\n");
	}
	
}
else {
	textArea.append("Line ["+i+"]   :Erreur Syntaxique\n");
	
}}}}
 
 
