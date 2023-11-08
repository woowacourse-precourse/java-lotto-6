package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoWinningNumberInput {

    private static final String NUMBER_DELIMITER = ",";
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    public Set<Integer> requestLottoWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = Console.readLine();

                validateInputFormat(input);
                return convertInputToSet(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void validateInputFormat(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 없습니다.");
        }

        String[] numbers = input.split(NUMBER_DELIMITER);
        if (numbers.length != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }

        if (Arrays.stream(numbers).distinct().count() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다.");
        }
    }

    public Set<Integer> convertInputToSet(String input) {
        return Arrays.stream(input.split(NUMBER_DELIMITER))
                .map(String::trim)
                .map(this::parseAndValidateNumber)
                .collect(Collectors.toSet());
    }

    private int parseAndValidateNumber(String numberString) {
        int number = parseInt(numberString);
        validateNumberRange(number);
        return number;
    }

    private int parseInt(String numberString) {
        try {
            return Integer.parseInt(numberString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 숫자 형식입니다: " + numberString, e);
        }
    }

    private void validateNumberRange(int number) {
        if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException("[ERROR] 번호는 1과 45 사이여야 합니다: " + number);
        }
    }


}
