package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.request.BonusNumberInputDto;
import lotto.dto.request.PurchaseAmountDto;
import lotto.dto.request.WinningNumbersInputDto;
import lotto.util.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private InputView() {
    }

    public static InputView getInstance() {
        return LazyHolder.INSTANCE;
    }

    public PurchaseAmountDto readPurchaseAmount() {
        String amount = Console.readLine();
        return PurchaseAmountDto.from(amount);
    }

    public WinningNumbersInputDto readWinningNumbers() {
        List<Integer> numbers = parseNumbers(Console.readLine());
        return WinningNumbersInputDto.from(numbers);
    }

    public BonusNumberInputDto readBonusNumber() {
        int bonus = Validator.validateAndParseInteger(Console.readLine());
        return BonusNumberInputDto.from(bonus);
    }

    private static List<Integer> parseNumbers(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(Validator::validateAndParseInteger)
                .collect(Collectors.toList());
    }

    private static class LazyHolder {
        private static final InputView INSTANCE = new InputView();
    }
}
