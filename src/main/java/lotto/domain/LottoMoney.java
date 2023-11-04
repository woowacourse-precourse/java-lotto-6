package lotto.domain;

public class LottoMoney {
    private final int inputMoney;
    private final int count;

    public LottoMoney(int inputMoney, int count) {
        this.inputMoney = inputMoney;
        this.count = count;
    }

    public int getInputMoney() {
        return inputMoney;
    }
}
