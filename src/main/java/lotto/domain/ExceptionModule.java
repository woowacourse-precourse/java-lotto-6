package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class ExceptionModule {

    public static Integer checkParseIntException(String consoleRead) throws IllegalArgumentException{
        try {
            return Integer.parseInt(consoleRead);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkThousandException(Integer tryNum, Integer LOTTO_PRICE) throws IllegalArgumentException{
        if (tryNum % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkLottoCount(Integer lottosSize, Integer lottoCount) throws IllegalStateException{
        if (!lottosSize.equals(lottoCount)) {
            throw new IllegalStateException();
        }
    }

    public static void checkWinningNumDub(List<Integer> winningNum) throws IllegalArgumentException{
        if (new HashSet<>(winningNum).size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkWinningNumSize(List<Integer> winningNum) throws IllegalArgumentException{
        if (winningNum.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkNumBoundary(Integer num) throws IllegalArgumentException{
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException();
        }
    }
}
