package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Domain.BonusNumberValidator;

public class InputView {
    private final static String INPUT_LOTTO_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private final static String INPUT_LOTTO_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final static String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static int inputLottoPurchaseAmount() {

        System.out.println(INPUT_LOTTO_PURCHASE_AMOUNT_MESSAGE);
        String input = Console.readLine();

        return Integer.parseInt(input);
    }

    public static String inputLottoNumbers() {

        System.out.println(INPUT_LOTTO_NUMBER_MESSAGE);
        String input = Console.readLine();

        return input;
    }


    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String input = Console.readLine();

        BonusNumberValidator.validateIsNumeric(input);
        int bonusNumber = Integer.parseInt(input);

        BonusNumberValidator.validateIsNumberInRange(bonusNumber);

        return bonusNumber;
    }

}
