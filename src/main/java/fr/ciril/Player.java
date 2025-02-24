package fr.ciril;

public class Player {
    Aventurier aventurier;
    String instructionString;

    public Player(int charX, int charY, String instructionString){
        this.aventurier = new Aventurier(charX, charY);
        this.instructionString = instructionString;
    }

    /**
     * Simule la partie et renvoie l'aventurier à la fin
     * @return
     */
    public Aventurier play(Carte carte){
        for(char instruction: instructionString.toCharArray()){
            aventurier.move(carte, instruction);
        }
        return aventurier;
    }
}
