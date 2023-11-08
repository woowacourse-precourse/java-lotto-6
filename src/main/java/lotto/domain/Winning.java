package lotto.domain;

import lotto.exception.CustomException;
import lotto.exception.constant.ErrorCode;
import lotto.utils.Constant;

import java.util.List;

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

    public void setBonusNum(int bonusNum) {
        try {
            validateBonus(bonusNum);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        this.bonusNum = bonusNum;
    }

    private void validateBonus(int bonusNum) {
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
        boolean issOverRange = numbers.stream()
                .anyMatch(lottoNum -> lottoNum < Constant.START_INCLUSIVE || lottoNum > Constant.END_ENCLUSIVE);
        try {
            if (issOverRange) {
                throw new CustomException(ErrorCode.INVALID_LOTTO_NUMBER);
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
