package lotto.domain;

import lotto.exception.ErrorMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoResultCalculator {
    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;
    private List<Integer> winningRecords = new ArrayList<>();

    private LottoResultCalculator(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static LottoResultCalculator create(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        return new LottoResultCalculator(winningNumbers, bonusNumber);
    }

    private void validateBonusNumber(BonusNumber bonusNumber) {
        if (winningNumbers.getNumbers().contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATED.getMessage());
        }
    }

    public void calculateWinningRecords(Lottos lottos) {
        //TODO winningRecords 를 할당(1,2,3,4,5등 개수 계산해서 winningRecords에 넣기)
    }

    public void calculateProfit() {
        //TODO winningRecords, Prize 를 바탕으로 수익률 계산
    }

    public List<Integer> getWinningRecords() {
        return winningRecords;
    }
}
