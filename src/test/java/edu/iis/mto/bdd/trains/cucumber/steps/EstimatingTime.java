package edu.iis.mto.bdd.trains.cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.pl.Gdy;
import cucumber.api.java.pl.I;
import cucumber.api.java.pl.Wtedy;
import cucumber.api.java.pl.Zakładając;

public class EstimatingTime {


    @Zakładając("^, że chcę się dostać z \"(.*)\" do \"(.*)\"$")
    public void givenStartingPointToDestinationPoint(String fromLocalization, String toLocalization) throws Throwable {
        throw new PendingException();
    }

    @I("^następny pociąg odjeżdża o (\\d+):(\\d+) na linii \"(.*)\"")
    public void setUpNextTrain(int hours, int minutes, String line) throws Throwable {
        throw new PendingException();
    }

    @Gdy("^zapytam o godzinę przyjazdu$")
    public void whenAskingForArrivingTime() throws Throwable {
        throw new PendingException();
    }

    @Wtedy("^powinienem uzyskać następujący szacowany czas przyjazdu: (\\d+):(\\d+)$")
    public void thenShouldGetArrivingTime(int hours, int minutes) throws Throwable {
        throw new PendingException();
    }
}
