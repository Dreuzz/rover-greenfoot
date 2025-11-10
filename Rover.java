import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Rover extends Actor
{
    private Display anzeige;
    
    public String nullstellen(double a, double b, double c) {
        double p = b / a;
        double q = c / a;
        
        double erg1 = 
        
        //Math.sqrt();
        
        return "ja";
    }

    public int anzahlFelderBisHuegel() {
        int felderBisHuegel = 0;

        while(!huegelVorhanden("vorne")) {
            felderBisHuegel++;
            fahre();
        }
        return felderBisHuegel;
    }

    public void fahreInRichtungBisMarke(String pRichtung) {
        if(pRichtung == "vorne") {
            fahreBisMarke();
        }
        else if(pRichtung == "links") {
            drehe("links");
            fahreBisMarke();
        }
        else if(pRichtung == "rechts") {
            drehe("rechts");
            fahreBisMarke();
        }
        else if(pRichtung == "hinter") {
            drehe180();
            fahreBisMarke();
        }
        else {
            nachricht("Richtung ungültig");
        }
    }

    public void fahreBisMarke() {
        while(!markeVorhanden()) {
            fahre();
        }
    }

    public boolean gesteinVorhanden(String pRichtung) {

        if(pRichtung == "links") {
            drehe("links");
            boolean gesteinVorhanden = checkGestein();
            drehe("rechts");
            return gesteinVorhanden;
        }
        else if(pRichtung == "rechts") {
            drehe("rechts");
            boolean gesteinVorhanden = checkGestein();
            drehe("links");
            return gesteinVorhanden;
        }
        else if(pRichtung == "vorne") {
            boolean gesteinVorhanden = checkGestein();
            return gesteinVorhanden;
        }
        else if(pRichtung == "hinter") {
            drehe180();
            boolean gesteinVorhanden = checkGestein();
            drehe180();
            return gesteinVorhanden;
        }
        else {
            nachricht("Ungültig");
        }
        return false;
    }

    public boolean checkGestein() {

        if(!huegelVorhanden("vorne")) {
            fahre();
            if(gesteinVorhanden()) {
                fahreZumVorherigenFeld();
                drehe180();
                return true;
            }
            else {
                fahreZumVorherigenFeld();
                drehe180();
                return false;
            }
        }
        else {
            return false;
        }
    }

    public void fahreZumVorherigenFeld() {
        drehe("rechts");
        drehe("rechts");
        fahre();
    }

    public void drehe180() {
        drehe("rechts");
        drehe("rechts");
    }

    /**
     * Der Rover bewegt sich ein Feld in Fahrtrichtung weiter.
     * Sollte sich in Fahrtrichtung ein Objekt der Klasse Huegel befinden oder er sich an der Grenze der Welt befinden,
     * dann erscheint eine entsprechende Meldung auf dem Display.
     */
    public void fahre()
    {
        int posX = getX();
        int posY = getY();

        if(huegelVorhanden("vorne"))
        {
            nachricht("Zu steil!");
        }
        // dafï¿½r sorgen, dass der Rover nicht in die unterste Zeile fï¿½hrt...
        else if(getRotation()==90 && getY()==getWorld().getHeight()-2)
        {
            nachricht("Ich kann mich nicht bewegen");
        }
        else
        {
            move(1);
            Greenfoot.delay(1);
        }

        if(posX==getX()&&posY==getY()&&!huegelVorhanden("vorne"))
        {
            nachricht("Ich kann mich nicht bewegen");
        }
    }

    /**
     * Der Rover dreht sich um 90 Grad in die Richtung, die mit richtung (ï¿½linksï¿½ oder ï¿½rechtsï¿½) ï¿½bergeben wurde.
     * Sollte ein anderer Text (String) als "rechts" oder "links" ï¿½bergeben werden, dann erscheint eine entsprechende Meldung auf dem Display.
     */
    public void drehe(String richtung)
    {
        if(richtung=="rechts")
        {
            setRotation(getRotation()+90);
        }
        else if (richtung=="links")
        {
            setRotation(getRotation()-90);
        }
        else
        {
            nachricht("Befehl nicht korrekt!");
        }
    }

    /**
     * Der Rover gibt durch einen Wahrheitswert (true oder false )zurï¿½ck, ob sich auf seiner Position ein Objekt der Klasse Gestein befindet.
     * Eine entsprechende Meldung erscheint auch auf dem Display.
     */
    public boolean gesteinVorhanden()
    {
        if(getOneIntersectingObject(Gestein.class)!=null)
        {
            nachricht("Gestein gefunden!");
            return true;

        }

        return false;
    }

    /**
     * Der Rover ï¿½berprï¿½ft, ob sich in richtung ("rechts", "links", oder "vorne") ein Objekt der Klasse Huegel befindet.
     * Das Ergebnis wird auf dem Display angezeigt.
     * Sollte ein anderer Text (String) als "rechts", "links" oder "vorne" ï¿½bergeben werden, dann erscheint eine entsprechende Meldung auf dem Display.
     */
    public boolean huegelVorhanden(String richtung)
    {
        int rot = getRotation();

        if (richtung=="vorne" && rot==0 || richtung=="rechts" && rot==270 || richtung=="links" && rot==90)
        {
            if(getOneObjectAtOffset(1,0,Huegel.class)!=null && ((Huegel)getOneObjectAtOffset(1,0,Huegel.class)).getSteigung() >30)
            {
                return true;
            }
        }

        if (richtung=="vorne" && rot==180 || richtung=="rechts" && rot==90 || richtung=="links" && rot==270)
        {
            if(getOneObjectAtOffset(-1,0,Huegel.class)!=null && ((Huegel)getOneObjectAtOffset(-1,0,Huegel.class)).getSteigung() >30)
            {
                return true;
            }
        }

        if (richtung=="vorne" && rot==90 || richtung=="rechts" && rot==0 || richtung=="links" && rot==180)
        {
            if(getOneObjectAtOffset(0,1,Huegel.class)!=null && ((Huegel)getOneObjectAtOffset(0,1,Huegel.class)).getSteigung() >30)
            {
                return true;
            }

        }

        if (richtung=="vorne" && rot==270 || richtung=="rechts" && rot==180 || richtung=="links" && rot==0)
        {
            if(getOneObjectAtOffset(0,-1,Huegel.class)!=null && ((Huegel)getOneObjectAtOffset(0,-1,Huegel.class)).getSteigung() >30)
            {
                return true;
            }

        }

        if(richtung!="vorne" && richtung!="links" && richtung!="rechts")
        {
            nachricht("Befehl nicht korrekt!");
        }

        return false;
    }

    /**
     * Wenn an der Position des Rovers ein Gestein vorhanden ist, nimmt er es auf und gibt den Wassergehalt des
     * Gesteins aus.
     * Sollte kein Objekt der Klasse Gestein vorhanden sein, dann erscheint eine entsprechende Meldung auf dem Display.
     */
    public void nimmGestein()
    {
        if(gesteinVorhanden())
        {
            nachricht("Gestein untersucht! Wassergehalt ist " + ((Gestein)getOneIntersectingObject(Gestein.class)).getWassergehalt()+"%.");
            Greenfoot.delay(1);
            removeTouching(Gestein.class);
        }
        else 
        {
            nachricht("Hier ist kein Gestein");
        }
    }

    /**
     * Der Rover erzeugt ein Objekt der Klasse ï¿½Markierungï¿½ auf seiner Position.
     */
    public void setzeMarke()
    {
        getWorld().addObject(new Marke(), getX(), getY());
    }

    /**
     * *Der Rover gibt durch einen Wahrheitswert (true oder false )zurï¿½ck, ob sich auf seiner Position ein Objekt der Marke befindet.
     * Eine entsprechende Meldung erscheint auch auf dem Display.
     */
    public boolean markeVorhanden()
    {
        if(getOneIntersectingObject(Marke.class)!=null)
        {
            return true;
        }

        return false;
    }

    public void entferneMarke()
    {
        if(markeVorhanden())
        {
            removeTouching(Marke.class);
        }
    }

    public void nachricht(String pText)
    {

        if(anzeige!=null)
        {
            anzeige.anzeigen(pText);
            Greenfoot.delay(3);
            anzeige.loeschen();
        }
        else
        {
            System.out.println("Rover: \"" + pText + "\"");
        }
    }

    private void displayAusschalten()
    {
        getWorld().removeObject(anzeige);

    }

    protected void addedToWorld(World world)
    {

        setImage("images/rover.png");
        anzeige = new Display();
        world.addObject(anzeige, world.getWidth()/2, world.getHeight()-1);

        if(getY()==world.getHeight()-1)
        {
            setLocation(getX(),world.getHeight()-2);
        }
        anzeige.anzeigen("Ich bin bereit");
        this.nachricht("Ich bin bereit");

    }

}
