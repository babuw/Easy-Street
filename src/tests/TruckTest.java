/*
 * <pre> 
 * Class: <b>TruckTest</b> 
 * File: TruckTest.java 
 * Course: TCSS 305 – Autumn 2015
 * Assignment 3 – Easy Street
 * Copyright 2015 Benjamin Abdipour
 * </pre>
 */

package tests;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import model.Direction;
import model.Terrain;
import model.Truck;

import org.junit.Test;

/**
 * <pre>
 * This class is the JUnit test for the Truck class.
 * </pre>
 * @author Benjamin Abdipour
 * @version 10/27/2015
 * @since October 19, 2015
 */

public class TruckTest {

    /**
     * Instance variable, an instance of the Truck class.
     */
    private model.Truck myTruck;

    /** Test method for Truck constructor. */
    @Test
    public void testTruckConstructor() {
        final Truck h = new Truck(10, 11, Direction.NORTH);

        assertEquals("Truck x coordinate not initialized correctly!", 10, h.getX());
        assertEquals("Truck y coordinate not initialized correctly!", 11, h.getY());
        assertEquals("Truck direction not initialized correctly!",
                     Direction.NORTH, h.getDirection());
        assertEquals("Truck death time not initialized correctly!", 0, h.getDeathTime());
        assertTrue("Truck isAlive() fails initially!", h.isAlive());
    }

    /**
     * Test method for {@link Truck#canPass(Terrain, Light)}.
     */
    @Test
    public void testCanPass() {
        
        final Map<Direction, Terrain> neighbors = new HashMap<Direction, Terrain>();
        neighbors.put(Direction.WEST, Terrain.WALL);
        neighbors.put(Direction.EAST, Terrain.STREET);
        neighbors.put(Direction.NORTH, Terrain.WALL);
        neighbors.put(Direction.SOUTH, Terrain.LIGHT);
        
        myTruck = new Truck(10, 11, Direction.EAST);
        myTruck = new Truck(10, 11, Direction.SOUTH);
    }

    /**
     * Test method for {@link Truck#chooseDirection(java.util.Map)}.
     */
    @Test
    public final void testChooseDirection() {
        // There is an assumption that there will always be at least one valid choice

        // Trucks choose randomly from among directions which lead to STREET or LIGHT

        // If a Truck starts on STREET it should also be willing to move to LIGHT
        // If a Truck starts on LIGHT it should also be willing to move to STREET

        // The program should not freeze
        // if a Truck is on STREET and the only valid choices are LIGHT
        // if a Truck is on LIGHT and the only valid choices are STREET

        final Map<Direction, Terrain> neighbors = new HashMap<Direction, Terrain>();
        neighbors.put(Direction.WEST, Terrain.WALL);
        neighbors.put(Direction.EAST, Terrain.WALL);
        neighbors.put(Direction.NORTH, Terrain.WALL);
        neighbors.put(Direction.SOUTH, Terrain.WALL);

        //stuck
        myTruck = new Truck(10, 11, Direction.NORTH);
        myTruck.chooseDirection(neighbors);
        
        //reverse
        neighbors.put(Direction.SOUTH, Terrain.LIGHT);
        myTruck = new Truck(10, 11, Direction.NORTH);
        myTruck.chooseDirection(neighbors);
        
        //right
        neighbors.put(Direction.EAST, Terrain.STREET);
        myTruck = new Truck(10, 11, Direction.NORTH);
        myTruck.chooseDirection(neighbors);
        
        //left
        neighbors.put(Direction.EAST, Terrain.WALL);
        neighbors.put(Direction.WEST, Terrain.STREET);
        myTruck = new Truck(10, 11, Direction.NORTH);
        myTruck.chooseDirection(neighbors);
        
        //straight
        neighbors.put(Direction.NORTH, Terrain.STREET);
        myTruck = new Truck(10, 11, Direction.NORTH);
        myTruck.chooseDirection(neighbors);
    }
}
