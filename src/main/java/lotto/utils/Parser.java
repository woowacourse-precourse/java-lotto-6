package lotto.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {

    public Integer parseLottoCount(String input) {
        validateCount(input);
        return Integer.valueOf(input) / 1000;
    }

    public void checkEmpty(String input) throws IllegalArgumentException {
        if(input.isEmpty()) {
            System.out.println("[ERROR] 입력값이 빈 값입니다.");
            throw new IllegalArgumentException();
        }
    }

    public void checkDigit(String input) throws IllegalArgumentException {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 입력값은 숫자여야합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void checkThousand(int number) throws IllegalArgumentException {
        if((number % 1000) != 0) {
            System.out.println("[ERROR] 로또 입력 금액은 1000원 단위여야 합니다.");
            throw new IllegalArgumentException();
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
    }

    public int parseBonusNum(String input, List<Integer> winningNum) {
        validateBonus(input);
        return Integer.valueOf(input);
    }

    private void validateBonus(String input) {
        checkEmpty(input);
        checkDigit(input);
    }
}
