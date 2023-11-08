package lotto.model;

public class Money {
    public static final int MONEY_UNIT = 1000;
    private int inputMoney;
    private int playCount;
    private Money(){ }

    public Money(int inputMoney){
        validMoneyUnit(inputMoney);
        this.inputMoney = inputMoney;
        this.playCount = getPlayCount();
    }

    public int getPlayCount(){
        return inputMoney / MONEY_UNIT;
    }

    public int getInputMoney() {
        return inputMoney;
    }

    private void validMoneyUnit(int inputMoney){
        if(inputMoney % MONEY_UNIT != 0){
            throw new IllegalArgumentException(Valid.MONEY_UNIT.getErrorMessage());
        }
    }
}
