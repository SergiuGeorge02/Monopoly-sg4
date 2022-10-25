public class Application {
    InputDevice input;
    OutputDevice output;
    private int numPlayers, rounds;
    private Board b;
    private Player[] players;

    Application(InputDevice input, OutputDevice output, int num){
        this.input = input;
        this.output = output;
        b=new Board();
        numPlayers=num;
        players = new Player[10];
        for (int i = 0; i < getPlayers(); i++)
            players[i]= new Player(input.getName());
    }

    public int getPlayers() {
        return numPlayers;
    }

    public void setPlayers(int players) {
        this.numPlayers = players;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }
    public void run(){
        for(int i=0;i<getPlayers();i++) {
            for (int j = 0; j < getRounds(); j++) {
                int nr=input.throwDice();
                players[i].position=players[i].position+nr;
                if(players[i].position>=39){
                    players[i].money+=200;
                    b.bank=b.bank-200;
                    players[i].position=players[i].position-39;
                }
                if(b.squares[players[i].position] instanceof Property && players[i].money>=((Property)b.squares[players[i].position]).getPrice() && ((Property) b.squares[players[i].position]).getOwned()==0 )
                {
                    players[i].money=players[i].money-((Property) b.squares[players[i].position]).getPrice();


                        ((Property) b.squares[players[i].position]).setOwned();
                        ((Property)b.squares[players[i].position]).setPlayername(players[i].name);
                        players[i].properties+=1;



                }
                else if((b.squares[players[i].position] instanceof Property) && ((Property) b.squares[players[i].position]).getOwned() == 1  && ((Property)b.squares[players[i].position]).getUpgrade()==0)
                {
                    players[i].money=players[i].money-50;
                    for(int k=0;k<getPlayers();k++){
                        if(players[k].name.equals(((Property)b.squares[players[i].position]).getPlayername()))
                            players[k].money+=50;
                    }
                }
                else if((b.squares[players[i].position] instanceof Property) && ((Property) b.squares[players[i].position]).getOwned() == 1 && ((Property)b.squares[players[i].position]).getUpgrade()==1)

                {
                    players[i].money=players[i].money-100;
                    for(int k=0;k<getPlayers();k++){
                        if(players[k].name.equals(((Property)b.squares[players[i].position]).getPlayername()))
                            players[k].money+=100;
                    }
                }
                else if((b.squares[players[i].position] instanceof Property) && ((Property) b.squares[players[i].position]).getOwned() == 1 && ((Property)b.squares[players[i].position]).getPlayername().equals(players[i].name) && ((Property)b.squares[players[i].position]).getUpgrade()==1 &&players[i].money>100 && ((Property) b.squares[players[i].position]).getNotupgradable().equals("False") &&((Property) b.squares[players[i].position]).upgraded==0)
                {
                    players[i].money-=100;
                    ((Property) b.squares[players[i].position]).setUpgrade();
                    ((Property) b.squares[players[i].position]).setUpgraded();
                    players[i].properties+=1;
                }


            }
            propertiesvalue();
            output.writeMessage("Name: " + players[i].name + "\ncash: " + players[i].money );
            output.writeMessage("Position: " + b.squares[players[i].position%40].getName() + "\n");
        }

        Player winner=null;
        winner=new Player(input.getName());
        for(int i=0;i<getPlayers();i++) {

            if (players[i].money > winner.money) {
                winner.money = players[i].money;
                winner.position = players[i].position % 40;
                winner.name = players[i].name;
            }
            if (players[i].money == winner.money) {
                if(players[i].position % 40>winner.position)
                {
                    winner.name = players[i].name;
                    winner.position = players[i].position % 40;
                }

            }
        }
        output.writeMessage(" bank: " + b.bank+ "\n\nPlaces: ");
        for(int i=0;i<40;i++)
            output.writeMessage(b.squares[i].getName()+" ");
        output.writeMessage("\n"+"Players:\n");

        input.declare();
        output.writeMessage("The Winner of the game is: \n"+ "Name: " + winner.name);
    }
    public void propertiesvalue(){
        for(int i=0;i<getPlayers();i++){
                players[i].money+=players[i].properties*100;
        }
    }
}
