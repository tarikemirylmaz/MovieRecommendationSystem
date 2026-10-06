# Movie Recommendation System

A Java-based movie recommendation system that analyzes movie and user data to generate personalized movie recommendations.

## About the Project

This project was developed to demonstrate the use of **data structures, recommendation algorithms, file processing, and graphical user interfaces in Java**.

The system loads movie and user information from CSV datasets, processes the data, and generates movie recommendations for the target user.

A custom **MaxHeap** data structure is used as part of the recommendation process to efficiently organize and retrieve recommendation results.

## Technologies Used

- Java
- Java Swing
- NetBeans
- CSV File Processing
- Object-Oriented Programming (OOP)
- Data Structures
- Max Heap

## Project Structure

### Source Code

- `MovieRecommendationSystem1.java` - Entry point of the application
- `MainFrame.java` - Main graphical user interface
- `MainFrame.form` - NetBeans GUI form definition
- `RecommendationEngine.java` - Contains the recommendation logic
- `DataLoader.java` - Loads and processes data from CSV files
- `UserEntry.java` - Represents user-related data
- `MaxHeap.java` - Custom Max Heap implementation used by the system

### Dataset

The `data` directory contains the CSV files used by the application:

- `movies.csv` - Movie information
- `main_data.csv` - Main dataset used by the recommendation system
- `target_user.csv` - Information related to the target user

## Features

- Personalized movie recommendations
- CSV-based movie and user data processing
- Custom recommendation engine
- Custom Max Heap data structure
- Graphical user interface using Java Swing
- Modular object-oriented project structure
- Separation of data loading, recommendation logic, and user interface

## Data Structures

One of the main components of the project is the custom `MaxHeap` implementation.

The Max Heap helps organize recommendation results according to their priority or score, allowing higher-ranked movie recommendations to be retrieved efficiently.

## Project Report

The repository includes:

`MovieRecommendationSystem_Report.docx`

The report contains additional information about the project's design, implementation, algorithms, and overall system structure.

## Project Directory

```text
MovieRecommendationSystem/
├── data/
│   ├── main_data.csv
│   ├── movies.csv
│   └── target_user.csv
│
├── src/
│   └── movierecommendationsystem1/
│       ├── DataLoader.java
│       ├── MainFrame.form
│       ├── MainFrame.java
│       ├── MaxHeap.java
│       ├── MovieRecommendationSystem1.java
│       ├── RecommendationEngine.java
│       └── UserEntry.java
│
├── nbproject/
├── build.xml
├── manifest.mf
└── MovieRecommendationSystem_Report.docx
```

## Author

**Tarık Emir Yılmaz**
