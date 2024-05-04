import java.lang.management.MemoryUsage;

public class Main {
    public static void main(String[] args) {
//Fighters all informations input area.
        Fighter Ken = new Fighter("Ken", 15, 80, 90, 90);
        Fighter Ryu = new Fighter("Ryu", 10, 95, 100, 20);
Ring r = new Ring(Ken, Ryu,90, 100);
        r.run();
    }
}