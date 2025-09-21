import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
import java.util.List;

/**
 * Die einzigen aktiven Akteure in der Roboterwelt sind die Roboter.
 * Die Welt besteht aus 14 * 10 Feldern.
 */

public class Planet extends World
{
    private static int zellenGroesse = 50;
    private int zeilen, spalten;

    /**
     * Erschaffe eine Welt mit 16 * 12 Zellen.
     */
    public Planet()
    {
        super(16, 12, zellenGroesse);
        spalten = 16;
        zeilen = 12;
        setBackground("images/boden.png");
        setPaintOrder(String.class, Display.class, Rover.class, Marke.class, Gestein.class, Huegel.class, DisplayBack.class);
        Greenfoot.setSpeed(20); 

        for (int i = 0; i < spalten; i++)
        {
            addObject(new DisplayBack(), i, zeilen-1);
        }

        prepare();
    }

    /*
     * fügt EINEN Actor (beliebigen Typs!) in die Welt ein.
     * Dabei werden folgende Regeln berücksichtigt:
     * Zeile zufaellig, aber nicht erste oder letzte, Spalte zufaellig
     * kein Actor darf auf einem bereits besetzten Feld liegen
     * 
     * Paramater:
     * Actor A: Das einzusetzende Objekt, in der Regel mit z.B. "new Wand()" direkt im Methodenaufruf erzeugt
     * randfelderErlaubt: gibt an, ob das Objekt auch auf den Randfelden landen arf
     * 
     */
    public void stelleActorAufFreiesFeld(Actor A, boolean randfelderErlaubt)
    {

        boolean neuerVersuch = true;
        int tempX, tempY;
        tempX = 0; //dummy-Wert, da sonst nicht komplilierbar
        tempY = 0;

        while(neuerVersuch)
        {
            if (randfelderErlaubt)
            {
                tempX = Greenfoot.getRandomNumber(getWidth()); //zufaellige Spalte
                tempY = Greenfoot.getRandomNumber(getHeight()-1);  //-1 weil die letzte Zeile wegen der Textausgabe nicht benutzt werden darf!

            }
            else
            {
                //zufaellige Spalte: es gibt 2 mögliche Zeilen weniger, als es in der Welt gibt. 
                //da die erste Zeile nicht möglich ist, +1
                tempX = Greenfoot.getRandomNumber(getWidth()-2)+1; //zufaellige Spalte
                //zufaellige Zeile: es gibt 2 mögliche Zeilen weniger, als es in der Welt gibt. 
                //da die erste Zeile nicht möglich ist, +1
                tempY = Greenfoot.getRandomNumber(getHeight()-3)+1;  //-3 weil die letzte Zeile wegen der Textausgabe nicht benutzt werden darf!

            }
            List l = getObjectsAt(tempX, tempY, null); 
            if (l == null || l.isEmpty())
            {
                neuerVersuch = false;
            }

            
        } //ende while - jetzt sollten tempX und tempY zulaessige Werte enthalten

        //jetzt kann die Wand eingefügt werden                       
        addObject(A, tempX, tempY);

    }

    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Rover rover = new Rover();
        addObject(rover,2,5);
        rover.setLocation(2,10);
        Huegel huegel = new Huegel();
        addObject(huegel,5,10);
        huegel.setLocation(5,10);
        Huegel huegel2 = new Huegel();
        addObject(huegel2,5,10);
        Huegel huegel3 = new Huegel();
        addObject(huegel3,6,10);
        Huegel huegel4 = new Huegel();
        addObject(huegel4,6,9);
        Huegel huegel5 = new Huegel();
        addObject(huegel5,7,8);
        Huegel huegel6 = new Huegel();
        addObject(huegel6,7,9);
        Huegel huegel7 = new Huegel();
        addObject(huegel7,8,7);
        Huegel huegel8 = new Huegel();
        addObject(huegel8,8,8);
        Huegel huegel9 = new Huegel();
        addObject(huegel9,9,6);
        Huegel huegel10 = new Huegel();
        addObject(huegel10,9,7);
        Huegel huegel11 = new Huegel();
        addObject(huegel11,10,5);
        Huegel huegel12 = new Huegel();
        addObject(huegel12,10,6);
        Huegel huegel13 = new Huegel();
        addObject(huegel13,11,5);
        Huegel huegel14 = new Huegel();
        addObject(huegel14,11,4);
        Huegel huegel15 = new Huegel();
        addObject(huegel15,11,6);
        Huegel huegel16 = new Huegel();
        addObject(huegel16,11,7);
        Huegel huegel17 = new Huegel();
        addObject(huegel17,11,8);
        Huegel huegel18 = new Huegel();
        addObject(huegel18,11,9);
        Huegel huegel19 = new Huegel();
        addObject(huegel19,11,10);
        Huegel huegel20 = new Huegel();
        addObject(huegel20,10,7);
        Huegel huegel21 = new Huegel();
        addObject(huegel21,10,8);
        huegel8.setLocation(8,8);
        Huegel huegel22 = new Huegel();
        addObject(huegel22,8,8);
        Huegel huegel23 = new Huegel();
        addObject(huegel23,9,9);
        Huegel huegel24 = new Huegel();
        addObject(huegel24,10,9);
        Huegel huegel25 = new Huegel();
        addObject(huegel25,9,8);
        Huegel huegel26 = new Huegel();
        addObject(huegel26,8,9);
        Huegel huegel27 = new Huegel();
        addObject(huegel27,8,10);
        Huegel huegel28 = new Huegel();
        addObject(huegel28,7,10);
        Huegel huegel29 = new Huegel();
        addObject(huegel29,10,10);
        Huegel huegel30 = new Huegel();
        addObject(huegel30,9,10);
        Marke marke = new Marke();
        addObject(marke,12,3);
    }
}