package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InvalidInputException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String SPLIT_STANDARD = ",";

    private final InputValidator inputValidator;

    public InputView() {
        inputValidator = new InputValidator();
    }

    public Integer purchaseLotto() {
        while (true) {
            try {
                String inputMoney = Console.readLine();
                inputValidator.validateInputMoney(inputMoney);

                return Integer.parseInt(inputMoney);
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public List<Integer> inputWinningNumbers() {
        String inputWinningNumbers = Console.readLine();
        List<Integer> winningNumbers = Arrays.stream(inputWinningNumbers.split(SPLIT_STANDARD))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return winningNumbers;
    }

    public Integer inputBonusNumber() {
        Integer bonusNumber = Integer.valueOf(Console.readLine());

        return bonusNumber;
    }
}
