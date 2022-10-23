public class Property extends Square{
    private int upgrade=0;
    private int price=0;
    private int owned=0;
    private int tax=0;
    String playername="";
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
    void setPlayername(String playername1){
        this.playername=playername1;
    }
    void setOwned(){
        this.owned=1;
    }
    void setTax(int n){
        this.tax=n;
    }
}
