import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)import 


/**
 * Write a description of class Display here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Display extends Actor
{
     GreenfootImage bild; 

        public Display()
        {
            bild = getImage();
        }

        public void act() 
        {

        }  

        public void anzeigen(String pText)
        {
            loeschen();
            bild = new GreenfootImage(pText, 30, new Color(0,0,0), new Color(161, 218,243)); 
            getImage().drawImage(bild, 15,10);

        }

        public void loeschen()
        {
            if (getImage() != null)
            {
                getImage().clear();
            }
            setImage("images/nachricht.png");
        }

    
}
