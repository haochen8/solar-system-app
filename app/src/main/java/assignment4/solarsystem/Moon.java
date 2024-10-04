package assignment4.solarsystem;

/**
 * This class represents a moon in the solar system.
 */
public class Moon extends HeavenlyBody {

  /**
   * Average orbit radius of the moon in kilometers.
   */
  private double avgOrbitRadiusInKm;

  /**
   * Constructor for the Moon class.
   *
   * @param name - name of the moon
   * @param avgOrbitRadiusInKm - average orbit radius of the moon in kilometers
   */
  public Moon(String name, int getAvgRadiusInKm, double avgOrbitRadiusInKm) {
    super(name, getAvgRadiusInKm);
    this.avgOrbitRadiusInKm = avgOrbitRadiusInKm;
    checkAvgRadiusInKm(getAvgRadiusInKm);
    checkAvgOrbitRadiusInKm(avgOrbitRadiusInKm);
  }

  /**
   * Getter for the average orbit radius of the moon.
   *
   * @return - average orbit radius of the moon in kilometers
   */
  public double getAvgOrbitRadiusInKm() {
    return avgOrbitRadiusInKm;
  }

  /**
   * Returns a string representation of the moon.
   */
  @Override
  public String toString() {
    return getClass().getSimpleName() + ": " + name + ", average radius: " 
      + avgRadiusInKm + "km, average orbit radius: " 
      +  avgOrbitRadiusInKm + "0km";
  }
  
  /**
   * This method checks if the provided radius is greater than 100 km.
   * If the radius is less than 100 km, it throws an IllegalArgumentException.
   *
   * @param radius The radius to check, in kilometers.
   * @throws IllegalArgumentException if radius is less than 100 km.
   */
  protected void checkAvgRadiusInKm(double radius) {
    if (radius < 6 || radius > 10000) {
      throw new IllegalArgumentException("Radius must be between 6km and 10,000km for moons");
    }
  }

  /**
   * This method checks if the provided orbit radius is greater than 60 km.
   * If the orbit radius is less than 60 km, it throws an IllegalArgumentException.
   *
   * @param avgOrbitRadiusInKm The orbit radius to check, in kilometers.
   * @throws IllegalArgumentException if orbit radius is less than 60 km.
   */
  protected void checkAvgOrbitRadiusInKm(double avgOrbitRadiusInKm) {
    if (avgOrbitRadiusInKm < 60) {
      throw new IllegalArgumentException("Minimum orbit radius for a moon is 60 km.");
    }
  }
}
