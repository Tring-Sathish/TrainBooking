package Admin;

public class Traindetails {

    public String trainName;
    String sourceLocation;
    String destinationLocation;
    public int chair;
    int chairac;
    int sleeper;
    int sleeperac;
    int distance;
    Float startTime;
    Float endTime;

    Traindetails(String trainName, String sourceLocation, String destinationLocation, Float startTime, Float endTime,
            int distance, int chair, int chairac, int sleeper, int sleeperac) {
        this.trainName = trainName;
        this.sourceLocation = sourceLocation;
        this.destinationLocation = destinationLocation;
        this.startTime = startTime;
        this.endTime = endTime;
        this.distance = distance;
        this.chair = chair;
        this.chairac = chairac;
        this.sleeper = sleeper;
        this.sleeperac = sleeperac;

    }

    public String toString() {
        return "\n\tTrain Details\n" + "\nTrain Name : " + trainName + "\nSource Location : " + sourceLocation
                + "\nDestination Location : "
                + destinationLocation
                + "\nStart Time : " + String.format("%.02f", startTime) + "\nEnd Time : "
                + String.format("%.02f", endTime) + "\nDistance : " + distance + "\nNo of Coaches :\n" + "\tChair : "
                + chair + "\tChair Ac : " + chairac + "\tSleeper : " + sleeper + "\tSleeper Ac : "
                + sleeperac;
    }

}
