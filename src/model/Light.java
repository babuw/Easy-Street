/*
 * <pre> 
 * Class: <b>Light</b> 
 * File: Light.java 
 * Course: TCSS 305 – Autumn 2015
 * Assignment 3 – Easy Street
 * Copyright 2015 Marty Stepp, Daniel M. Zimmerman, Alan Fowler
 * </pre>
 */

package model;

/**
 * An enumeration of traffic light statuses.
 * 
 * @author Marty Stepp
 * @author Daniel M. Zimmerman
 * @author Alan Fowler (acfowler@u.washington.edu)
 * @version Autumn 2015
 */

public enum Light {
    /**
     * Green means go.
     */
    GREEN,

    /**
     * Yellow means caution.
     */
    YELLOW,

    /**
     * Red means stop.
     */
    RED;

    /**
     * Returns the next light in sequence after this one. The sequence is GREEN,
     * YELLOW, RED.
     * 
     * @return the next light in sequence.
     */
    public Light advance() {
        Light result = Light.GREEN;

        switch (this) {
            case GREEN:
                result = YELLOW;
                break;

            case YELLOW:
                result = RED;
                break;

            case RED:
                result = GREEN;
                break;

            default:
        }

        return result;
    }
}
