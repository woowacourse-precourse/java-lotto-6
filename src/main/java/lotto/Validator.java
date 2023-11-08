package lotto;

public class Validator {

    public static Integer purchaseAmountValidation(String purchaseAmountString) {

        Integer purchaseAmount;

        try {
            purchaseAmount = Integer.valueOf(purchaseAmountString);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] : 숫자만 입력해주시기 바랍니다.");
        }

        if (purchaseAmount % 1000 >= 1) {
            throw new IllegalArgumentException("[ERROR] : 1000원 단위로 입력해주시기 바랍니다.");
        }

        return purchaseAmount / 1000;
    }
}
