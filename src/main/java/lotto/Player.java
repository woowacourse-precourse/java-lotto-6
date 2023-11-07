package lotto;

public class Player {
    private int buyMoney;
    private int bonusNumber;

    public void settingBuyMoney(int inputMoney) {
        this.buyMoney = inputMoney;
    }
    public void settingBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getBuyMoney() {
        return buyMoney;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
