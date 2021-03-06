/*
 * This program is free software: you can redistribute it and/or modify it at your own will.
 */
package ecosystemsandbox;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Class for the rabbit specimen.
 *
 * @author Brad Baago
 */
public class Rabbit extends Species implements Cloneable {

    private Ecosystem environment; //The environment this rabbit lives in.
    private double Mass; //The mass of the rabbit.
    private double MetabolicRate;//The metabolic rate of the rabbit.
    private int toxinresistance; //The toxin resistance of the rabbit.

    /**
     * Instantiates a rabbit in the given environment.
     *
     * @param enviroment
     */
    public Rabbit(Ecosystem enviroment) {
        this.environment = enviroment;
        this.Mass = 6000;
        this.toxinresistance = 1;
        this.MetabolicRate = 1;
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
            int calories = (int) ((this.Mass / 10)*this.MetabolicRate);
            List<Species> list = new ArrayList(this.environment.getSpecimens());
            Collections.shuffle(list);
            while (calories > 0) {
                Plant prey = null;
                for (Species target : list) {
                    if (target.getClass() == Plant.class && this.environment.getDeadSpecimens().contains(target) == false) {
                        prey = (Plant) target;
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
            environment.getAtmosphere().removeOxygen(0.5 * this.Mass * this.MetabolicRate * 0.571428571429);
            environment.getAtmosphere().addCarbonDioxide(0.5 * this.Mass * this.MetabolicRate);
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
        if (new Random().nextInt(this.environment.getMutation()) == 0) {
            switch (new Random().nextInt(3)) {
                case 0:
                    int randomNum = new Random().nextInt((int) (this.Mass/10)) - (int) (this.Mass/10);
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
                case 2:
                    double randomNum3 = (new Random().nextInt(100) - 100)/100.0;
                    if (randomNum3 + this.MetabolicRate > 0) {
                        this.MetabolicRate += randomNum3;
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
        output+="Metabolic Rate: "+this.MetabolicRate+"\n";
        output+="Speed: "+this.getSpeed()+"\n";
        return output;
    }
    @Override
    public int getToxicity()
    {
        return 0;
    }
    public double getSpeed()
    {
        return this.Mass*this.MetabolicRate;
    }
}
