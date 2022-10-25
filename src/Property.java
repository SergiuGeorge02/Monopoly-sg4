public class Property extends Square{
    private int upgrade=0;
    private int price=0;
    private int owned=0;
    private int tax=0;
    public int upgraded=0;

  private  String playername="";
  private String notupgradable="True";
    public Property(String name, int upgrade,int price){
        super(name);
        this.upgrade=upgrade;
        this.price=price;

    }
    public int getUpgrade(){
        return upgrade;
    }
    public int getPrice(){
        return price;
    }
    public void setPrice(int p){
        this.price+=p;
    }
  public  void setPlayername(String playername1){
        this.playername=playername1;
    }
    int getOwned(){
        return owned;
    }
  void setNotupgradable(){
       this.notupgradable="False";
  }
    void setOwned(){
        this.owned=1;
    }
    void setTax(int n){
        this.tax=n;
    }
public String getPlayername(){
        return playername;
}
public void setUpgrade(){
        upgrade=1;
}
public String getNotupgradable()
{
    return notupgradable;
}
public void setUpgraded(){
        upgrade=1;
}
}
