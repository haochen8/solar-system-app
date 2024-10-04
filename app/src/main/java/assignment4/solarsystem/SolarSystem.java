package assignment4.solarsystem;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a planet in the solar system.
 */
public class SolarSystem {

  /**
   * A list of stars in the solar system.
   */
  private List<Star> stars;

  /**
   * Constructor for the SolarSystem class.
   */
  public SolarSystem() {
    this.stars = new ArrayList<>();
  }

  /**
   * Adds a star to the solar system.
   *
   * @param star - the star to add
   */
  public void addStar(Star star) {
    stars.add(star);
  }

  /**
   * Removes a star from the solar system and its planets and moons.
   */
  public void removeStar(Star star) {
    stars.remove(star);
  }

  /**
   * Getter for the list of stars in the solar system.
   *
   * @return - the list of stars
   */
  public List<Star> getStars() {
    return new ArrayList<>(stars);
  }

  /**
   * Adds a planet to a star in the solar system.
   *
   * @param star - the star to add the planet to
   */
  public void addPlanetToStar(Star star, String planetName, int avgRadiusInKm, double avgOrbitRadiusInKm) {
    if (stars.contains(star)) {
      star.addPlanet(planetName, avgRadiusInKm, avgOrbitRadiusInKm);
    }
  }

  /**
   * Removes a planet from a star in the solar system.
   *
   * @param star - the star to remove the planet from
   * @param planet - the planet to remove
   */
  public void removePlanetFromStar(Star star, Planet planet) {
    if (stars.contains(star) && star.getPlanets().contains(planet)) {
      star.removePlanet(planet);
    }
  }

  /**
   * Adds a moon to a planet in the solar system.
   *
   * @param planet - the planet to add the moon to
   */
  public void addMoonToPlanet(Planet planet, String moonName, int avgRadiusInKm, double avgOrbitRadiusInKm) {
    for (Star star : stars) {
      if (stars.contains(star) && star.getPlanets().contains(planet)) {
        planet.addMoon(moonName, avgRadiusInKm, avgOrbitRadiusInKm);
      }
    }
  }

  /**
   * Removes a moon from a planet in the solar system.
   *
   * @param planet - the planet to remove the moon from
   * @param moon - the moon to remove
   */
  public void removeMoonFromPlanet(Planet planet, Moon moon) {
    for (Star star : stars) {
      if (stars.contains(star) && star.getPlanets().contains(planet)) {
        planet.removeMoon(moon);
      }
    }
  }

  /**
   * Lists all the heavenly bodies in the solar system.
   *
   * @return - a string representation of the solar system
   */
  public String listHeavenlyBodies() {
    StringBuilder sb = new StringBuilder();
    for (Star star : stars) {
      sb.append(star.toString()).append("\n");
      for (Planet planet : star.getPlanets()) {
        sb.append("\t").append(planet.toString()).append("\n");
        for (Moon moon : planet.getMoons()) {
          sb.append("\t\t").append(moon.toString()).append("\n");
        }
      }
    }
    return sb.toString();
  }
}
