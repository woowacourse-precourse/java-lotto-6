package model.dto;

import static consts.Mark.INPUT_SEPARATOR;

import java.util.Arrays;
import java.util.List;

public record AnswerLottoNumbers(String answerLottoNumbers) {

    public List<String> divideNumbers() {
        return Arrays.stream(answerLottoNumbers.split(INPUT_SEPARATOR.mark()))
            .toList();
    }
}
