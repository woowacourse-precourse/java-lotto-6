package lotto.util;

import java.util.HashSet;
import java.util.List;

public class ExceptionModule {

    public static Integer checkParseIntException(String consoleRead) throws IllegalArgumentException{
        try {
            return Integer.parseInt(consoleRead);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 양의 정수를 입력해야 합니다.");
        }
    }

    public static void checkNegative(Integer tryNum) throws IllegalArgumentException{
        if (tryNum < 0) {
            throw new IllegalArgumentException("[ERROR] 양의 정수를 입력해야 합니다.");
        }
    }

    public static void checkThousandException(Integer tryNum, Integer LOTTO_PRICE) throws IllegalArgumentException{
        if (tryNum % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    public static void checkLottoCount(Integer lottosSize, Integer lottoCount) throws IllegalStateException{
        if (!lottosSize.equals(lottoCount)) {
            throw new IllegalStateException();
        }
    }

    public static void checkWinningNumDubAndSize(List<Integer> winningNum) throws IllegalArgumentException{
        if (new HashSet<>(winningNum).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않는 6자리 숫자여야 합니다.");
        }
    }

    public static void checkNumBoundary(Integer num) throws IllegalArgumentException{
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static void checkBonusNumDub(Integer bonusNum, List<Integer> winningNum) throws IllegalArgumentException{
        if (winningNum.contains(bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
    }
}
