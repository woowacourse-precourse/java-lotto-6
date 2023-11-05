package lotto.domain;

import java.util.List;

public class InputWinningNum {

    public static void inputWinningNumNotInt(String winningNum) {
        try {
            Integer.parseInt(winningNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
