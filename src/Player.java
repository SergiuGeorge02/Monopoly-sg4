public class Player {
    String name;
    public int properties=0;
    int money;
    public int position;
    public Player(String name){
        this.position=1;
        this.name=name;
        this.money=0;
    }
    public String getName(){
        return name;
    }

}
