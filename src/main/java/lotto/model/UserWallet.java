package lotto.model;

public class UserWallet {

    private int myMoney;
    private int lottoPurchaseHistory;

    private UserWallet(int money){
        myMoney = money;
    }

    public int buyLotto(){
        return useMoney(myMoney);
    }

    public static UserWallet createWallet(int money){
        return new UserWallet(money);
    }

    private int useMoney(int usedMoney){
        lottoPurchaseHistory = myMoney/1000;
        myMoney -= usedMoney;
        return usedMoney;
    }

    public void receiveWinningsMoney(int receiveMoney) {
        saveMoney(receiveMoney);
    }

    private void saveMoney(int receiveMoney){
        myMoney += receiveMoney;
    }

}
