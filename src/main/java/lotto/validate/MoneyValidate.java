package lotto.validate;

public class MoneyValidate {

    public int checkMoneyValidate(Integer inputMoney, int unit) {
        if (inputMoney < 0) {
            throw new IllegalArgumentException("금액");
        }
        if (inputMoney % unit != 0) {
            throw new IllegalArgumentException("금액 단위는:" + unit + "입니다.");
        }
        return inputMoney;
    }
}
