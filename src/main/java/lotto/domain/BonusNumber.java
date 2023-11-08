package lotto.domain;

import static lotto.domain.constants.LottoConstatants.LOTTO_MAX_NUMBER;
import static lotto.domain.constants.LottoConstatants.LOTTO_MIN_NUMBER;

import java.util.HashSet;
import java.util.Set;

public class BonusNumber {
    private static final int TOTAL_LOTTO_NUMBERS_SIZE = 7;
    private final Integer bonusNumber;
    private final WinningNumbers winningNumbers; // WinningNumbers 클래스의 참조를 보관


    public BonusNumber(String bonusNumber, WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers; // WinningNumbers 참조를 초기화
        bonusNumber = removeWhiteSpace(bonusNumber);
        validateNormalInput(bonusNumber);
        Integer bN = changeToNumber(bonusNumber);
        validateDuplicateWinningNumbers(bN);
        validateRange(bN);
        this.bonusNumber = bN;
    }

    private String removeWhiteSpace(String bonusNumber){
        bonusNumber = bonusNumber.trim();
        bonusNumber = bonusNumber.replace(" ", "");
        return bonusNumber;
    }

    private void validateNormalInput(String bonusNumber){
        if(!bonusNumber.matches("^-?\\d+$"))
            throw new IllegalArgumentException("[ERROR] 올바른 입력 형식이 아닙니다.");
    }

    private Integer changeToNumber(String bonusNumber){
        return Integer.parseInt(bonusNumber);
    }

    private void validateDuplicateWinningNumbers(Integer bN){
        Set<Integer> set = new HashSet<>(winningNumbers.getWinningNumbers());
        set.add(bN);
        if(set.size() != TOTAL_LOTTO_NUMBERS_SIZE)
            throw new IllegalArgumentException("[ERROR] 당첨번호와 보너스 번호가 중복 됩니다.");
    }

    private void validateRange(Integer bN){
        if(bN < LOTTO_MIN_NUMBER.getValue() || bN > LOTTO_MAX_NUMBER.getValue())
            throw new IllegalArgumentException("[ERROR] 로또 숫자 범위는 1 ~ 45 입니다.");
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
