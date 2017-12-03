/*
 * <pre> 
 * Class: <b>Truck</b> 
 * File: Truck.java 
 * Course: TCSS 305 – Autumn 2015
 * Assignment 3 – Easy Street
 * Copyright 2015 Benjamin Abdipour
 * </pre>
 */

package model;

import java.util.Map;

/**
 * <pre>
 * This class is the vehicle type Truck. Trucks travel only on streets and through lights. 
 *      Their preferred movement is to randomly select to go straight, turn left, or turn
 *      right. As a last resort, if none of these three directions is legal (all not streets
 *      or lights), the truck turns around. Trucks drive through all traffic lights without
 *      stopping.
 * </pre>
 * 
 * @author Benjamin Abdipour
 * @version 10/27/2015
 * @since October 19, 2015
 */

public class Truck extends AbstractVehicle implements Vehicle {

    /**
     * Instance variable, an integer containing the death time of the item.
     */
    private static final int DEATH_TIME = 0;

    /**
     * Instance variable, the light type variable that keeps the color of the traffic light.
     */
    private Light myLight;

    /**
     * The constructor of the class.
     * @param theX The x position
     * @param theY The y position
     * @param theDir The direction
     */
    public Truck(final int theX, final int theY, final Direction theDir) {
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
        Direction randomDirection;

        if (canPass(theNeighbors.get(localDirection), myLight)
                        || canPass(theNeighbors.get(localDirection.left()), myLight)
                        || canPass(theNeighbors.get(localDirection.right()), myLight)) {
            do {
                randomDirection = Direction.random();
            } while (randomDirection == localDirection.reverse()
                            || !canPass(theNeighbors.get(randomDirection), myLight));
            localDirection = randomDirection;

        } else if (canPass(theNeighbors.get(localDirection.reverse()), myLight)) {
            localDirection = localDirection.reverse();
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

        boolean canPass;
        if (theTerrain == Terrain.STREET || theTerrain == Terrain.LIGHT) {
            myLight = theLight;
            canPass = true;
        } else {
            canPass = false;    
        }
        
        return canPass;
    }
}
