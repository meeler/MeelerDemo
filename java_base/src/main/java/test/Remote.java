package test;

public class Remote {

    private DogDoor dogDoor;

    public void pressButton() {
        Boolean open = dogDoor.getOpen();
        if (open) {
            dogDoor.close();
        } else {
            dogDoor.open();
        }
    }
}
