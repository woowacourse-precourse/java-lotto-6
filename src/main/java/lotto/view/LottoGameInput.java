package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.validator.LottoValidator;
import lotto.util.validator.Validator;
import lotto.util.validator.WinningNumbersValidator;
import lotto.view.enums.LottoInterfaceMessage;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGameInput {
    private static final String BLANK = "";
    private static final String SPACE = " ";
    private static final String COMMA = ",";

    public static int readPurchaseAmount() {
        System.out.println(LottoInterfaceMessage.INSERT_MONEY.getMessage());
        String purchaseAmount = Console.readLine();
        Validator.validateNumeric(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }

    public static List<Integer> readWinningNumbers() {
        System.out.println(LottoInterfaceMessage.ENTER_WINNING_NUMBER.getMessage());
        String winningNumbers = Console.readLine();
        WinningNumbersValidator.validate(winningNumbers);

        return Stream.of(winningNumbers.replace(SPACE, BLANK).split(COMMA))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int readBonusNumber() {
        System.out.println(LottoInterfaceMessage.ENTER_BONUS_NUMBER.getMessage());
        String bonusNumber = Console.readLine();
        LottoValidator.validateRange(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }
}
