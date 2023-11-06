package lotto.view;

import static lotto.view.constants.ConstantMessage.REQUEST_INPUT_PRICE;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.utils.Parser;
import lotto.view.constants.ConstantMessage;

public class ConsoleInput {
    public static Integer readLottoAmount() {
        String line = Console.readLine();
        return Parser.parseAmountOfMoney(line);
    }

    public static Lotto readLottoNumbers() {
        String line = Console.readLine();
        return Parser.parseLotto(line);
    }

    public static Integer readLottoBonusNumber() {
        String line = Console.readLine();
        return Parser.parseLottoBonusNumber(line);
    }
}
