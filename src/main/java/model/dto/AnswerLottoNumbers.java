package model.dto;

import java.util.Arrays;
import java.util.List;
import model.Lotto;

public record AnswerLottoNumbers(String answerLottoNumbers) {

    private static final String NUMBER_SEPARATOR = ",";

    public Lotto toLotto() {
        List<Integer> numbers = Arrays.stream(answerLottoNumbers.split(NUMBER_SEPARATOR))
            .map(Integer::parseInt)
            .toList();

        return new Lotto(numbers);
    }
}
