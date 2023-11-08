package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.domain.BonusNumber;
import lotto.domain.LottoCounter;
import lotto.validator.InputValidator;

import java.util.Arrays;

public class InputView {

    private final InputValidator validator = new InputValidator();

    public LottoCounter readPurchaseAmount() {
        String input = Console.readLine();
        validator.validateIsNumber(input);
        return new LottoCounter(Integer.parseInt(input));
    }

    public Lotto readWinningNumber() {
        String input = Console.readLine();
        validator.validateDelimiter(input);
        return new Lotto(Arrays.stream(input.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList());
    }

    public BonusNumber readBonusNumber() {
        String input = Console.readLine();
        validator.validateIsNumber(input);
        return new BonusNumber(Integer.parseInt(input));
    }
}
