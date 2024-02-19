package com.engeto.plantProject;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOfPlants {
    private List<Plant> plantList;

    public ListOfPlants(List<Plant> plantList) {
        this.plantList = plantList;
    }

    public void addPlant(Plant plant) {
        plantList.add(plant);
    }

    public Plant getIndexPlant(int index) {
        return plantList.get(index);
    }
    public void removeIndexPlant(int index) {
        plantList.remove(index);
    }

    public List<Plant> getPlantList() {
        return new ArrayList<>(plantList);
    }

    public void setPlantList(List<Plant> plantList) {
        this.plantList = new ArrayList<>(plantList);
    }

    public void loadListOfPlants(String fileName) throws PlantException {
        int lineCounter = 0;
        plantList.clear();
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)))) {
            while(scanner.hasNextLine()) {
                lineCounter++;
                String plantLine = scanner.nextLine();
                String[] splitPlantLine = plantLine.split(Settings.getDELIMITER());
                String name = splitPlantLine[0];
                String note = splitPlantLine[1];
                LocalDate planted = LocalDate.parse(splitPlantLine[2]);
                LocalDate watering = LocalDate.parse(splitPlantLine[3]);
                int frequencyOfWatering = Integer.parseInt(splitPlantLine[4]);
                Plant plant = new Plant(name, note, planted, watering, frequencyOfWatering);
                plantList.add(plant);
            }
        } catch (FileNotFoundException e) {
            throw new PlantException("Soubor "+fileName+ "nebyl nalezen" +e.getLocalizedMessage()+ ".");
        }
    }
    public void saveListOfPlants(String fileName) throws IOException, PlantException {
        String definitionDelimiter = Settings.getDELIMITER();
        try(PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
            for(Plant plant : plantList) {
                writer.println(plant.getName() + definitionDelimiter
                        + plant.getNotes() + definitionDelimiter
                        + plant.getPlanted() + definitionDelimiter
                        + plant.getWatering() + definitionDelimiter
                        + plant.getFrequencyOfWatering() + definitionDelimiter);
            }
        }
        catch (FileNotFoundException e) {
            throw new PlantException("Soubor "+fileName+ "nebyl nalezen" +e.getLocalizedMessage()+ ".");
        }
        catch (IOException e) {
            throw new PlantException("Chyba při načítání souboru "+fileName+"\n"+e.getLocalizedMessage()+".");
        }
    }
}

