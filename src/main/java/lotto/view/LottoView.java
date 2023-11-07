package lotto.view;


import static lotto.constant.ErrorMessage.ANOTHER_COMMA;
import static lotto.constant.ErrorMessage.CONTAIN_BLANK;
import static lotto.constant.ErrorMessage.EMPTY;
import static lotto.constant.ErrorMessage.INPUT_STRING;
import static lotto.constant.ErrorMessage.SEQUENCE_COMMA;
import static lotto.constant.LottoNumberMessage.ASK_Lotto_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.constant.LottoNumberMessage;

public class LottoView {


    public List<Integer> numbers() {
        List<Integer> lottoNumbers;
        printLottoNumberMessage(ASK_Lotto_NUMBER);
        String input = Console.readLine();
        validate(input);
        printSpace();
        lottoNumbers = parseNumbers(input);
        return lottoNumbers;
    }


    private void validate(String input) {
        validateNotNull(input);
        validateSequenceComma(input);
        validateIncorrectDelimiter(input);
        validateContainBlank(input);

    }

    private List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(s -> {
                    try {
                        return Integer.parseInt(s);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException(INPUT_STRING.getMessage());
                    }
                })
                .collect(Collectors.toList());
    }

    private void printLottoNumberMessage(LottoNumberMessage lottoNumberMessage) {
        System.out.println(lottoNumberMessage.getMessage());
    }

    private void validateSequenceComma(String input) {
        IntStream.range(1, input.length())
                .filter(i -> input.charAt(i) == ',' && input.charAt(i - 1) == ',')
                .findFirst()
                .ifPresent(i -> {
                    throw new IllegalArgumentException(SEQUENCE_COMMA.getMessage());
                });
    }


    private void validateNotNull(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY.getMessage());
        }
    }


    private void validateIncorrectDelimiter(String input) {
        if (input.contains(".")) {
            throw new IllegalArgumentException(ANOTHER_COMMA.getMessage());
        }
    }

    private void validateContainBlank(String input) {
        Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            throw new IllegalArgumentException(CONTAIN_BLANK.getMessage());
        }
    }

    private void printSpace() {
        System.out.println();
    }

}
