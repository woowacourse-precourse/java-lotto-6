package lotto.service;

import lotto.domain.UserLotto;
import lotto.domain.WinningMoney;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoCalculator {

    private static final int LOTTO_SIZE = 6;
    private static final int RESULT_DATA_SIZE = 5;

    private final List<Integer> resultData;

    public LottoCalculator() {
        resultData = new ArrayList<>(Collections.nCopies(RESULT_DATA_SIZE, 0));
    }
    public List<Integer> calculateLottoWin(List<UserLotto> userLottos, List<Integer> winningNumber, int bonusNumber) {
        for (UserLotto userLotto : userLottos) {
            List<Integer> lottoNumber = userLotto.getNumbers();
            int winningCount = checkContainsWinning(winningNumber, lottoNumber);
            int bonusCount = checkContainsBonus(bonusNumber, lottoNumber);
            matchWinningCount(winningCount, bonusCount);
        }
        return resultData;
    }

    private void matchWinningCount(int winningCount, int bonusCount) {
        int index = winningCount - 3;
        if (winningCount == 5 && bonusCount == 1) {
            index = 3;
        }
        if (winningCount == 6) {
            index = 4;
        }
        if (index >= 0) {
            resultData.set(index, resultData.get(index) + 1);
        }
    }

    private static int checkContainsWinning(List<Integer> winningNumber, List<Integer> lottoNumber) {
        int winningCount = 0;
        for (int i = 0; i < LOTTO_SIZE; i++) {
            if (winningNumber.contains(lottoNumber.get(i))) {
                winningCount += 1;
            }
        }
        return winningCount;
    }

    private static int checkContainsBonus(int bonusNumber, List<Integer> lottoNumber) {
        int bonusCount = 0;
        if (lottoNumber.contains(bonusNumber)) {
            bonusCount += 1;
        }
        return bonusCount;
    }

    public double calculateRateOfReturn(int seedMoney, List<Integer> resultData) {
        int earnedMoney = 0;
        for (int i = 0; i < resultData.size(); i++) {;
            earnedMoney += resultData.get(i) * WinningMoney.values()[i].getValue();
        }
        return Double.parseDouble(String.format("%.1f", ((double) earnedMoney / seedMoney) * 100));
    }
}
