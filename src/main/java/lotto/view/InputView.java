package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private final InputValidator inputValidator;

    public InputView() {
        inputValidator = new InputValidator();
    }

    public Integer purchaseLotto() {
        Integer inputMoney = Integer.parseInt(Console.readLine());
        inputValidator.validateInputMoney(inputMoney);

        return inputMoney;
    }

    public List<Integer> inputWinningNumbers() {
        String inputWinningNumbers = Console.readLine();
        List<Integer> winningNumbers = Arrays.stream(inputWinningNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return winningNumbers;
    }

    public Integer inputBonusNumber() {
        Integer bonusNumber = Integer.valueOf(Console.readLine());

        return bonusNumber;
    }
}
