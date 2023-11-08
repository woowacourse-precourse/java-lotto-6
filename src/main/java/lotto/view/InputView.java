package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.system.SystemMessages;
import lotto.validator.BonusNumberValidator;
import lotto.validator.LottoValidator;
import lotto.validator.MoneyValidator;

public final class InputView {
    private static final MoneyValidator moneyValidator = new MoneyValidator();
    private static final BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();
    private static final LottoValidator lottoValidator = new LottoValidator();

    private InputView() {
    }

    public static int readAmount() {
        OutputView.printMessage(SystemMessages.READ_AMOUNT_MESSAGE);
        String line = Console.readLine();
        moneyValidator.check(line);
        return Integer.parseInt(line);
    }

    public static List<Integer> readWinningNumber() {
        OutputView.printMessage(SystemMessages.READ_WINNING_NUM_MESSAGE);
        String line = Console.readLine();
        lottoValidator.check(line);
        String[] winningNumbers = line.split(",");
        return Arrays.stream(winningNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int readBonusNumber() {
        OutputView.printMessage(SystemMessages.READ_BONUS_NUM_MESSAGE);
        String line = Console.readLine();
        bonusNumberValidator.check(line);
        return Integer.parseInt(line);
    }
}
