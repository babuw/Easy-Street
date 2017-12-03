/*
 * <pre> 
 * Class: <b>Car</b> 
 * File: Car.java 
 * Course: TCSS 305 – Autumn 2015
 * Assignment 3 – Easy Street
 * Copyright 2015 Benjamin Abdipour
 * </pre>
 */

package model;

import java.util.Map;

/**
 * <pre>
 * This class is the vehicle type Car. Cars can only travel on streets and through lights.
 * </pre>
 * 
 * @author Benjamin Abdipour
 * @version 10/27/2015
 * @since October 19, 2015
 */

public class Car extends AbstractVehicle implements Vehicle {

    /**
     * Instance variable, an integer containing the death time of the item.
     */
    private static final int DEATH_TIME = 5;

    /**
     * The constructor of the class.
     * @param theX The x position
     * @param theY The y position
     * @param theDir The direction
     */
    public Car(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir, DEATH_TIME);
    }

    /**
     * The method that is responsible to choose the proper item's direction.
     * @param theNeighbors The map of surrounding terrains of the current position 
     *      of the item.
     * @return The new direction of the item.
     */
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        Direction localDirection = getDirection();

        if (theNeighbors.get(getDirection()) != Terrain.STREET 
                        && theNeighbors.get(getDirection()) != Terrain.LIGHT) {
            if (theNeighbors.get(getDirection().left()) == Terrain.STREET 
                            || theNeighbors.get(getDirection().left()) == Terrain.LIGHT) {
                localDirection = getDirection().left();
            } else if (theNeighbors.get(getDirection().right()) == Terrain.STREET 
                            || theNeighbors.get(getDirection().right()) == Terrain.LIGHT) {
                localDirection = getDirection().right();
            } else if (theNeighbors.get(getDirection().reverse()) == Terrain.STREET 
                            || theNeighbors.get(getDirection().reverse()) == Terrain.LIGHT) {
                localDirection = getDirection().reverse();
            }
        }

        return localDirection;
    }

    /**
     * The method is responsible to validate the new position of the item against the 
     *      type of the terrain and the color of the light.
     * @param theTerrain The terrain to be checked. 
     * @param theLight The light to be checked. 
     * @return The boolean of the validity. True means the new position is valid and 
     *      vice versa.
     */
    public boolean canPass(final Terrain theTerrain, final Light theLight) {

        return theTerrain == Terrain.STREET 
                        || (theTerrain == Terrain.LIGHT && theLight != Light.RED);

    }
}
