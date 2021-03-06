package edu.iis.mto.bdd.trains.cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.pl.Gdy;
import cucumber.api.java.pl.I;
import cucumber.api.java.pl.Wtedy;
import cucumber.api.java.pl.Zakładając;
import edu.iis.mto.bdd.trains.services.InMemoryTimetableService;
import edu.iis.mto.bdd.trains.services.TimetableService;
import org.joda.time.LocalTime;

public class StepsCollector {
    private TimetableService timetableService = new InMemoryTimetableService();

    private String startingPoint;
    private String destinationPoint;
    private String line;

    private LocalTime arrivingTime;

    @Zakładając("^, że chcę się dostać z \"(.*)\" do \"(.*)\"$")
    public void givenStartingPointToDestinationPoint(
            String startingPoint, String destinationPoint) throws Throwable {
        this.startingPoint = startingPoint;
        this.destinationPoint = destinationPoint;

        throw new PendingException();
    }

    @I("^następny pociąg odjeżdża o (\\d+):(\\d+) na linii \"(.*)\"")
    public void setUpNextTrain(
            @Transform(JodaLocalTimeConverter.class) LocalTime departureTime, String line) throws Throwable {
        timetableService.scheduleArrivalTime(line, departureTime);
        this.line = line;

        throw new PendingException();
    }

    @Gdy("^zapytam o godzinę przyjazdu$")
    public void whenAskingForArrivingTime() throws Throwable {
        arrivingTime = timetableService.getArrivalTime(line, destinationPoint);

        throw new PendingException();
    }

    @Wtedy("^powinienem uzyskać następujący szacowany czas przyjazdu: (\\d+):(\\d+)$")
    public void thenShouldGetArrivingTime(
            @Transform(JodaLocalTimeConverter.class) LocalTime expectedArrivingTime) throws Throwable {
        expectedArrivingTime.equals(arrivingTime);

        throw new PendingException();
    }
}
