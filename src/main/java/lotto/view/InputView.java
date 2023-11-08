package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import lotto.validator.BonusNumValidator;
import lotto.validator.LottoBoughtValidator;
import lotto.validator.LottoNumValidator;

public class InputView {
    public static int lottoBoughtPrice;
    public static String userNum, userBonusStr;

    public static void inputLottoBought() {
        String lottoBoughtPriceStr = Console.readLine();

        LottoBoughtValidator validator = new LottoBoughtValidator();
        validator.validate(lottoBoughtPriceStr);

        lottoBoughtPrice = Integer.parseInt(lottoBoughtPriceStr);
    }

    public static void inputUserNum() {
        userNum = Console.readLine();
    }

    public static void inputUserBonusStr() {
        userBonusStr = Console.readLine();

        BonusNumValidator validator = new BonusNumValidator();
        validator.validate(userBonusStr);
    }
}
