package lotto.service.impl;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Wallet;
import lotto.domain.WinningLotto;
import lotto.service.JudgeService;
import lotto.utils.ValueUnit;
import lotto.vo.Result;

public class JudgeServiceImpl implements JudgeService {

    private boolean isThirdToFifthPlace(int winCount) {
        ValueUnit fiveWins = ValueUnit.FIVE_WINS;
        ValueUnit threeWins = ValueUnit.THREE_WINS;
        return winCount <= fiveWins.getValue() && winCount >= threeWins.getValue();
    }

    private boolean isFirstPlace(int winCount) {
        ValueUnit allWins = ValueUnit.ALL_WINS;
        return winCount == allWins.getValue();
    }

    private boolean isSecondPlace(int winCount, boolean hasBonusNumber) {
        ValueUnit fiveWins = ValueUnit.FIVE_WINS;
        return winCount == fiveWins.getValue() && hasBonusNumber;
    }

    @Override
    public List<Result> compareLottoBundleAndWinnerNumbers(Wallet wallet, WinningLotto winnerNumbers) {
        List<Lotto> lottoBundle = wallet.getLottoBundle();
        List<Integer> winner = winnerNumbers.getWinnerNumbers();
        Integer bonusNumber = winnerNumbers.getBonusNumber();
        return lottoBundle.stream()
                .map(lotto -> makeResult(winner, bonusNumber, lotto))
                .toList();
    }

    private Result makeResult(List<Integer> winner, Integer bonusNumber, Lotto lotto) {
        boolean hasBonusNumber = isBonusNumberInLotto(bonusNumber, lotto);
        List<Integer> lottoNumbers = lotto.getLottoNumbers();
        int winCount = calcNumberOfWinningNumbers(winner, lottoNumbers);
        int rank = calcRank(winCount, hasBonusNumber);
        return new Result(rank);
    }

    private boolean isBonusNumberInLotto(Integer bonusNumber, Lotto lotto) {
        return lotto.isContainBonusNumber(bonusNumber);
    }

    private int calcNumberOfWinningNumbers(List<Integer> winner, List<Integer> lottoNumbers) {
        List<Integer> comparisonLottoAndWinner = new ArrayList<>(lottoNumbers);
        comparisonLottoAndWinner.retainAll(winner);
        return comparisonLottoAndWinner.size();
    }

    private int calcRank(int winCount, boolean hasBonusNumber) {
        ValueUnit noWin = ValueUnit.NO_WIN;
        if (isFirstPlace(winCount) || isSecondPlace(winCount, hasBonusNumber)) {
            ValueUnit minusOne = ValueUnit.MINUS_ONE;
            return winCount - minusOne.getValue();
        } else if (isThirdToFifthPlace(winCount)) {
            ValueUnit minusTwo = ValueUnit.MINUS_TWO;
            return winCount - minusTwo.getValue();
        }

        return noWin.getValue();
    }
}
