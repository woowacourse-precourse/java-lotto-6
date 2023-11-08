package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class LottoBonusInput {
    static String lottoWinnerBonusNum = "";

    static void getBonusNumber() {
        lottoWinnerBonusNum = Console.readLine();
    }

    static boolean validateBonusNum() {
        try {
            if ((1 > Integer.parseInt(lottoWinnerBonusNum) || Integer.parseInt(lottoWinnerBonusNum) > 45)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.RANGE_IN_1_TO_45.getErrorMessage());
            return true;
        }
        try {
            if (LottoWinnerInput.lottoWinnerNum.contains(Integer.parseInt(lottoWinnerBonusNum))) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.NOT_DUPLICATE.getErrorMessage());
            return true;
        }
        return false;
    }
}
