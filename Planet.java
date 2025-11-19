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
        super(20, 20, zellenGroesse);
        spalten = 0;
        zeilen = 20;
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
        Huegel huegel = new Huegel();
        addObject(huegel,5,7);
        Huegel huegel2 = new Huegel();
        addObject(huegel2,5,8);
        Huegel huegel3 = new Huegel();
        addObject(huegel3,5,10);
        Huegel huegel4 = new Huegel();
        addObject(huegel4,5,12);
        Huegel huegel5 = new Huegel();
        addObject(huegel5,6,12);
        Huegel huegel6 = new Huegel();
        addObject(huegel6,6,6);
        Huegel huegel7 = new Huegel();
        addObject(huegel7,7,6);
        Huegel huegel8 = new Huegel();
        addObject(huegel8,8,6);
        Huegel huegel9 = new Huegel();
        addObject(huegel9,9,6);
        Huegel huegel10 = new Huegel();
        addObject(huegel10,10,6);
        Huegel huegel11 = new Huegel();
        addObject(huegel11,11,6);
        Huegel huegel12 = new Huegel();
        addObject(huegel12,12,6);
        Huegel huegel13 = new Huegel();
        addObject(huegel13,13,6);
        Huegel huegel14 = new Huegel();
        addObject(huegel14,12,5);
        Huegel huegel15 = new Huegel();
        addObject(huegel15,12,8);
        Huegel huegel16 = new Huegel();
        addObject(huegel16,13,8);
        Huegel huegel17 = new Huegel();
        addObject(huegel17,14,8);
        Huegel huegel18 = new Huegel();
        addObject(huegel18,15,8);
        Huegel huegel19 = new Huegel();
        addObject(huegel19,15,9);
        Huegel huegel20 = new Huegel();
        addObject(huegel20,13,11);
        Huegel huegel21 = new Huegel();
        addObject(huegel21,12,10);
        Huegel huegel22 = new Huegel();
        addObject(huegel22,12,11);
        Huegel huegel23 = new Huegel();
        addObject(huegel23,11,7);
        Huegel huegel24 = new Huegel();
        addObject(huegel24,11,9);
        Huegel huegel25 = new Huegel();
        addObject(huegel25,11,12);
        Huegel huegel26 = new Huegel();
        addObject(huegel26,7,12);
        Huegel huegel27 = new Huegel();
        addObject(huegel27,8,12);
        Huegel huegel28 = new Huegel();
        addObject(huegel28,6,11);
        Huegel huegel29 = new Huegel();
        addObject(huegel29,7,11);
        Huegel huegel30 = new Huegel();
        addObject(huegel30,8,11);
        Huegel huegel31 = new Huegel();
        addObject(huegel31,9,11);
        Huegel huegel32 = new Huegel();
        addObject(huegel32,10,11);
        Huegel huegel33 = new Huegel();
        addObject(huegel33,11,11);
        huegel14.setLocation(11,5);
        huegel23.setLocation(10,7);
        huegel15.setLocation(11,8);
        huegel13.setLocation(16,13);
        huegel16.setLocation(12,8);
        huegel17.setLocation(13,8);
        huegel18.setLocation(14,8);
        huegel19.setLocation(14,9);
        huegel24.setLocation(10,9);
        huegel21.setLocation(11,10);
        huegel20.setLocation(11,13);
        huegel25.setLocation(10,12);
        huegel20.setLocation(6,9);
        huegel13.setLocation(10,10);
        Huegel huegel34 = new Huegel();
        addObject(huegel34,9,10);
        Huegel huegel35 = new Huegel();
        addObject(huegel35,6,10);
        Huegel huegel36 = new Huegel();
        addObject(huegel36,7,10);
        Huegel huegel37 = new Huegel();
        addObject(huegel37,7,9);
        Huegel huegel38 = new Huegel();
        addObject(huegel38,8,9);
        Huegel huegel39 = new Huegel();
        addObject(huegel39,8,10);
        Huegel huegel40 = new Huegel();
        addObject(huegel40,9,9);
        Huegel huegel41 = new Huegel();
        addObject(huegel41,9,8);
        Huegel huegel42 = new Huegel();
        addObject(huegel42,10,8);
        Huegel huegel43 = new Huegel();
        addObject(huegel43,8,7);
        Huegel huegel44 = new Huegel();
        addObject(huegel44,7,7);
        Huegel huegel45 = new Huegel();
        addObject(huegel45,6,7);
        Huegel huegel46 = new Huegel();
        addObject(huegel46,6,8);
        Huegel huegel47 = new Huegel();
        addObject(huegel47,7,8);
        Huegel huegel48 = new Huegel();
        addObject(huegel48,8,8);
        Huegel huegel49 = new Huegel();
        addObject(huegel49,9,7);
        Gestein gestein = new Gestein();
        addObject(gestein,5,6);
        Rover rover = new Rover();
        addObject(rover,7,5);
    }
}