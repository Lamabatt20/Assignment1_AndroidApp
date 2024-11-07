package com.example.medimemory;

public class Medication {
    private String name;
    private String timeOfDay;
    private String frequency;
    private String description;
    private int imageResourceId;
    private boolean isTaken;

    public Medication(String name,String frequency,String timeOfDay,String description,int imageResourceId,boolean isTaken) {
        this.name = name;
        this.timeOfDay=timeOfDay;
        this.frequency=frequency;
        this.description=description;
        this.imageResourceId=imageResourceId;
        this.isTaken=isTaken;
    }

    public static final Medication[] medication = {
            new Medication("Aspirin", "Twice a day","Morning","Used for pain relief",R.drawable.asp,false),
            new Medication("Vitamin C", "Once a day","Morning","Supplement for immune support",R.drawable.vit,true),
            new Medication("Amoxicillin", "Twice a day","Morning","Antibiotic for bacterial infections",R.drawable.amo,true),
            new Medication("paracetamol", "Three times a day","Afternoon","Fever reducer and pain reliever",R.drawable.para,false),
            new Medication("acamol","once a day ","anyTime","headache reliever",R.drawable.aca,false),
            new Medication("Skin Care", "Once a day", "Night", "Moisturizes and nourishes the skin", R.drawable.skin_care, false)
    };

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getTimeOfDay() {
        return timeOfDay;
    }

    public String getFrequency() {
        return frequency;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
