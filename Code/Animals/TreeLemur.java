package Animals;

public class TreeLemur extends Lemur {
  
  public TreeLemur(boolean randomize, int x, int y){
    super(randomize,x,y);
  }
  
  public String ToString(){
    String s = "TreeLemur: \n";
    s+= super.ToString(); 
    s+= "Travel in large groups \n"; 
    s+= "Eat fruit \n"; 
    s+= "Have a red mane \n"; 
    return s;
  }
}