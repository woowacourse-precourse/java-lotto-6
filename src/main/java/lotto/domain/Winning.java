package lotto.domain;

import lotto.exception.CustomException;
import lotto.exception.constant.ErrorCode;
import lotto.utils.Constant;

import java.util.List;
import java.util.stream.Collectors;

public class Winning {
    private Lotto winningLotto;
    private int bonusNum;
    public Winning() {

    }

    public void setWinning(List<Integer> numbers) {
        try {
            validateNumber(numbers);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        this.winningLotto = new Lotto(numbers);
        this.bonusNum = 0;
    }

    public void setBonusNum(String bonusNum) {
        try {
            validateBonus(bonusNum);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        this.bonusNum = Integer.parseInt(bonusNum);
    }

    private void validateBonus(String bonus) {
        int bonusNum = 0;
        try {
            bonusNum = Integer.parseInt(bonus);
        } catch (IllegalArgumentException e) {
            throw new CustomException(ErrorCode.INVALID_NUMBER_REGEX);
        }
        try {
            if (bonusNum < Constant.START_INCLUSIVE || bonusNum > Constant.END_ENCLUSIVE) {
                throw new CustomException(ErrorCode.INVALID_LOTTO_NUMBER);
            }
            if (winningLotto.contain(bonusNum)) {
                throw new CustomException(ErrorCode.ALREADY_DRAW_NUMBER);
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void validateNumber(List<Integer> numbers) {
        List<Integer> uniqueNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        boolean issOverRange = uniqueNumbers.stream()
                .anyMatch(lottoNum -> lottoNum < Constant.START_INCLUSIVE || lottoNum > Constant.END_ENCLUSIVE);
        try {
            if (issOverRange) {
                throw new CustomException(ErrorCode.INVALID_LOTTO_NUMBER);
            }
            if (uniqueNumbers.size() != 6) {
                throw new CustomException(ErrorCode.DUPLICATED_LOTTO_NUMBER);
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
