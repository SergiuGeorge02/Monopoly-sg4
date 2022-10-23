public class Board {
//    String[] properties;
    Square[] squares;
    double bank;
    private String[] spaces = {"START",
            "Mediterranean Avenue",
            "Community Chest",
            "Baltic Avenue",
            "Income Tax",
            "Reading Railroad",
            "Oriental Avenue",
            "Chance",
            "Vermont Avenue",
            "Connecticut Avenue",
            "Jail",
            "St. Charles Place",
            "Electrical Company",
            "States Avenue",
            "Virginia Avenue",
            "Pennsylvania Railroad",
            "St. James Place",
            "Community Chest",
            "Tennessee Avenue",
            "New York Avenue",
            "Park",
            "Kentucky Avenue",
            "Chance",
            "Indiana Avenue",
            "Illinois Avenue",
            "B & O Railroad",
            "Atlantic Avenue",
            "Ventnor Avenue",
            "Water Works",
            "Marvin Gardens",
            "Go to Jail",
            "Pacific Avenue",
            "North Carolina Avenue",
            "Community Chest",
            "Pennsylvania Avenue",
            "Short Line",
            "Chance",
            "Park Place",
            "Luxury Tax",
            "Boardwalk"};
    public Board() {
        this.squares=new Square[spaces.length];
        for(int i=0;i< spaces.length;i++)
            if(spaces[i].equals("START") || spaces[i].equals("Jail") || spaces[i].equals("Community Chest")|| spaces[i].equals("Park") || spaces[i].equals("Go to Jail")||spaces[i].equals("Chance") ||spaces[i].equals("Park Place")||spaces[i].equals("Income Tax")||spaces[i].equals("Luxury Tax"))
                squares[i]=new Square(spaces[i]);
        else if(spaces[i].equals("Reading Railroad")||spaces[i].equals("Electrical Company")||spaces[i].equals("Pennsylvania Railroad")||spaces[i].equals("B & O Railroad")||spaces[i].equals( "Water Works")|| spaces[i].equals("Short Line"))
            squares[i]=new Property(spaces[i],0,100);
        else
            squares[i]=new Property(spaces[i],1,50);

        this.bank = 25000.0;
    }
}
