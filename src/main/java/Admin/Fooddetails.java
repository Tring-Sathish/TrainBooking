package Admin;

public class Fooddetails {
    String Name;
    int Price;
    float startTime;
    float endTime;

    Fooddetails(String Name, int Price, float startTime, float endTime) {
        this.Name = Name;
        this.Price = Price;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String toString() {
        return "\nName : " + Name + "\tPrice :  " + Price + "\tFrom :  "
                + String.format("%.02f", startTime) + "\tTill :  " + String.format("%.02f", endTime);
    }

}
