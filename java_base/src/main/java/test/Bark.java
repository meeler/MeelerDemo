package test;

public class Bark {
    private String sound;

    public String getSound() {
        return sound;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Bark) {
            Bark otherBark = (Bark) o;
            if (sound.equalsIgnoreCase(otherBark.getSound())) {
                return true;
            }
        }
        return false;
    }

}
