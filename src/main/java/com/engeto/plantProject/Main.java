package com.engeto.plantProject;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws PlantException, IOException {
        List<Plant> plantList = new ArrayList<>();
        ListOfPlants listOfPlants = new ListOfPlants(plantList);
        try {
            listOfPlants.loadListOfPlants(Settings.getFILENAME());
        } catch (PlantException e) {
            throw new PlantException("Nastala chyba při načítání " +Settings.getFILENAME()+ "souboru" +e.getLocalizedMessage()+ ".");
        }
        catch (IndexOutOfBoundsException e) {
            throw new PlantException("Nastala chyba při načítání položek v seznamu "+e.getLocalizedMessage()+ ".");
        }
        for(Plant plant : listOfPlants.getPlantList()) {
            plant.getWateringInfo();
            }
        System.out.println("\n");
        System.out.println(listOfPlants.plantListSortedByName());
        System.out.println(listOfPlants.platListSrotedByGetWatering());
        System.out.println("\n\n");

        listOfPlants.addPlant(new Plant("Vánoční hvězda", "bez poznámky", LocalDate.of(2021, 1, 1), LocalDate.of(2021, 5, 12), 4));
        listOfPlants.addPlant(new Plant("Bazalka v kuchyni", "", LocalDate.of(2021, 4, 1), LocalDate.of(2021, 9, 4), 3));
        listOfPlants.removeIndexPlant(2);

        try {
            listOfPlants.saveListOfPlants(Settings.getFILENAME());
        } catch (PlantException e) {
            throw new PlantException("Nastala chyba při ukládání položek do seznamu" +e.getLocalizedMessage()+".");
        }
        System.out.println(listOfPlants.plantListSortedByName());
    }
}