package code.shelter.animals;

import javax.swing.JOptionPane;
public class JungleLemur extends Lemur {
  String coat;
  public static String[] Coats = {"Blue", "Brown", "Black"};
  
  
   public JungleLemur(boolean randomize, int x, int y){
    super( randomize,x,y);
    if(randomize){
      coat = Coats[(int)(Math.random() * (Coats.length -1))];
    }else{
      coat =   JOptionPane.showInputDialog(null, "Coat? Choose Black, Blue, or Brown");
    }
  }
   
   public void edit(){
     coat =   JOptionPane.showInputDialog(null, "Coat? Choose Black, Blue, or Brown");
    super.edit();
  }
  
  public String ToString(){
    String s = "JungleLemur: \n";
    s+= super.ToString(); 
    s+= coat + " coat\n"; 
    s+= "No mane\n"; 
    s+= "Travel in small groups\n"; 
    s+= "Eat mice, snails, and insects\n"; 
    return s;
  }
}