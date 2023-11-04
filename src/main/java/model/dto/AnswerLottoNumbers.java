package model.dto;

import java.util.Arrays;
import java.util.List;

public record AnswerLottoNumbers(String answerLottoNumbers) {

    private static final String NUMBER_SEPARATOR = ",";

    public List<String> divideNumbers() {
        return Arrays.stream(answerLottoNumbers.split(NUMBER_SEPARATOR))
            .toList();
    }
}
