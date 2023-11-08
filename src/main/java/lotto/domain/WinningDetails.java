package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Lotto;

public class WinningDetails {

    static boolean visitedRandomLottos[] = new boolean[46];
    static boolean visitedWinningLottos[] = new boolean[46];
    static int rankingCount[] = new int[6];
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

    public static int[] findStatistics(List<Integer> rankings) {
        for (int i : rankings) {
            rankingCount[i]++;
        }
        return rankingCount;
    }

    public static double findReturns(int ticketCount, int[] statistics) {
        double ret = 0.0;
        ret += rankingCount[1] * 2000000000;
        ret += rankingCount[2] * 30000000;
        ret += rankingCount[3] * 1500000;
        ret += rankingCount[4] * 50000;
        ret += rankingCount[5] * 5000;

        return ret / ticketCount;
    }
}
