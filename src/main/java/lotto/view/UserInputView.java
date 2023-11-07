package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exceptions.ErrorMessages;
import lotto.model.LottoTicket;

public class UserInputView {

    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final int MIN_PURCHASE_AMOUNT = 1000;
    private static final int ZERO = 0;

    public static LottoTicket inputPurchaseAmount() {
        int lottoTicketCount;
        while (true) {
            System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
            String input = Console.readLine();
            try {
                int purchaseAmount = validateNumber(input);
                validateMinimumAmount(purchaseAmount);
                lottoTicketCount = validateDivisible(purchaseAmount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return new LottoTicket(lottoTicketCount);
    }


    private static int validateDivisible(int purchaseAmount) {
        if ((purchaseAmount % MIN_PURCHASE_AMOUNT != ZERO)) {
            throw new IllegalArgumentException(ErrorMessages.NON_DIVISIBLE_PURCHASE_AMOUNT.getMessage());
        }
        return purchaseAmount / MIN_PURCHASE_AMOUNT;
    }

    private static void validateMinimumAmount(int purchaseAmount) {
        if ((purchaseAmount / MIN_PURCHASE_AMOUNT <= ZERO)) {
            throw new IllegalArgumentException(ErrorMessages.MIN_PURCHASE_AMOUNT.getMessage());
        }
    }

    private static int validateNumber(String purchaseAmount) {
        if (!purchaseAmount.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_PURCHASE_AMOUNT.getMessage());
        }
        return Integer.parseInt(purchaseAmount);
    }


}