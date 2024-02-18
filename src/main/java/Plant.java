import com.engeto.plantProject.PlantException;

import java.time.LocalDate;

public class Plant {
    private String name;
    private String notes;
    private LocalDate  planted;
    private LocalDate watering;
    private int frequencyOfWatering;

    public Plant(String name, String notes, LocalDate planted, LocalDate watering, int frequencyOfWatering) throws PlantException {
        this.name = name;
        this.notes = notes;
        this.planted = planted;
        setWatering(watering);
        setFrequencyOfWatering(frequencyOfWatering);
    }

    public Plant(String name, LocalDate planted, int frequencyOfWatering) throws PlantException {
        this(name, "", planted, LocalDate.now(),frequencyOfWatering);
    }
    public Plant(String name) throws PlantException{
        this(name,"", LocalDate.now(), LocalDate.now(), 7 );
    }

    public void getWateringInfo() throws PlantException {
        LocalDate nextWatering = LocalDate.now().plusDays(getFrequencyOfWatering());
        System.out.println("Název rostliny: "+getName()+", datum poslední zálivky: "+getWatering()+ ", datum další zálivky: "+nextWatering+".");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getPlanted() {
        return planted;
    }

    public void setPlanted(LocalDate planted) {
        this.planted = planted;
    }

    public LocalDate getWatering() {
        return watering;
    }

    public void setWatering(LocalDate watering) throws PlantException {
        if(watering.isBefore(getPlanted())) {
            throw new PlantException("Datum poslední zálivky je před datem zasazení rostliny "+watering+ "!");
        }
        this.watering = watering;
    }

    public int getFrequencyOfWatering() {
        return frequencyOfWatering;
    }

    public void setFrequencyOfWatering(int frequencyOfWatering) throws PlantException {
        if(frequencyOfWatering <= 0) {
            throw new PlantException("Nevalidní nastavení počtu dnů pro zálivku " +frequencyOfWatering+ ".");
        }
        this.frequencyOfWatering = frequencyOfWatering;
    }
}
