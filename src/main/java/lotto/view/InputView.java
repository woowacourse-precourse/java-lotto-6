package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.request.BonusNumberDto;
import lotto.dto.request.PurchaseAmountDto;
import lotto.dto.request.WinningNumbersDto;
import lotto.util.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String SPLIT_SYMBOL = ",";

    private InputView() {
    }

    public static InputView getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final InputView INSTANCE = new InputView();
    }

    public PurchaseAmountDto readPurchaseAmount() {
        String amount = Console.readLine();
        return PurchaseAmountDto.from(amount);
    }

    public WinningNumbersDto readWinningNumbers() {
        List<Integer> numbers = parseNumbers(Console.readLine());
        return WinningNumbersDto.from(numbers);
    }

    public BonusNumberDto readBonusNumber() {
        int bonus = Validator.validateAndParseInteger(Console.readLine());
        return BonusNumberDto.from(bonus);
    }

    private static List<Integer> parseNumbers(String numbers) {
        return Arrays.stream(numbers.split(SPLIT_SYMBOL))
                .map(Validator::validateAndParseInteger)
                .collect(Collectors.toList());
    }
}
