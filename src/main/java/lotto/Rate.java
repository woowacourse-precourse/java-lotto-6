package lotto;
public class Rate {

    public static double calculateRate(){
        double rate=0;
        double price = 0;
        double cnt = 0;

        for (Rank rank : Rank.values()){
            price = rank.getPrice();
            cnt = rank.getCnt();
            rate += price * cnt;
        }
        rate = (rate / (double)Input.money) * 100;
        return rate;
    }
}
