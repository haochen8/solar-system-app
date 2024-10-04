package assignment4.solarsystem;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a planet in the solar system.
 */
public class Planet extends HeavenlyBody {

  /**
   * Average orbit radius of the planet in kilometers.
   */
  private double avgOrbitRadiusInKm;
  /**
   * An array list of moons.
   */
  public List<Moon> moons = new ArrayList<>();
  
  /**
   * Constructor for the Planet class.
   *
   * @param name - name of the planet
   * @param avgRadiusInKm - average radius of the planet in kilometers
   * @param avgOrbitRadiusInKm -  average orbit radius of the planet in kilometers
   */
  public Planet(String name, double avgRadiusInKm, double avgOrbitRadiusInKm) {
    super(name, (int) avgRadiusInKm);
    this.avgOrbitRadiusInKm = avgOrbitRadiusInKm;
    checkAvgRadiusInKm(avgRadiusInKm);
    checkAvgOrbitRadiusInKm(avgOrbitRadiusInKm);
  }

  /**
   * Getter for the average orbit radius of the planet.
   *
   * @return - average orbit radius of the planet in kilometers
   */
  public double getAvgOrbitRadiusInKm() {
    return avgOrbitRadiusInKm;
  }

  /**
   * Method for adding a moon to the planet.
   *
   * @param name - name of the moon
   * @param getAvgRadiusInKm - average radius of the moon in kilometers
   * @param avgOrbitRadiusInKm - average orbit radius of the moon in kilometers
   * @return - the moon added
   */
  public Moon addMoon(String name, int getAvgRadiusInKm, double avgOrbitRadiusInKm) {
    if (getAvgRadiusInKm > this.avgRadiusInKm / 2) {
      throw new IllegalArgumentException("Moon can not be larger than half the size of its planet.");
    }

    if (avgOrbitRadiusInKm < 60) {
      throw new IllegalArgumentException("Minimum orbit radius for a moon is 60 km.");
    }

    Moon moon = new Moon(name, getAvgRadiusInKm, avgOrbitRadiusInKm);
    moons.add(moon);
    return moon;
  }

  /**
   * Method for removing a moon from the planet.
   *
   * @param moon - the moon to remove
   */
  public void removeMoon(Moon moon) {
    moons.remove(moon);
  }

  /**
   * Getter for the moons of the planet.
   *
   * @return - moons of the planet
   */
  public List<Moon> getMoons() {
    return moons;
  }

  /**
   * Method for getting the moons of the planet.
   *
   * @return - moons of the planet
   */
  public HeavenlyBody[] getHeavenlyBodies() {
    HeavenlyBody[] heavenlyBodies = new HeavenlyBody[moons.size() + 1];
    // Copy of the planet
    heavenlyBodies[0] = new Planet(this.getName(), this.getAvgRadiusInKm(), this.getAvgOrbitRadiusInKm());
    for (int i = 0; i < moons.size(); i++) {
      Moon orgMoon = moons.get(i);
      // Copy of the moons
      heavenlyBodies[i + 1] = new Moon(orgMoon.getName(), orgMoon.getAvgRadiusInKm(), orgMoon.getAvgOrbitRadiusInKm());
    }
    return heavenlyBodies;
  }

  /**
   * Returns a string representation of the planet.
   */
  @Override
  public String toString() {
    return getClass().getSimpleName() + ": " + name + ", average radius: " 
      + avgRadiusInKm + "km" + ", average orbit radius: " 
      + avgOrbitRadiusInKm + "0km";
  }

  /**
   * This method checks if the provided radius is greater than 100 km.
   * If the radius is less than 100 km, it throws an IllegalArgumentException.
   *
   * @param radius The radius to check, in kilometers.
   * @throws IllegalArgumentException if radius is less than 100 km.
   */
  protected void checkAvgRadiusInKm(double radius) {
    if (radius < 2000 || radius > 200000) {
      throw new IllegalArgumentException("Radius must be between 2,000km and 200,000km for planets");
    }
  }

  /**
   * This method checks if the provided orbit radius is greater than 18,000 km.
   *
   * @param avgOrbitRadiusInKm - average orbit radius of the planet in kilometers
   * @throws IllegalArgumentException if orbit radius is less than 18,000 km.
   */
  protected void checkAvgOrbitRadiusInKm(double avgOrbitRadiusInKm) {
    if (avgOrbitRadiusInKm < 18000) {
      throw new IllegalArgumentException("Minimum orbit radius for a planet is 18,000 km.");
    }
  }
}
