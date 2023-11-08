package lotto.util;

import java.util.HashSet;
import java.util.List;
import lotto.Enum.ErrorStatus;

public class ExceptionModule {

    public static Integer checkParseIntException(String consoleRead) throws IllegalArgumentException{
        try {
            return Integer.parseInt(consoleRead);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorStatus.PARSE_INT_ERROR.getMessage());
        }
    }

    public static void checkNegative(Integer tryNum) throws IllegalArgumentException{
        if (tryNum < 0) {
            throw new IllegalArgumentException(ErrorStatus.NEGATIVE_INPUT_ERROR.getMessage());
        }
    }

    public static void checkThousandException(Integer tryNum, Integer LOTTO_PRICE) throws IllegalArgumentException{
        if (tryNum % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorStatus.NOT_DIVISION_THOUSAND_ERROR.getMessage());
        }
    }

    public static void checkLottoCount(Integer lottosSize, Integer lottoCount) throws IllegalStateException{
        if (!lottosSize.equals(lottoCount)) {
            throw new IllegalStateException();
        }
    }

    public static void checkWinningNumDubAndSize(List<Integer> winningNum) throws IllegalArgumentException{
        if (new HashSet<>(winningNum).size() != 6) {
            throw new IllegalArgumentException(ErrorStatus.WINNING_NUM_DUB_AND_SIZE_ERROR.getMessage());
        }
    }

    public static void checkNumBoundary(Integer num) throws IllegalArgumentException{
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException(ErrorStatus.LOTTO_BOUNDARY_ERROR.getMessage());
        }
    }

    public static void checkBonusNumDub(Integer bonusNum, List<Integer> winningNum) throws IllegalArgumentException{
        if (winningNum.contains(bonusNum)) {
            throw new IllegalArgumentException(ErrorStatus.BONUS_NUM_DUB_ERROR.getMessage());
        }
    }
}
