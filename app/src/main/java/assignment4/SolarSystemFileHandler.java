package assignment4;

import assignment4.solarsystem.Moon;
import assignment4.solarsystem.Planet;
import assignment4.solarsystem.SolarSystem;
import assignment4.solarsystem.Star;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;


/**
 * This class reads and writes to a file for the SolarSystem class.
 */
public class SolarSystemFileHandler {
  
  /**
   * Reads from a file and populates the SolarSystem object.
   *
   * @param filePath - the path to the file.
   * @param solarSystem - the SolarSystem object to populate.
   */
  public void readFromFile(String filePath, SolarSystem solarSystem) {
    // Read from file
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(
        new FileInputStream(filePath), StandardCharsets.UTF_8))) {
      String line;
      Star currentStar = null;
      Planet currentPlanet = null;

      while ((line = reader.readLine()) != null) {
        if (line.startsWith("Star:")) {
          // Star
          String[] parts = line.split(",");
          String name = parts[0].split(":")[1].trim();
          double radius = Double.parseDouble(parts[1].split(":")[1].trim().replace("km", "").trim());
          currentStar = new Star(name, radius);
          solarSystem.addStar(currentStar);
        } else if (line.startsWith("\tPlanet:")) {
          if (currentStar != null) {
            String[] parts = line.trim().split(",");
            String name = parts[0].split(":")[1].trim();
            int radius = Integer.parseInt(parts[1].split(":")[1].trim().replace("km", "").trim());
            double orbitRadius = Double.parseDouble(parts[2].split(":")[1].trim().replace("km", "").trim());
            currentPlanet = currentStar.addPlanet(name, radius, orbitRadius);
          }
        } else if (line.startsWith("\t\tMoon:")) {
          if (currentPlanet != null) {
            String[] parts = line.trim().split(",");
            String name = parts[0].split(":")[1].trim();
            int radius = Integer.parseInt(parts[1].split(":")[1].trim().replace("km", "").trim());
            double orbitRadius = Double.parseDouble(parts[2].split(":")[1].trim().replace("km", "").trim());
            currentPlanet.addMoon(name, radius, orbitRadius);
          }
        }
      } 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Writes to a file from the SolarSystem object.
   *
   * @param filePath - the path to the file.
   * @param solarSystem - the SolarSystem object to write from.
   */
  public void writeToFile(String filePath, SolarSystem solarSystem) {
    // Write to file
    try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
        new FileOutputStream(filePath), StandardCharsets.UTF_8))) {
      for (Star star : solarSystem.getStars()) {
        writer.write("Star:" + star.getName() + ", Average Radius:" + star.getAvgRadiusInKm() + "km\n");
        for (Planet planet : star.getPlanets()) {
          writer.write("\tPlanet:" + planet.getName() + ", Average Radius:" + planet.getAvgRadiusInKm() 
              + "km, Orbit Radius:" 
              + planet.getAvgOrbitRadiusInKm() + "km\n");
          for (Moon moon : planet.getMoons()) {
            writer.write("\t\tMoon:" + moon.getName() + ", Average Radius:" + moon.getAvgRadiusInKm() 
                  + "km, Orbit Radius:" 
                  + moon.getAvgOrbitRadiusInKm() + "km\n");
            writer.newLine();
          }
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
