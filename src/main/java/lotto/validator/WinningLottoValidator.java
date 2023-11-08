package lotto.validator;

import lotto.constant.ErrorConstants;
import lotto.constant.InputConstants;
import lotto.constant.LottoConstants;
import lotto.util.Utils;

import java.util.List;

public class WinningLottoValidator {
    public static boolean isInvalid(String winningLotto) {
        try {
            Utils.convertStringToList(winningLotto);
        } catch (NumberFormatException e) {
            System.out.println(ErrorConstants.ERROR + ErrorConstants.INVALID_INPUT);
            return true;
        }
        return false;
    }

    public static boolean hasSpecialCharacter(String winningLotto) {
        if (!winningLotto.matches(InputConstants.INVALID_CHARACTER)) {
            System.out.println(ErrorConstants.ERROR + ErrorConstants.INVALID_CHARACTER);
            return true;
        }
        return false;
    }

    public static boolean isInvalidSize(String winningLotto) {
        List<Integer> winningLottos = Utils.convertStringToList(winningLotto);

        if (winningLottos.size() != 6) {
            System.out.println(ErrorConstants.ERROR + ErrorConstants.INVALID_WINNING_LOTTO_COUNT);
            return true;
        }
        return false;
    }

    public static boolean isDuplicated(String winningLotto) {
        List<Integer> winningLottos = Utils.convertStringToList(winningLotto);

        if (winningLottos.stream().distinct().count() != winningLottos.size()) {
            System.out.println(ErrorConstants.ERROR + ErrorConstants.DUPLICATE_WINNING_LOTTO);
            return true;
        }
        return false;
    }

    public static boolean isInvalidNumber(String winningLotto) {
        List<Integer> winningLottos = Utils.convertStringToList(winningLotto);

        if (winningLottos.stream().anyMatch(number -> number > LottoConstants.MAX_LOTTO_NUMBER
                || number < LottoConstants.MIN_LOTTO_NUMBER)) {
            System.out.println(ErrorConstants.ERROR + ErrorConstants.WINNING_LOTTO_OUT_OF_RANGE);
            return true;
        }
        return false;
    }
}
