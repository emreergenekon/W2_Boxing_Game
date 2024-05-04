import java.util.Random;

public class Ring {

    Fighter Ken;
    Fighter Ryu;
    int minWeight;
    int maxWeight;

    public Ring(Fighter Ken, Fighter Ryu, int minWeight, int maxWeight) {
        this.Ken = Ken;
        this.Ryu = Ryu;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    public void run() {

        if (checkWeight()) {

            Random random = new Random();
            Fighter firstAttacker = random.nextDouble() < 0.5 ? Ken : Ryu;

            while (Ken.health > 0 && Ryu.health > 0) {
                System.out.println("====== Yeni Round =========");
                Ryu.health = Ken.hit(Ryu);
                if (isWin()) {
                    break;
                }
                Ken.health = Ryu.hit(Ken);
                if (isWin()) {
                    break;
                }
                printScore();
            }

        } else {
            System.out.println("Sporcuların ağırlıkları uyuşmuyor");
        }
    }
//weight max-min inputs.
    public boolean checkWeight() {
        return (Ken.weight >= minWeight && Ken.weight <= maxWeight) && (Ryu.weight >= minWeight && Ryu.weight <= maxWeight);
    }

    //2 possibilities to finalize game.
    public boolean isWin() {
        if (Ken.health == 0) {
            System.out.println("Maçı Kazanan: " + Ryu.name);
            return true;
        } else if (Ryu.health == 0) {
            System.out.println("Maçı Kazanan: " + Ken.name);
            return true;
        }
        return false;
    }
//status text in every round.
    public void printScore() {
        System.out.println("----------");
        System.out.println(Ken.name + "Kalan Can\t: " + Ken.health);
        System.out.println(Ryu.name + "Kalan Can\t: " + Ryu.health);

    }
}








