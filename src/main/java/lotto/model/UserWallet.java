package lotto.model;

public class UserWallet {

    private int myMoney;
    private int usedMoney;

    private UserWallet(int money) {
        myMoney = money;
    }

    public int buyLotto() {
        return useMoney(myMoney);
    }

    public static UserWallet createWallet(int money) {
        return new UserWallet(money);
    }

    private int useMoney(int usedMoney) {
        this.usedMoney = usedMoney;
        myMoney -= usedMoney;
        return usedMoney;
    }

    public void receiveWinningsMoney(int receiveMoney) {
        saveMoney(receiveMoney);
    }

    private void saveMoney(int receiveMoney) {
        myMoney += receiveMoney;
    }

    public int usedMoney() {
        return usedMoney;
    }

    public int getMoney() {
        return myMoney;
    }
}
