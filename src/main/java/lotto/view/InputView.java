package lotto.view;

import static lotto.constant.UIConstant.NUMBER_SEPARATOR;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.dto.LottoPurchase;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.util.InputValidator;

public class InputView {
    public String readLine() {
        return Console.readLine();
    }

    public LottoPurchase getLottoPurchaseMoney() {
        String input = readLine();

        InputValidator.validateIsInteger(input);

        return LottoPurchase.from(Integer.parseInt(input));
    }

    public Lotto getWinningLottoNumbers() {
        String input = this.readLine();
        String[] split = input.split(NUMBER_SEPARATOR.toString());

        InputValidator.validateAllNumbersInteger(split);

        List<Integer> numbers = Arrays.stream(split).map(Integer::parseInt).toList();
        return Lotto.from(numbers);
    }

    public BonusNumber getBonusNumber() {
        String input = readLine();
        InputValidator.validateIsInteger(input);
        return BonusNumber.of(Integer.parseInt(input));
    }

}
