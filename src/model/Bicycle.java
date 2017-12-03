/*
 * <pre> 
 * Class: <b>Bicycle</b> 
 * File: Bicycle.java 
 * Course: TCSS 305 – Autumn 2015
 * Assignment 3 – Easy Street
 * Copyright 2015 Benjamin Abdipour
 * </pre>
 */

package model;

import java.util.Map;

/**
 * <pre>
 * This class is the vehicle type Bicycle. Bicycles can travel on streets and through
 *      lights, but they prefer to travel on trails.
 * </pre>
 * 
 * @author Benjamin Abdipour
 * @version 10/27/2015
 * @since October 19, 2015
 */

public class Bicycle extends AbstractVehicle implements Vehicle {

    /**
     * Instance variable, an integer containing the death time of the item.
     */
    private static final int DEATH_TIME = 25;

    /**
     * The constructor of the class.
     * @param theX The x position
     * @param theY The y position
     * @param theDir The direction
     */
    public Bicycle(final int theX, final int theY, final Direction theDir) {
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

        if (theNeighbors.get(localDirection) != Terrain.TRAIL) {
            if (theNeighbors.get(localDirection.left()) == Terrain.TRAIL) {
                localDirection = getDirection().left();
            } else if (theNeighbors.get(localDirection.right()) == Terrain.TRAIL) {
                localDirection = getDirection().right();
            } else if (theNeighbors.get(localDirection) != Terrain.STREET 
                            && theNeighbors.get(localDirection) != Terrain.LIGHT) {
                if (theNeighbors.get(localDirection.left()) == Terrain.STREET 
                                || theNeighbors.get(localDirection.left()) == Terrain.LIGHT) {
                    localDirection = getDirection().left();
                } else if (theNeighbors.get(localDirection.right()) == Terrain.STREET 
                                || theNeighbors.get(localDirection.right()) == Terrain.LIGHT) {
                    localDirection = getDirection().right();
                } else {
                    localDirection = localDirection.reverse();
                }
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
        return !(theTerrain == Terrain.LIGHT) || theLight == Light.GREEN;
    }
}
