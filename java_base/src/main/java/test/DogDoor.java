package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class DogDoor {
    private Boolean open;

    private List<Bark> barks;

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public void open() {
        open = true;
        System.out.println("dog door is open");
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (open) {
                    close();
                }
            }
        }, 5000L);
    }

    public void close() {
        open = false;
        System.out.println("dog door is closed");
    }

    public void addBark(Bark bark) {
        barks.add(bark);
    }

    public List<Bark> getAllowBarks() {
        return barks;
    }

    public DogDoor(List<Bark> barks) {
        this.open = false;
        this.barks = new ArrayList<Bark>();
    }
}
