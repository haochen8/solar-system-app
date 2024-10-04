Solar System Management App

Assignment 4

This is the generated project for Assignment 4. The Solar System Management App is a console-based Java application that allows users to manage a model of a solar system. It supports operations such as adding, deleting, and listing stars, planets, and moons, and ensures that data is persisted across sessions by saving it to a file.

Quick Setup Instructions

  1. Clone the Repository
	•	Copy the clone link and use git clone to create a local copy of the repository:
  •	git clone https://github.com/haochen8/solar-system-app.git

  2. Build the Application
	•	Build the application using Gradle:
  •	./gradlew build

  3. Run the Application
  •	Run the application using the following command:
  •	./gradlew run -q --console=plain

  Application Features

	•	List All Celestial Bodies: Display a complete list of stars, planets, and moons currently in the solar system.
	•	Add a Star: Allows the user to add a new star to the solar system model.
	•	Add a Planet: Attach a new planet to a specific star already present in the solar system.
	•	Add a Moon: Attach a new moon to an existing planet.
	•	Delete a Star: Remove a star and all its associated planets and moons from the system.
	•	Delete a Planet: Remove a planet and all its moons from the system.
	•	Delete a Moon: Remove a specific moon from its parent planet.
	•	Save and Exit: Save the current state of the solar system to a file and exit the application, ensuring persistence across sessions.

Persistence

The application saves the solar system’s current state to a file, ensuring that all data, including stars, planets, and moons, is preserved between sessions. When the app is restarted, it can load this data, allowing users to pick up where they left off.

Usage

Once you run the application, a menu will be displayed allowing you to manage the solar system interactively through the console. You can add new stars, planets, and moons, delete existing ones, and list all celestial bodies in the system.

Future Enhancements

The Solar System Management App is currently in a basic state with a command-line interface. Future improvements could include:

	•	Enhanced user interface (UI) for better user experience.
	•	Support for additional celestial bodies and attributes (e.g., asteroids, comets).
	•	Validation of inputs to ensure correct data entry.

Author

	•	Hao Chen
	•	Contact: haoooochen@gmail.com

Thank you for reviewing this project!