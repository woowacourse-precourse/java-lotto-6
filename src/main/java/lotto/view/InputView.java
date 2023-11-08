package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;

import lotto.message.InputMessage;
import lotto.util.Validator;
import lotto.model.Lotto;

public class InputView {
    public int getLottoPurchaseAmount() {
        System.out.println(InputMessage.INPUT_PURCHASE_AMOUNT.getMessage());
        String input = Console.readLine();
        Validator.validateLottoPurchaseAmount(input);
        return Integer.parseInt(input);
    }

    public Lotto getWinningNumbers() {
        System.out.println(InputMessage.INPUT_WINNING_NUMBERS.getMessage());
        String input = Console.readLine();
        return stringtoLotto(input);
    }

    private static Lotto stringtoLotto(String inputValue) {
        List<String> input = List.of(inputValue.split(","));
        Validator.validateWinningNumbers(input);

        List<Integer> lotto  = input.stream()
                .map(Integer::valueOf)
                .sorted()
                .collect(Collectors.toList());

        return new Lotto(lotto);
    }

    public static int getBonusNumber() {
        System.out.println(InputMessage.INPUT_BONUS_NUMBER.getMessage());
        String input = Console.readLine();
        Validator.validateBonusNumber(input);
        return Integer.parseInt(input);
    }
}
