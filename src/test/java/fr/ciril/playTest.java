package fr.ciril;

import static org.junit.Assert.*;

import org.junit.Test;

public class playTest {
    Carte carte = new FileCarteBuilder().readCarteFromFile("carte_v2.txt");

    @Test
    public final void playTest1(){
        Aventurier aventurier = new FileInstructionsReader().readInstructionsFromFile("test1.txt").play(carte);
        assertEquals(9, aventurier.getPosX());
        assertEquals(2, aventurier.getPosY());
    }

    @Test
    public final void playTest2(){
        Aventurier aventurier = new FileInstructionsReader().readInstructionsFromFile("test2.txt").play(carte);
        assertEquals(1, aventurier.getPosX());
        assertEquals(9, aventurier.getPosY());
    }
}
