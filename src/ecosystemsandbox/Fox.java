/*
 * This program is free software: you can redistribute it and/or modify it at your own will.
 */
package ecosystemsandbox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Class for the fox specimen.
 *
 * @author Brad Baago
 */
public class Fox extends Species implements Cloneable {

    private Ecosystem environment; //The environment this fox lives in.
    private int mutation; //The mutation rate of the fox.
    private double Mass; //The mass of the fox.
    private int toxinresistance; //The toxin resistance of the fox.

    /**
     * Instantiates a fox in the given environment.
     *
     * @param enviroment
     */
    public Fox(Ecosystem enviroment) {
        this.environment = enviroment;
        this.mutation = 10;
        this.Mass = 10000;
        this.toxinresistance = 1;
    }

    /**
     * Checks to see if the fox survived the round.
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
                Rabbit prey = null;
                List<Species> list = new ArrayList(this.environment.getSpecimens());
                Collections.shuffle(list);
                for (Species target : list) {
                    if (target.getClass() == Rabbit.class && this.environment.getDeadSpecimens().contains(target) == false) {
                        prey = (Rabbit) target;
                        if (this.toxinresistance * this.Mass >= prey.getToxicity() * prey.getMass()) {
                            synchronized (this.environment.getDeadSpecimens()) {
                                this.environment.getDeadSpecimens().add(prey);
                                calories -= prey.getMass();
                            }
                        } else {
                            synchronized (this.environment.getDeadSpecimens()) {
                                if (!this.environment.getDeadSpecimens().contains(prey)) {
                                    this.environment.getDeadSpecimens().add(prey);
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
     * Clones the fox with a chance for mutation.
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
     * Sets the mass of the fox.
     *
     * @param Mass
     */
    public void setMass(double Mass) {
        this.Mass = Mass;
    }

    /**
     * Returns the mass of the fox.
     *
     * @return
     */
    @Override
    public double getMass() {
        return this.Mass;
    }

    /**
     * Returns the environment the fox lives in.
     *
     * @return
     */
    public Ecosystem getEnvironment() {
        return environment;
    }

    /**
     * Sets the environment the fox lives in.
     *
     * @param environment
     */
    public void setEnvironment(Ecosystem environment) {
        this.environment = environment;
    }

    /**
     * Gets the fox's chance of mutation.
     *
     * @return
     */
    public int getMutation() {
        return mutation;
    }

    /**
     * Sets the fox's chance of mutation.
     *
     * @param mutation
     */
    public void setMutation(int mutation) {
        this.mutation = mutation;
    }

    /**
     * Gets the toxin resistance of the fox.
     *
     * @return
     */
    public int getToxinresistance() {
        return toxinresistance;
    }

    /**
     * Sets the toxin resistance of the fox.
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
    @Override
    public int getToxicity()
    {
        return 0;
    }
}
