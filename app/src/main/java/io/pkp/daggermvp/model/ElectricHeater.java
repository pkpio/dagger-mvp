package io.pkp.daggermvp.model;

/**
 * Created by praveen on 5/29/16.
 */
public class ElectricHeater implements IHeater {
    boolean heating;

    @Override public void on() {
        System.out.println("~ ~ ~ heating ~ ~ ~");
        this.heating = true;
    }

    @Override public void off() {
        this.heating = false;
    }

    @Override public boolean isHot() {
        return heating;
    }
}
