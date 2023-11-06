package lotto.view;

import static lotto.constant.MessageConstant.BONUS_NUMBER_INPUT_MESSAGE;
import static lotto.constant.MessageConstant.LOTTO_NUMBER_INPUT_MESSAGE;
import static lotto.constant.MessageConstant.LOTTO_PRICE_INPUT_MESSAGE;

public class InputView {
    public static void inputLottoPriceMessage() {
        System.out.println(LOTTO_PRICE_INPUT_MESSAGE.getMessage());
    }

    public static void inputLottoNumber() {
        System.out.println();
        System.out.println(LOTTO_NUMBER_INPUT_MESSAGE.getMessage());
    }

    public static void inputBonusNumber() {
        System.out.println();
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE.getMessage());
    }
}
