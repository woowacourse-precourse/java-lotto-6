package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.util.LottoValidator;

public class SelectedNumbers {
    private List<String> numbers;
    private final List<Integer> selectedNumbers;
    private final LottoValidator validator = new LottoValidator();

    public SelectedNumbers(String inputNumbers) {
        makeSplittedNumbers(inputNumbers);
        validator.lottoNumbers(numbers);
        selectedNumbers = convertNums();
    }

    public List<String> giveSplittedNumbers() {
        return List.copyOf(numbers);
    }

    private void makeSplittedNumbers(String InputNumbers) {
        numbers = Arrays.asList(InputNumbers.split(",", -1));
        for (int i = 0; i < numbers.size(); i++) {
            numbers.set(i, numbers.get(i).trim());
        }
    }

    private List<Integer> convertNums() {
        List<Integer> converting = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            Integer converted = Integer.valueOf(numbers.get(i));
            converting.add(converted);
        }
        return List.copyOf(converting);
    }

    List<Integer> getSelectedNumbers() {
        return selectedNumbers;
    }
}
