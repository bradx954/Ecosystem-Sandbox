/*
 * This program is free software: you can redistribute it and/or modify it at your own will.
 */
package ecosystemsandbox;

/**
 * Generates an Atmosphere object on creation.
 *
 * @author Brad Baago
 */
public class Atmosphere {

    private double Temperature = 20; //The air temperature.
    private int Area; //The volume in m3.
    private double CarbonDioxide; //The amount of grams of carbonDioxide in 1 m3.
    private double Nitrogen; //The amount of grams of Nitrogen in 1 m3.
    private double Oxygen; //The amount of grams of Oxygen in 1 m3.

    /**
     * Instantiates a new object with the provided vales;
     *
     * @param CarbonDioxide in grams per m3
     * @param Nitrogen in grams per m3
     * @param Oxygen in grams per m3
     * @param Area volume in m3
     */
    public Atmosphere(double CarbonDioxide, double Nitrogen, double Oxygen, int Area) {
        this.CarbonDioxide = CarbonDioxide;
        this.Nitrogen = Nitrogen;
        this.Oxygen = Oxygen;
        this.Area = Area;
    }

    /**
     * Get the value of Temperature
     *
     * @return the value of Temperature
     */
    public double getTemperature() {
        return Temperature;
    }

    /**
     * Set the value of Temperature
     *
     * @param Temperature new value of Temperature
     */
    public void setTemperature(double Temperature) {
        this.Temperature = Temperature;
    }

    /**
     * Get the value of Area
     *
     * @return the value of Area in m3
     */
    public int getArea() {
        return Area;
    }

    /**
     * Get the value of CarbonDioxide
     *
     * @return the value of CarbonDioxide in grams/m3.
     */
    public double getCarbonDioxide() {
        return CarbonDioxide;
    }

    /**
     * Set the value of CarbonDioxide
     *
     * @param CarbonDioxide new value of CarbonDioxide in grams/m3.
     */
    public void setCarbonDioxide(double CarbonDioxide) {
        this.CarbonDioxide = CarbonDioxide;
    }

    /**
     * Get the value of Nitrogen
     *
     * @return the value of Nitrogen in grams/m3.
     */
    public double getNitrogen() {
        return Nitrogen;
    }

    /**
     * Set the value of Nitrogen
     *
     * @param Nitrogen new value of Nitrogen in grams/m3.
     */
    public void setNitrogen(double Nitrogen) {
        this.Nitrogen = Nitrogen;
    }

    /**
     * Get the value of Oxygen
     *
     * @return the value of Oxygen in grams/m3.
     */
    public double getOxygen() {
        return Oxygen;
    }

    /**
     * Set the value of Oxygen
     *
     * @param Oxygen new value of Oxygen in grams/m3.
     */
    public void setOxygen(double Oxygen) {
        this.Oxygen = Oxygen;
    }

    /**
     * Gets the density of the air.
     *
     * @return grams per m3.
     */
    public double getDensity() {
        return (this.CarbonDioxide + this.Nitrogen + this.Oxygen) / this.Area;
    }

    /**
     * Consumes some CarbonDioxide from the air.
     *
     * @param amount
     */
    public void removeCarbonDioxide(double amount) {
        synchronized (this) {
            double remove = amount / this.Area;
            this.CarbonDioxide -= remove;
        }
    }

    /**
     * Consumes some Oxygen from the air.
     *
     * @param amount
     */
    public void removeOxygen(double amount) {
        synchronized (this) {
            double remove = amount / this.Area;
            this.Oxygen -= remove;
        }
    }

    /**
     * Adds some Oxygen to the air.
     *
     * @param amount
     */
    public void addOxygen(double amount) {
        synchronized (this) {
            double add = amount / this.Area;
            this.Oxygen += add;
        }
    }

    /**
     * Adds some CarbonDioxide to the air.
     *
     * @param amount
     */
    public void addCarbonDioxide(double amount) {
        synchronized (this) {
            double add = amount / this.Area;
            this.CarbonDioxide += add;
        }
    }

}
