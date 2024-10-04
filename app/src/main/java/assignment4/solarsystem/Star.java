package assignment4.solarsystem;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a star in the solar system.
 */
public class Star extends HeavenlyBody {
  /**
   * An array list of planets.
   */
  private List<Planet> planets = new ArrayList<>();

  /**
   * Constructor for the Star class.
   *
   * @param name - name of the star
   * @param getAvgRadiusInKm - average radius of the star in kilometers
   */
  public Star(String name, double getAvgRadiusInKm) {
    super(name, (int) getAvgRadiusInKm);
  }
  
  /**
   * Method for adding a planet to the star.
   *
   * @param name - name of the planet
   * @param avgRadiusInKm - average radius of the planet in kilometers
   * @param avgOrbitRadiusInKm - average orbit radius of the planet in kilometers
   * @return - the planet added
   */
  public Planet addPlanet(String name, int avgRadiusInKm, double avgOrbitRadiusInKm) {
    Planet planet = new Planet(name, avgRadiusInKm, avgOrbitRadiusInKm);
    planets.add(planet);
    return planet;
  }

  /**
   * Method for removing a planet from the star.
   *
   * @param planet - the planet to remove
   */
  public void removePlanet(Planet planet) {
    planets.remove(planet);
  }

  /**
   * Getter for the planets of the star.
   *
   * @return - planets of the star
   */
  public List<Planet> getPlanets() {
    return new ArrayList<>(planets);
  }

  /**
   * Method for getting the planets of the star.
   *
   * @return - planets of the star
   */
  public HeavenlyBody[] getHeavenlyBodies() {
    int totalSize = 1;
    for (Planet planet : planets) {
      totalSize += 1 + planet.moons.size();
    }

    // Create a new array to hold the star, planets, and moons
    HeavenlyBody[] heavenlyBodies = new HeavenlyBody[totalSize];
    heavenlyBodies[0] = new Star(this.getName(), this.getAvgRadiusInKm());

    // Copy the planets and moons to the new array
    int index = 1;
    for (Planet planet : planets) {
      heavenlyBodies[index++] = new Planet(planet.getName(), planet.getAvgRadiusInKm(), planet.getAvgOrbitRadiusInKm());
      HeavenlyBody[] planetAndMoons = planet.getHeavenlyBodies();
      // Copy only the moons to the new array
      for (int i = 1; i < planetAndMoons.length; i++) {
        heavenlyBodies[index++] = planetAndMoons[i];
      }
    }
    return heavenlyBodies;
  }

  /**
   * Method for getting a planet by name.
   *
   * @param name - name of the planet
   * @return - the planet
   */
  public Planet getPlanetByName(String name) {
    for (Planet planet : planets) {
      if (planet.getName().equals(name)) {
        return planet;
      }
    }
    return null;
  }

  /**
   * Returns a string representation of the star.
   */
  @Override
  public String toString() {
    return getClass().getSimpleName() + ": " + name + ", average radius " + avgRadiusInKm + "km";
  }

  /**
   * This method checks if the provided radius is greater than 16700 km.
   * If the radius is less than 16700 km, it throws an IllegalArgumentException.
   *
   * @param radius The radius to check, in kilometers.
   * @throws IllegalArgumentException if radius is less than 16700 km.
   */
  protected void checkAvgRadiusInKm(double radius) {
    if (radius < 16700) {
      throw new IllegalArgumentException("Radius must be greater than 16700 km");
    }
  }
}
