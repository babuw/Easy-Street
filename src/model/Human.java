/*
 * <pre> 
 * Class: <b>Human</b> 
 * File: Human.java 
 * Course: TCSS 305 – Autumn 2015
 * Assignment 3 – Easy Street
 * Copyright 2015 Benjamin Abdipour
 * </pre>
 */

package model;

import java.util.Map;

/**
 * <pre>
 * This class is the vehicle type Human. A Human moves in a random direction (straight,
 *      left, right, or reverse), always on terrain that matches his initial terrain.
 *      Streets and lights are considered the same terrain for this purpose.
 * </pre>
 * 
 * @author Benjamin Abdipour
 * @version 10/27/2015
 * @since October 19, 2015
 */

public class Human extends AbstractVehicle implements Vehicle {

    /**
     * Instance variable, an integer containing the death time of the item.
     */
    private static final int DEATH_TIME = 45;

    /**
     * Instance variable, a terrain that the item should travel on. The item does not leave
     *      this terrain under no circumstances.
     */
    private final Terrain myTerrain;

    /**
     * The constructor of the class.
     * @param theX The x position
     * @param theY The y position
     * @param theDir The direction
     * @param theTerrain The terrain
     */
    public Human(final int theX, final int theY, final Direction theDir, 
                 final Terrain theTerrain) {
        super(theX, theY, theDir, DEATH_TIME);
        myTerrain = theTerrain;
    }

    /**
     * The method that is responsible to choose the proper item's direction.
     * @param theNeighbors The map of surrounding terrains of the current position 
     *      of the item.
     * @return The new direction of the item.
     */
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        
        Direction randomDirection;
        do {
            randomDirection = Direction.random();
            if ((theNeighbors.get(randomDirection) == Terrain.LIGHT 
                            && myTerrain == Terrain.STREET)
                            || (theNeighbors.get(randomDirection) == Terrain.STREET 
                            && myTerrain == Terrain.LIGHT)) {
                break;
            }
        } while (theNeighbors.get(randomDirection).compareTo(myTerrain) != 0);

        return randomDirection;
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
        return true;
    }

}
