/*
 * <pre> 
 * Class: <b>AbstractVehicle</b> 
 * File: AbstractVehicle.java 
 * Course: TCSS 305 – Autumn 2015
 * Assignment 3 – Easy Street
 * Copyright 2015 Benjamin Abdipour
 * </pre>
 */

package model;

/**
 * <pre>
 * This class is the abstract class of a vehicle including all common behaviors of all 
 *      vehicles. The methods of this class are accessible for the child classes.
 * </pre>
 * 
 * @author Benjamin Abdipour
 * @version 10/27/2015
 * @since October 19, 2015
 */

public abstract class AbstractVehicle implements Vehicle {

    /**
     * Instance variable, an integer containing the x position of the item.
     */
    private int myX;

    /**
     * Instance variable, an integer containing the y position of the item.
     */
    private int myY;

    /**
     * Instance variable, an integer containing the initial x position of the
     * item.
     */
    private final int myInitialX;

    /**
     * Instance variable, an integer containing the initial y position of the
     * item.
     */
    private final int myInitialY;

    /**
     * Instance variable, the initial direction of the item.
     */
    private final Direction myInitialDirection;

    /**
     * Instance variable, the direction of the item.
     */
    private Direction myDirection;

    /**
     * Instance variable, an integer containing the death time of the item. The
     * lesser death time means the vehicle is stronger and wins the collision.
     */
    private final int myDeathTime;

    /**
     * Instance variable, a boolean stating the alive or dead status of the
     * item.
     */
    private boolean myIsAlive = true;

    /**
     * Instance variable, an integer counting the number of pokes of an item.
     * Each poke represents a frame of animation.
     */
    private int myPokeCounter;

    /**
     * The constructor of the class.
     * @param theX The x position
     * @param theY The y position
     * @param theDir The direction
     * @param theDeathTime The death time
     */
    protected AbstractVehicle(final int theX, final int theY, final Direction theDir,
                              final int theDeathTime) {
        myInitialX = theX;
        myInitialY = theY;
        myInitialDirection = theDir;
        setX(theX);
        setY(theY);
        setDirection(theDir);
        myDeathTime = theDeathTime;
        myPokeCounter = 0;
    }

    /**
     * The method that returns the dead or alive status of the item.
     * 
     * @return boolean Dead or alive. True means alive and false menas dead.
     */
    public boolean isAlive() {
        return myIsAlive;
    }

    /**
     * The method puts an item in a collision position meaning that the item has
     * collided.
     * 
     * @param theOther The other vehicle that causes collision.
     */
    public void collide(final Vehicle theOther) {
        if (isAlive() && theOther.isAlive() && getDeathTime() > theOther.getDeathTime()) {
            myIsAlive = false;
        }
    }

    /**
     * The method returns the proper name of the image file name corresponding
     * to the item.
     * 
     * @return String The name of the image file corresponding to the item.
     */
    public String getImageFileName() {
        String localFileName;
        if (isAlive()) {
            localFileName = getClass().getSimpleName().toLowerCase() + ".gif";
        } else {
            localFileName = getClass().getSimpleName().toLowerCase() + "_dead.gif";
        }

        return localFileName;
    }

    /**
     * The method returns the death time of the item.
     * 
     * @return int The death time of the item.
     */
    public int getDeathTime() {

        return myDeathTime;
    }

    /**
     * The method returns the direction of the item.
     * 
     * @return Direction The direction of the item.
     */
    public Direction getDirection() {
        return myDirection;
    }

    /**
     * The method returns the x position of the item.
     * 
     * @return int The x position of the item.
     */
    public int getX() {
        return myX;
    }

    /**
     * The method returns the y position of the item.
     * 
     * @return int The y position of the item.
     */
    public int getY() {
        return myY;
    }

    /**
     * The method triggers one poke meaning that the item in collide status has
     * passed one more frame in the animation. The items revive after certain
     * number of pokes.
     */
    public void poke() {
        if (!myIsAlive && myPokeCounter < myDeathTime) {
            myPokeCounter++;
        } else if (!myIsAlive && myPokeCounter == myDeathTime) {
            myIsAlive = true;
            setDirection(Direction.random());
            myPokeCounter = 0;
        }
    }

    /**
     * The method resets the item's x and y positions and their pokes and their
     * dead or alive status.
     */
    public void reset() {

        setX(myInitialX);
        setY(myInitialY);
        setDirection(myInitialDirection);
        myIsAlive = true;
        setDirection(Direction.random());
        myPokeCounter = 0;
    }

    /**
     * The method sets the direction of the item.
     * 
     * @param theDir The valid direction of the item to be set.
     */
    public void setDirection(final Direction theDir) {

        myDirection = theDir;
    }

    /**
     * The method sets the x position of the item.
     * 
     * @param theX The int value of the x position.
     */
    public void setX(final int theX) {
        myX = theX;
    }

    /**
     * The method sets the y position of the item.
     * 
     * @param theY The int value of the y position.
     */
    public void setY(final int theY) {
        myY = theY;
    }
    
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
