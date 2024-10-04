package assignment4.solarsystem;

import java.lang.Comparable;

/**
 * This class represents a heavenly body in the solar system.
 */
public abstract class HeavenlyBody implements Comparable<HeavenlyBody> {
  String name;
  int avgRadiusInKm;

  /**
   * Constructor for the HeavenlyBody class.
   *
   * @param name - name of the heavenly body
   * @param getAvgRadiusInKm - average radius of the heavenly body in kilometers
   */
  protected HeavenlyBody(String name, double getAvgRadiusInKm) {
    setName(name);
    setAvgRadiusInKm(getAvgRadiusInKm);
  }

  /**
   * Getter for the name of the heavenly body.
   *
   * @return - name of the heavenly body
   */
  public String getName() {
    return name;
  }

  /**
   * Setter for the name of the heavenly body.
   *
   * @param newName - new name of the heavenly body
   */
  protected void setName(String newName) {
    if (newName == null || newName.isEmpty()) {
      throw new IllegalArgumentException("Name must not be null or empty");
    }
    this.name = newName;
  }

  /**
   * Getter for the average radius of the heavenly body.
   *
   * @return - average radius of the heavenly body in kilometers
   */
  public int getAvgRadiusInKm() {
    return avgRadiusInKm;
  }

  /**
   * Setter for the average radius of the heavenly body.
   *
   * @param radius - new average radius of the heavenly body in kilometers
   */
  protected void setAvgRadiusInKm(double radius) {
    checkAvgRadiusInKm(radius);
    this.avgRadiusInKm = (int) radius;
  }

  /**
   * Abstract method to check the average radius of the heavenly body.
   *
   * @param radius - average radius of the heavenly body in kilometers
   */
  protected abstract void checkAvgRadiusInKm(double radius);

  /**
   * Returns a string representation of the star.
   */
  public String toString() {
    return "Star: " + name + ", Average Radius: " + avgRadiusInKm + "km";
  }
  
  /**
   * Empty and final to prevent overriding.
   */
  protected final void finalize() {
  }

  /**
   * Compares the average radius of the heavenly body with another heavenly body.
   *
   * @param other - the other heavenly body to compare with
   * @return - the result of the comparison
   */
  public int compareTo(HeavenlyBody other) {
    return Double.compare(this.avgRadiusInKm, other.avgRadiusInKm);
  }

}
