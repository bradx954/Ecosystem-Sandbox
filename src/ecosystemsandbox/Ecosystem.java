/*
 * This program is free software: you can redistribute it and/or modify it at your own will.
 */
package ecosystemsandbox;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Generates a ecosystem object on creation.
 * @author Brad Baago
 */
public class Ecosystem {

    private int Area; //The size in m2 of the ecosysem.
    private Atmosphere Atmosphere; //The atmosphere of the ecosystem.
    private int clone; //The 1/x chance of cloning a species each tick.
    private int nextID = 1; //The next id to give to a new specimen.
    private int ticks = 0;
    private Collection<Species> Specimens = new ArrayList<Species>(); //The collection of specimens residing in the ecosystem.
    Collection<Species> newSpecimens = new ArrayList<Species>(); //The new specimens generated after each tick.
    Collection<Species> deadSpecimens = new ArrayList<Species>(); //The specimens marked for deletion after each tick.
    /**
     * Instantiates the ecosystem taking the m2 size of the ecosystem and the the height of the atmosphere m.
     * @param Area m2 of land for ecosystem.
     * @param Height m height of atmosphere for ecosystem.
     */
    public Ecosystem(int Area, int Height) {
        this.Area = Area;
        this.Atmosphere = new Atmosphere(50, 900, 250, Area * Height);
        this.clone = 5;
    }

    /**
     * Add a new species to the ecosystem.
     *
     * @param newSpecies
     */
    public void addSpecies(Species newSpecies) {
        try {

            newSpecies.setID(this.nextID);
            this.nextID++;
            this.Specimens.add(newSpecies);
        } catch (NullPointerException ex) {
            Logger.getLogger(Ecosystem.class.getName()).log(Level.SEVERE, "Ignored empty species.", ex);
        }
    }
    /**
     * Removes a species from the ecosystem.
     * @param deadSpecies 
     */
    public void removeSpecies(Species deadSpecies) {
        this.Specimens.remove(deadSpecies);
    }

    /**
     * Process the next round.
     */
    public void tick() throws CloneNotSupportedException, InterruptedException {
        //Resets the collections at the begining of the round.
        this.deadSpecimens = new ArrayList<Species>();
        this.newSpecimens = new ArrayList<Species>();
        //Service for running specimen eat threads.
        ExecutorService es = Executors.newCachedThreadPool();
        for (Species specimen : this.Specimens) {
            //Create new thread for each specimen.
            es.execute(new Runnable() {
                public void run() {
                    try {
                        if (specimen.eat()) {
                            if (new Random().nextInt(clone) == 0) {
                                try {
                                    newSpecimens.add((Species) specimen.copy());
                                } catch (CloneNotSupportedException ex) {
                                    Logger.getLogger(Ecosystem.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        } else {
                            deadSpecimens.add(specimen);
                        }
                    } catch (NullPointerException ex) {
                        deadSpecimens.add(specimen);
                        Logger.getLogger(Ecosystem.class.getName()).log(Level.SEVERE, "Deleted empty species.", ex);
                    }
                }
            });
        }
        //Wait for threads to finish.
        es.shutdown();
        es.awaitTermination(30, TimeUnit.MINUTES);
        //Apply specimen changes to the ecosystem.
        for (Species newSpecimen : this.newSpecimens) {
            this.addSpecies(newSpecimen);
        }
        for (Species deadSpecimen : this.deadSpecimens) {
            this.removeSpecies(deadSpecimen);
        }
        this.ticks++;
    }

    /**
     * Get the value of Atmosphere
     *
     * @return the Atmosphere object.
     */
    public Atmosphere getAtmosphere() {
        return Atmosphere;
    }

    /**
     * Get the area in m2.
     *
     * @return the area in m2.
     */
    public int getArea() {
        return this.Area;
    }
    /**
     * Returns the specimens in the ecosystem.
     * @return 
     */
    public Collection<Species> getSpecimens() {
        return Specimens;
    }
    /**
     * Returns the cloning rate of the ecosystem.
     * @return 
     */
    public int getClone() {
        return clone;
    }
    /**
     * Sets the cloning rate of the ecosystem.
     * @param clone 
     */
    public void setClone(int clone) {
        this.clone = clone;
    }

    public int getTicks() {
        return ticks;
    }
    
}
