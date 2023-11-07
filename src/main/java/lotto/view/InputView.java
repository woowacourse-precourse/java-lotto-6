package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.InputValidator;

public class InputView {
    private static final String INPUT_BUY_PRICE = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static int inputLottoPrice() {
        System.out.println(INPUT_BUY_PRICE);
        String input = Console.readLine();

        InputValidator.validateLottoAll(input);

        return Integer.parseInt(input);
    }

    public static String inputLottoNum(){
        System.out.println();
        System.out.println(INPUT_LOTTO_NUMBERS);
        String inputWinningNumber = Console.readLine();

        InputValidator.validateInputLottoNum(inputWinningNumber);

        return inputWinningNumber;
    }

    public static String inputBonusNum(){
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER);
        String inputBonusNumber = Console.readLine();

        InputValidator.validateInputBonusNum(inputBonusNumber);

        return inputBonusNumber;
    }


}
