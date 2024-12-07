/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class task {
    private final String name;
    private final String description;
    private final int duration;
    private static int idCounter = 1;
    private final int id;

    public task(String name, String description, int duration) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.id = idCounter++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Task ID: " + id + "\nName: " + name + "\nDescription: " + description + "\nDuration: " + duration + " hours";
    }
}
