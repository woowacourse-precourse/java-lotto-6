package lotto.domain.generator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.io.InputHandler;
import lotto.validation.LottoNumberValidator;

public class WinningNumbersGenerator implements Generator<List<String>, Lotto> {
    @Override
    public Lotto generate() {
        while (true) {
            String inputWithComma = InputHandler.askWinningNumbers();

            List<String> input = (Arrays.asList(inputWithComma.split(",")));
            if (validate(input)) {
                return new Lotto(convertToIntegers(input));
            }
        }
    }

    @Override
    public boolean validate(List<String> input) {
        LottoNumberValidator validator = new LottoNumberValidator();
        try {
            for (String str : input) {
                validator.validate(str);
            }
            List<Integer> numbers = convertToIntegers(input);
            new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            handleError(e.getMessage());
            return false;
        }
        return true;
    }

    private List<Integer> convertToIntegers(List<String> input) {
        return input.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
