package domain;

import camp.nextstep.edu.missionutils.Console;

public class AmountInput {

    Integer lottoAmount;

    public AmountInput() {
        String amount = validateAmount();
        this.lottoAmount = Integer.parseInt(amount);
    }

    private String validateAmount() {
        String amount = "";

        try {
            amount = Console.readLine();
            validateAmountUnder(amount);
            validateAmountUnit(amount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            validateAmount();
        }

        return amount;
    }

    private void validateAmountUnder(String amount) {
        if (Integer.parseInt(amount) < 1000) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 이상이어야 합니다.");
        }
    }

    private void validateAmountUnit(String amount) {
        if (Integer.parseInt(amount) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000 단위여야합니다.");
        }
    }


}

