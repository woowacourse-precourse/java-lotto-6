package lotto;

import camp.nextstep.edu.missionutils.Console;

public class BuyLotto {
    private final ValidateInputNumber validateInputNumber = new ValidateInputNumber();

    public int inputBuyLotto() {
        while (true) {
            System.out.println("구매 금액을 입력해 주세요.");
            String amountValue = Console.readLine();
            int amount;
            try {
                amount = validateInputNumber.inputNumber(amountValue);
                if (amount % 1000 != 0) {
                    throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE + "구매 금액 단위는 1000원 입니다.");
                }
                int buyNumber = amount / 1000;
                System.out.println();
                System.out.println(buyNumber + "개를 구매했습니다.");
                return buyNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
