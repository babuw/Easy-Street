/*
 * <pre> 
 * Class: <b>Atv</b> 
 * File: Atv.java 
 * Course: TCSS 305 – Autumn 2015
 * Assignment 3 – Easy Street
 * Copyright 2015 Benjamin Abdipour
 * </pre>
 */

package model;

import java.util.Map;

/**
 * <pre>
 * This class is the vehicle type ATV. ATVs can travel on any terrain except walls. 
 *      They randomly select to go straight, turn left, or turn right. ATV’s never 
 *      reverse direction (they never need to). ATV’s drive through all traffic lights
 *      without stopping!the abstract class of a vehicle including all common behaviors
 *      of all vehicles. The methods of this class are accessible for the child classes.
 *      An ATV dies if it collides with a living truck or car, and stays dead for 15 moves.
 * </pre>
 * 
 * @author Benjamin Abdipour
 * @version 10/27/2015
 * @since October 19, 2015
 */

public class Atv extends AbstractVehicle implements Vehicle {

    /**
     * Instance variable, an integer containing the death time of the item.
     */
    private static final int DEATH_TIME = 15;

    /**
     * The constructor of the class.
     * @param theX The x position
     * @param theY The y position
     * @param theDir The direction
     */
    public Atv(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir, DEATH_TIME);
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

        } while (theNeighbors.get(randomDirection) == Terrain.WALL
                        || randomDirection == getDirection().reverse());

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
