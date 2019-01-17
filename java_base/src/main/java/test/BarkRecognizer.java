package test;

import java.util.List;

public class BarkRecognizer {
    private DogDoor dogDoor;

    public void recognized(Bark bark) {
        List<Bark> allowBarks = dogDoor.getAllowBarks();
        for (Bark allowBark : allowBarks) {
            if (allowBark.equals(bark)) {
                dogDoor.open();
            }
        }
    }

    public BarkRecognizer(DogDoor dogDoor) {
        this.dogDoor = dogDoor;
    }
}
