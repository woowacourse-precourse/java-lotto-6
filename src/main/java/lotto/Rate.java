package lotto;
public class Rate {

    public static double calculateRate(){
        double rate;
        int price = 0;
        int cnt = 0;

        for (Rank rank : Rank.values()){
            price = rank.getPrice();
            cnt = rank.getCnt();
        }
        rate = ((price * cnt) / (double)Input.money) * 100;
        return rate;
    }
}
