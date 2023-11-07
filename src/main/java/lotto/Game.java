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
        int[] result = {winningNumberMatchCount, bonusNumberMatchCount};

        List<Integer> lottoNumbers = lotto.getNumbers();

        for (int index = 0; index < 6; index++) {
            if (lottoNumbers.get(index) == winningNumbers.get(index))
                winningNumberMatchCount++;
            if (lottoNumbers.get(index) == bonusNumber)
                bonusNumberMatchCount++;
        }
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
}
