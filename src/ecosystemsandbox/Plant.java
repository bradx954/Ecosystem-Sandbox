/*
 * This program is free software: you can redistribute it and/or modify it at your own will.
 */
package ecosystemsandbox;

import java.util.Random;

/**
 * Class for the plant specimen.
 *
 * @author Brad Baago
 */
public class Plant extends Species implements Cloneable {

    private Ecosystem environment; //The environment this plant lives in.
    private int mutation; //The 1/x chance this plant mutates on cloning.
    private double Mass; //The mass of the plant.
    private int toxicity; //The toxicity of the plant.

    /**
     * Instantiates a plant object with a environment.
     *
     * @param enviroment
     */
    public Plant(Ecosystem enviroment) {
        this.environment = enviroment;
        this.mutation = 10;
        this.Mass = 500;
        this.toxicity = 0;
    }

    /**
     * Checks to see if the plant survives the current conditions.
     *
     * @return Survived true or false.
     */
    @Override
    public boolean eat() {
        if (environment.getAtmosphere().getCarbonDioxide() < 0.01 * this.Mass) {
            return false;
        } else {
            environment.getAtmosphere().removeCarbonDioxide(0.5 * this.Mass);
            environment.getAtmosphere().addOxygen(0.3 * this.Mass);
            return true;
        }
    }

    /**
     * Clones the current object with a chance of mutation.
     *
     * @return new object.
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
                    if (randomNum2 + this.toxicity > 0) {
                        this.toxicity += randomNum2;
                    }
                    break;
                default:
            }
        }
        return super.clone();
    }

    /**
     * Returns the mass of the plant.
     *
     * @param Mass
     */
    public void setMass(double Mass) {
        this.Mass = Mass;
    }

    /**
     * Returns the mass of the plant.
     *
     * @return
     */
    @Override
    public double getMass() {
        return this.Mass;
    }

    /**
     * Returns the environment the plant lives in.
     *
     * @return
     */
    public Ecosystem getEnvironment() {
        return environment;
    }

    /**
     * Sets the environment the plant lives in.
     *
     * @param enviroment
     */
    public void setEnvironment(Ecosystem enviroment) {
        this.environment = enviroment;
    }

    /**
     * Gets the plant's rate of mutation.
     *
     * @return
     */
    public int getMutation() {
        return mutation;
    }

    /**
     * Sets the plant's rate of mutation.
     *
     * @param mutation
     */
    public void setMutation(int mutation) {
        this.mutation = mutation;
    }

    /**
     * Gets the plant's toxicity.
     *
     * @return
     */
    @Override
    public int getToxicity() {
        return toxicity;
    }

    /**
     * Sets the plant's toxicity.
     *
     * @param toxicity
     */
    public void setToxicity(int toxicity) {
        this.toxicity = toxicity;
    }
    @Override
    public String toString()
    {
        String output = null;
        output="Mass: "+this.Mass+"\n";
        output+="Toxicity: "+this.toxicity+"\n";
        output+="Mutation Chance: 1/"+this.mutation+"\n";
        return output;
    }
}
