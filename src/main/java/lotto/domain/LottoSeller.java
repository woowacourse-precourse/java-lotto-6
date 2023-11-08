package lotto.domain;

import lotto.Constant;
import lotto.Util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoSeller {

    private final List<Integer> winningNumber;
    private int bonusNumber;

    private static final String INVALID_LOTTO_PICK_NUMBER = "입력된 숫자를 다시 확인하세요.";
    private static final String INVALID_BONUS_NUMBER = "입력가능한 보너스 숫자 범위를 초과했습니다.";
    private static final String OVERLAP_NUMBER = "중복된 로또번호입니다.";

    public LottoSeller(String winningNumber, String bonusNumber) {
        this.winningNumber = validWinningNumber(winningNumber);
        this.bonusNumber = validBonusNumber(bonusNumber);
    }

    private List<Integer> validWinningNumber(String input) {
        String[] winningNumber = input.split(",");

        Set<Integer> output = new HashSet<>();
        for (String number : winningNumber) {
            output.add(Util.toInteger(number));
        }

        if (output.size() != Constant.LOTTO_PICK_NUMBER) {
            throw new IllegalArgumentException(Constant.ERROR_PREFIX + INVALID_LOTTO_PICK_NUMBER);
        }

        return output.stream().toList();
    }

    private int validBonusNumber(String input) {
        int bonusNumber = Util.toInteger(input);

        if (bonusNumber < Constant.LOTTO_MIN_NUMBER || bonusNumber > Constant.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(Constant.ERROR_PREFIX + INVALID_BONUS_NUMBER);
        }

        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(Constant.ERROR_PREFIX + OVERLAP_NUMBER);
        }

        return bonusNumber;
    }
}
