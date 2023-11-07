package lotto;

import java.util.List;

public class Game {
    public int ranking(int[] result) {
        int winningNumberMatchCount = result[0];
        int bonusNumberMatchCount = result[1];

        if (winningNumberMatchCount == 6)
            return 1;
        if (winningNumberMatchCount == 5 && bonusNumberMatchCount == 1)
            return 2;
        if (winningNumberMatchCount == 5 && bonusNumberMatchCount == 0)
            return 3;
        if (winningNumberMatchCount == 4)
            return 4;
        if (winningNumberMatchCount == 3)
            return 5;

        return 6;
    }

    public int[] checkOneLotto(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int winningNumberMatchCount = 0;
        int bonusNumberMatchCount = 0;
        int[] result = new int[2];

        List<Integer> lottoNumbers = lotto.getNumbers();

        for (Integer lottoNumber : lottoNumbers) {
            if(winningNumbers.contains(lottoNumber))
                winningNumberMatchCount++;
            if(lottoNumber == bonusNumber)
                bonusNumberMatchCount++;
        }
        result[0] = winningNumberMatchCount;
        result[1] = bonusNumberMatchCount;

        return result;
    }

    public int[] checkAllLotto(List<Lotto> lottoList, List<Integer> winningNumbers, int bonusNumber) {
        int[] winningStatistics = new int[6];

        for(Lotto lotto : lottoList) {
            int rank = ranking(checkOneLotto(lotto, winningNumbers, bonusNumber));
            winningStatistics[rank-1]++;
        }
        return winningStatistics;
    }

    public int getTotalReturn(int[] winningStatistics) {
        int totalReturn = winningStatistics[0] * 2000000000
                + winningStatistics[1] * 30000000
                + winningStatistics[2] * 1500000
                + winningStatistics[3] * 50000
                + winningStatistics[4] * 5000;

        return totalReturn;
    }

    public double getTotalReturnPercentage(int purchaseAmount, int totalReturn) {
        double totalReturnPercentage = (double)totalReturn/purchaseAmount;
        return totalReturnPercentage * 100;
    }
}
