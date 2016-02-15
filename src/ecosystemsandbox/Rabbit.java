/*
 * This program is free software: you can redistribute it and/or modify it at your own will.
 */
package ecosystemsandbox;

import java.util.Random;

/**
 * Class for the rabbit specimen.
 *
 * @author Brad Baago
 */
public class Rabbit extends Species implements Cloneable {

    private Ecosystem environment; //The environment this rabbit lives in.
    private int mutation; //The mutation rate of the rabbit.
    private double Mass; //The mass of the rabbit.
    private int toxinresistance; //The toxin resistance of the rabbit.

    /**
     * Instantiates a rabbit in the given environment.
     *
     * @param enviroment
     */
    public Rabbit(Ecosystem enviroment) {
        this.environment = enviroment;
        this.mutation = 10;
        this.Mass = 6000;
        this.toxinresistance = 1;
    }

    /**
     * Checks to see if the rabbit survived the round.
     *
     * @return
     */
    @Override
    public boolean eat() {
        if (environment.getAtmosphere().getOxygen() < 0.02 * this.Mass) {
            return false;
        } else {
            int calories = (int) (this.Mass / 10);
            while (calories > 0) {
                Plant prey = null;
                for (Species target : this.environment.getSpecimens()) {
                    if (target.getClass() == Plant.class && this.environment.deadSpecimens.contains(target) == false) {
                        prey = (Plant) target;
                        if (this.toxinresistance * this.Mass >= prey.getToxicity() * prey.getMass()) {
                            synchronized (this.environment.deadSpecimens) {
                                this.environment.deadSpecimens.add(prey);
                                calories -= prey.getMass();
                            }
                        } else {
                            synchronized (this.environment.deadSpecimens) {
                                if (!this.environment.deadSpecimens.contains(prey)) {
                                    this.environment.deadSpecimens.add(prey);
                                    return false;
                                }
                            }
                        }
                    }
                    if (calories <= 0) {
                        break;
                    }
                }
                if (prey == null) {
                    return false;
                }
            }
            environment.getAtmosphere().removeOxygen(0.5 * this.Mass);
            environment.getAtmosphere().addCarbonDioxide(0.8 * this.Mass);
            return true;
        }
    }

    /**
     * Clones the rabbit with a chance for mutation.
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone1() throws CloneNotSupportedException {
        if (new Random().nextInt(this.mutation) == 0) {
            switch (new Random().nextInt(2)) {
                case 0:
                    int randomNum = new Random().nextInt((int) (this.Mass/10)) - (int) (this.Mass/5);
                    if (this.Mass + randomNum > 0) {
                        this.Mass += randomNum;
                    }
                    break;
                case 1:
                    int randomNum2 = new Random().nextInt(3) - 1;
                    if (randomNum2 + this.toxinresistance > 0) {
                        this.toxinresistance += randomNum2;
                    }
                    break;
                default:
            }
        }
        return super.clone();
    }

    /**
     * Sets the mass of the rabbit.
     *
     * @param Mass
     */
    public void setMass(double Mass) {
        this.Mass = Mass;
    }

    /**
     * Returns the mass of the rabbit.
     *
     * @return
     */
    @Override
    public double getMass() {
        return this.Mass;
    }

    /**
     * Returns the environment the rabbit lives in.
     *
     * @return
     */
    public Ecosystem getEnvironment() {
        return environment;
    }

    /**
     * Sets the environment the rabbit lives in.
     *
     * @param environment
     */
    public void setEnvironment(Ecosystem environment) {
        this.environment = environment;
    }

    /**
     * Gets the rabbit's chance of mutation.
     *
     * @return
     */
    public int getMutation() {
        return mutation;
    }

    /**
     * Sets the rabbit's chance of mutation.
     *
     * @param mutation
     */
    public void setMutation(int mutation) {
        this.mutation = mutation;
    }

    /**
     * Gets the toxin resistance of the rabbit.
     *
     * @return
     */
    public int getToxinresistance() {
        return toxinresistance;
    }

    /**
     * Sets the toxin resistance of the rabbit.
     *
     * @param toxinresistance
     */
    public void setToxinresistance(int toxinresistance) {
        this.toxinresistance = toxinresistance;
    }
    @Override
    public String toString()
    {
        String output = null;
        output="Mass: "+this.Mass+"\n";
        output+="Toxic Resistance: "+this.toxinresistance+"\n";
        output+="Mutation Chance: 1/"+this.mutation+"\n";
        return output;
    }
}
