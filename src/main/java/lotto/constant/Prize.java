package lotto.constant;

public enum Prize {
    MONEYOFFIRST(2000000000),
    MONEYOFSECOND(30000000),
    MONEYOFTHIRD(1500000),
    MONEYOFFOURTH(50000),
    MONEYOFFIFTH(5000);
    private int money;
    Prize(int money) {
        this.money=money;
    }
    public int getMoney(){
        return money;
    }
}
