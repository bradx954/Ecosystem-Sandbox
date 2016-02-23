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
    private double Mass; //The mass of the fox.
    private int toxinresistance; //The toxin resistance of the fox.
    private double MetabolicRate;//The metabolic rate of the fox.

    /**
     * Instantiates a fox in the given environment.
     *
     * @param enviroment
     */
    public Fox(Ecosystem enviroment) {
        this.environment = enviroment;
        this.Mass = 10000;
        this.toxinresistance = 1;
        this.MetabolicRate = 1;
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
            int calories = (int) ((this.Mass / 10)*this.MetabolicRate);
            List<Species> list = new ArrayList(this.environment.getSpecimens());
            Collections.shuffle(list);
            Rabbit prey = null;
            for (Species target : list) {
                if (target.getClass() == Rabbit.class && this.environment.getDeadSpecimens().contains(target) == false) {
                    prey = (Rabbit) target;
                    if (new Random().nextInt((int) (this.getSpeed() * 100)) < new Random().nextInt((int) (prey.getSpeed() * 100))) {

                    } else if (this.toxinresistance * this.Mass >= prey.getToxicity() * prey.getMass()) {
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
            environment.getAtmosphere().removeOxygen(0.5 * this.Mass * this.MetabolicRate);
            environment.getAtmosphere().addCarbonDioxide(0.8 * this.Mass * this.MetabolicRate);
            if (calories > 0) {
                return false;
            }
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
