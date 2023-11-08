package lotto.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {

    public Integer parseLottoCount(String input) {
        validateCount(input);
        return Integer.valueOf(input) / 1000;
    }

    private void checkEmpty(String input) throws IllegalArgumentException {
        if(input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 빈 값입니다.");
        }
    }

    private void checkDigit(String input) throws IllegalArgumentException {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력값은 숫자여야합니다.");
        }
    }

    private void checkThousand(int number) throws IllegalArgumentException {
        if((number % 1000) != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 입력 금액은 1000원 단위여야 합니다.");
        }
    }

    private void validateCount(String input) {
        checkEmpty(input);
        checkDigit(input);
        checkThousand(Integer.valueOf(input));
    }

    public List<Integer> parseWinningNum(String input) {
        return getWinningNum(input);
    }

    private List<Integer> getWinningNum(String input) {
        List<Integer> winningNum = new ArrayList<>();
        for(String s : splitNum(input)) {
            validateSplit(s);
            checkDuplicate(Integer.valueOf(s), winningNum);
            winningNum.add(Integer.valueOf(s));
        }

        return winningNum;
    }

    private List<String> splitNum(String input) {
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }

    private void validateSplit(String input) {
        checkEmpty(input);
        checkDigit(input);
        checkRange(input);
    }

    private void checkRange(String input) throws IllegalArgumentException {
        if(Integer.valueOf(input) < 1 || Integer.valueOf(input) > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자는 1이상 45이하여야 합니다.");
        }
    }

    private void checkDuplicate(int num, List<Integer> numList) throws IllegalArgumentException {
        if(numList.contains(num)) {
            throw new IllegalArgumentException("[ERROR] 로또 입력 값은 중복 되지 않아야 합니다.");
        }
    }

    public int parseBonusNum(String input, List<Integer> winningNum) {
        validateBouns(input);
        checkDuplicate(Integer.valueOf(input), winningNum);
        return Integer.valueOf(input);
    }

    private void validateBouns(String input) {
        checkEmpty(input);
        checkDigit(input);
        checkRange(input);
    }
}
