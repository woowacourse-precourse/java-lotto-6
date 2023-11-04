package lotto.model;

public class Money {
    static int unit  = 1000;
    public static int countMoney(int givenMoney) {
        return givenMoney/unit;
    }

    public static void checkMoney(int givenMoney) {
        if(givenMoney % unit != 0 ){
            throw new IllegalArgumentException("[ERROR]" + givenMoney);
        }
    }
}
