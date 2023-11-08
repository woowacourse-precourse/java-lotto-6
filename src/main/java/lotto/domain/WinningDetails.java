package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Lotto;

public class WinningDetails {

    static boolean visitedRandomLottos[] = new boolean[46];
    static boolean visitedWinningLottos[] = new boolean[46];
    static List<Integer> rankingResults = new ArrayList<>();

    public static List<Integer> findRanking(Lotto winningLottoNumbers, List<List<Integer>> randomLottos, int bonusNum) {

        Arrays.fill(visitedWinningLottos, false);
        List<Integer> winningLottoList = winningLottoNumbers.getNumbers();
        for (int i : winningLottoList) {
            visitedWinningLottos[i] = true;
        }

        for (List<Integer> randomLotto : randomLottos) {
            Arrays.fill(visitedRandomLottos, false);
            for (int i : randomLotto) {
                visitedRandomLottos[i] = true;
            }
            int sameCnt = 0;
            for (int i = 1; i <= 45; ++i) {
                if (visitedWinningLottos[i] && visitedRandomLottos[i]) {
                    sameCnt++;
                }
            }
            if (sameCnt == 6) {
                rankingResults.add(1);
                continue;
            }
            if (sameCnt == 5 && visitedRandomLottos[bonusNum]) {
                rankingResults.add(2);
                continue;
            }
            if (sameCnt == 5) {
                rankingResults.add(3);
                continue;
            }
            if (sameCnt == 4) {
                rankingResults.add(4);
                continue;
            }
            if (sameCnt == 3) {
                rankingResults.add(5);
                continue;
            }
            rankingResults.add(0);
        }

        return rankingResults;
    }
}
