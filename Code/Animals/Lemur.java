package Animals;

public class Lemur extends Mammal {
  protected int maxAge = 50;
  protected int maxWeight = 100;
  
  public Lemur(boolean randomize, int x, int y){
    super(randomize, x, y);
    if(randomize){
      itsAge = (int)( Math.random() * maxAge + 1);
      itsWeight =  (int)(Math.random() * maxWeight + 10);
    }
  }
  
  
  public String ToString(){
    String s = "Lemur: \n";
    s+= super.ToString(); 
    s+= "Live in Madagascar \n";
    s+= "Have Fur \n";
    s+= "Prosimians \n";
    s+= "Groom using teeth as a comb \n";
    s+= "Females play dominant role \n";
    
    return s;
  }
}