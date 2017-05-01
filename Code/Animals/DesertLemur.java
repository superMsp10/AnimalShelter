package Animals;

public class DesertLemur extends Lemur {
  
  
  public DesertLemur(boolean randomize, int x, int y){
    super( randomize,x,y);
  }
  
  public String ToString(){
    String s = "DesertLemur: \n";
    s+= super.ToString(); 
    s+= "Obtain water from cacti\n"; 
    s+= "White coats reflect the desert heat\n"; 
    s+= "Two-thirds of the babies die due to puncture wounds from the cacti\n"; 
    return s;
  }
}