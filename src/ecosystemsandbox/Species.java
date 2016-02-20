/*
 * This program is free software: you can redistribute it and/or modify it at your own will.
 */
package ecosystemsandbox;

/**
 * The framework for specimen classes.
 * @author Brad Baago
 */
public abstract class Species {
    
    private int ID; //The id of the specimen.

    /**
     * Get the value of ID
     *
     * @return the value of ID
     */
    public int getID() {
        return ID;
    }

    /**
     * Set the value of ID
     *
     * @param ID new value of ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }
    abstract public double getMass();
    abstract public boolean eat();
    abstract public int getToxicity();
    protected abstract Object clone1() throws CloneNotSupportedException;

    public Object copy() throws CloneNotSupportedException {
        return clone1();
    }
}
