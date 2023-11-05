package lotto.view;

import static lotto.global.constant.LottoConstant.LOTTO_NUMBER_SEPARATOR;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.global.constant.message.LottoMessage;
import lotto.global.util.Validator;

public class InputView {
    private final OutputView outputView;

    public InputView(OutputView outputView) {
        this.outputView = outputView;
    }


    public int readLottoPurchaseMoney() {
        outputView.printMessage(LottoMessage.INPUT_MONEY_AMOUNT);
        String amount = Console.readLine();
        Validator.validateIntFormat(amount);

        return Integer.parseInt(amount);
    }

    public List<Integer> readWinningNumbers() {
        outputView.printMessage(LottoMessage.INPUT_WINNING_NUMBER);
        String[] winningNumbers = Console.readLine().split(LOTTO_NUMBER_SEPARATOR);
        Validator.validateIntFormat(winningNumbers);

        return Arrays.stream(winningNumbers)
                .map(Integer::parseInt)
                .toList();
    }

    public int readBonusNumber() {
        outputView.printMessage(LottoMessage.INPUT_BONUS_NUMBER);
        String bonusNumber = Console.readLine();
        Validator.validateIntFormat(bonusNumber);

        return Integer.parseInt(bonusNumber);
    }
}
