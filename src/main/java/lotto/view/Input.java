package lotto.view;

import lotto.validation.InputValidator;
import lotto.validation.LottoNumberValidator;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;

public class Input {

    private static final String SEPARATOR = ",";

    private static Input input;

    private InputValidator inputValidator;
    private LottoNumberValidator lottoNumberValidator;

    public Input() {
        this.inputValidator = new InputValidator();
        this.lottoNumberValidator = new LottoNumberValidator();
    }

    public static Input getInstance() {
        if (input == null) {
            input = new Input();
        }
        return input;
    }

    public int inputPurchaseAmount() {
        String amount;
        try {
            amount = readLine();
            inputValidator.isNumber(amount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            amount = readLine();
        }

        return Integer.parseInt(amount);
    }

    public List<Integer> inputNumbers() {
        List<Integer> numbers;
            try {
                String input = readLine();
                inputValidator.isNumbers(input);
                numbers = Arrays.stream(input.split(SEPARATOR)).sorted().mapToInt(Integer::parseInt).boxed().toList();
                lottoNumberValidator.run(numbers);
                return numbers;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                numbers = Arrays.stream(readLine().split(SEPARATOR)).sorted().mapToInt(Integer::parseInt).boxed().toList();
            }
        return numbers;
    }

    public int inputBonusNumber() {
        String number;
        try {
            number = readLine();
            inputValidator.isNumber(number);
            lottoNumberValidator.isValidNumber(Integer.parseInt(number));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            number = readLine();
        }

        return Integer.parseInt(number);
    }

}
