package DateModule;

import java.util.Calendar;
import java.util.Date;

public class Crono extends Thread{

    private Date date;
    private boolean running;

    public Crono(){
        running = true;
        initDate();
    }

    private void initDate() {
        this.date = new Date(2022, Calendar.NOVEMBER, 10, 0, 0, 0);
    }

    public String getDate() {
        return date.getHours() + " : " + date.getMinutes() + " : " + date.getSeconds();
    }

    public void run(){
        while(running){
            date.setSeconds(date.getSeconds() +1);
//            System.out.println(getDate());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void reset(){
        initDate();
    }

    public void pause()  {
        running = !running;
    }

    public void go(){
        running = true;
    }

}

