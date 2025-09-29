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
        addObject(rover,2,4);
        Huegel huegel = new Huegel();
        addObject(huegel,9,4);
        Huegel huegel2 = new Huegel();
        addObject(huegel2,8,9);
        Gestein gestein = new Gestein();
        addObject(gestein,8,4);
        Gestein gestein2 = new Gestein();
        addObject(gestein2,13,8);
        gestein2.setLocation(4,1);
        Huegel huegel3 = new Huegel();
        addObject(huegel3,14,8);
        Huegel huegel4 = new Huegel();
        addObject(huegel4,13,0);
        Huegel huegel5 = new Huegel();
        addObject(huegel5,3,1);
        gestein2.setLocation(4,6);
        huegel5.setLocation(5,1);
        gestein2.setLocation(6,7);
        gestein2.setLocation(6,6);
        Huegel huegel6 = new Huegel();
        addObject(huegel6,6,7);
        Huegel huegel7 = new Huegel();
        addObject(huegel7,0,6);
        Marke marke = new Marke();
        addObject(marke,1,6);
        Huegel huegel8 = new Huegel();
        addObject(huegel8,15,1);
        Marke marke2 = new Marke();
        addObject(marke2,15,2);
        Marke marke3 = new Marke();
        addObject(marke3,3,10);
        Huegel huegel9 = new Huegel();
        addObject(huegel9,2,10);
        Huegel huegel10 = new Huegel();
        addObject(huegel10,1,0);
        Gestein gestein3 = new Gestein();
        addObject(gestein3,0,0);
        Gestein gestein4 = new Gestein();
        addObject(gestein4,4,1);
        Gestein gestein5 = new Gestein();
        addObject(gestein5,8,10);
        marke.setLocation(1,1);
        Gestein gestein6 = new Gestein();
        addObject(gestein6,1,6);
        Marke marke4 = new Marke();
        addObject(marke4,5,4);
        Gestein gestein7 = new Gestein();
        addObject(gestein7,8,7);
    
    }
}