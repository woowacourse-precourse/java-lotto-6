package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PURCHASE_AMOUNT_INPUT_PROMPT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_INPUT_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_PROMPT = "보너스 번호를 입력해 주세요.";

    public int readPurchaseAmount(){
        System.out.println(PURCHASE_AMOUNT_INPUT_PROMPT);
        int purchaseAmount = readLineAndParseInt();
        return purchaseAmount;
    }

    private int readLineAndParseInt() {
        try {
            String input = Console.readLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다. 유효한 숫자를 입력해주세요.");
        }
    }



}
