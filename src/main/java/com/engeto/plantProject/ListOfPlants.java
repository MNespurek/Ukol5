package com.engeto.plantProject;

import java.util.ArrayList;
import java.util.List;

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
}
