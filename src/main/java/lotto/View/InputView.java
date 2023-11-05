package lotto.View;

import static lotto.Util.InputValidator.isNumber;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_LOTTO_PUCAHSE_AMOUNT_MESSAGE = "구입금액을 입력해주세요.";
    private static final String INPUT_LOTTO_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_LOTTO_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static String inputLottoPurchaseAmount() {
//        System.out.println(INPUT_LOTTO_PUCAHSE_AMOUNT_MESSAGE);
        boolean validInput = false;
        String input="";
        while (!validInput) {
            try {
                System.out.println(INPUT_LOTTO_PUCAHSE_AMOUNT_MESSAGE);
                input = Console.readLine();
                validInput = isNumber(input);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return input;
    }

    public static String inputLottoWinningNumber(){
        System.out.println("\n" + INPUT_LOTTO_WINNING_NUMBER_MESSAGE);

        return Console.readLine();
    }

    public static String inputLottoBonusNumber(){
        System.out.println("\n" + INPUT_LOTTO_BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
