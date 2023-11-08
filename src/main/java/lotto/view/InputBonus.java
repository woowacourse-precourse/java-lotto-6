package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.NumberException;
import lotto.exception.RangeException;

import java.util.List;
import java.util.regex.Pattern;

public class InputBonus {

    private static final String INPUT_BONUS_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final int MIN = 1;
    private static final int MAX = 45;


    public String input() {
        System.out.println(INPUT_BONUS_MESSAGE);
        return Console.readLine();
    }
    public int getBonus() {
        boolean validInput=false;
        String lottoNumbs = finalValidate(validInput);
        return Integer.parseInt(lottoNumbs);
    }

    private String finalValidate(boolean validInput) {
        String lottoNumbs = "";
        while (!validInput) {
            lottoNumbs = input();
            if (validException(lottoNumbs)) continue;
            validInput=true;
        }
        return lottoNumbs;
    }
    private boolean validException(String lottoNumbs) {
        if (!validateNum(lottoNumbs)) {
            return true;
        }
        if (!validateRange(lottoNumbs)) {
            return true;
        }
        return false;
    }

    private boolean validateNum(String bonus) {
        if (!Pattern.compile("\\d+").matcher(bonus).matches()) {
            System.out.println(NumberException.NOT_NUMBER_ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    private boolean validateRange(String bonus) {
        if (Integer.parseInt(bonus) < MIN || Integer.parseInt(bonus) > MAX) {
            System.out.println(RangeException.RANGE_ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
