package io.pkp.daggermvp.model;

import javax.inject.Inject;

/**
 * Created by praveen on 5/29/16.
 */
public class Thermosiphon implements IPump{
    private final IHeater heater;

    @Inject
    Thermosiphon(IHeater heater) {
        this.heater = heater;
    }

    @Override public void pump() {
        if (heater.isHot()) {
            System.out.println("=> => pumping => =>");
        }
    }
}
