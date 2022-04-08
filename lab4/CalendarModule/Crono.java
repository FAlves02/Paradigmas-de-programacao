package CalendarModule;

import java.util.Calendar;

public class Crono extends Thread{

    private Calendar date;
    private boolean running;


    public Crono(){
        running = true;
        initDate();
    }

    private void initDate() {
        this.date = Calendar.getInstance();
        this.date.set(0,0,0,0,0,55);
    }

    public String getDate() {
        return date.get(Calendar.HOUR) + ":" + date.get(Calendar.MINUTE) + ":" + date.get(Calendar.SECOND);
    }

    public void run(){
        Thread t = new Thread(() -> {
            while(running) {
                date.add(Calendar.SECOND, 1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }

    public void reset(){
        initDate();
    }

    public void pause()  {
        running = false;
    }

    public void go(){
        running = true;
        run();
    }

}

