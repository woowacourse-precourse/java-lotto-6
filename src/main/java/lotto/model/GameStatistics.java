package lotto;

import java.util.ArrayList;
import java.util.List;

public class GameStatistics {

    private List<Integer> matchingNumberCountList;
    private List<Rank> rankList;

    public void generateMatchingNumberCountList() {
        this.matchingNumberCountList = new ArrayList<>();
    }

    public List<Integer> getMatchingNumberCountList() {
        return matchingNumberCountList;
    }

    public List<Rank> getRankList() {
        return rankList;
    }

    public void generateRankList() {
        this.rankList = new ArrayList<>();
    }

    public void fillMatchingNumberCountList(
            List<Lotto> lottoList,
            List<Integer> winningNumbers,
            List<Integer> matchingNumberCountList) {
        for (Lotto lotto : lottoList) {
            int countTemp = 0;
            List<Integer> lottoNumbers = lotto.getNumbers();
            for (Integer lottoNumber : lottoNumbers) {
                countTemp += Controller.countMatchingNumbersByLotteryNumber(winningNumbers, lottoNumber);
            }
            matchingNumberCountList.add(countTemp);
        }
    }
}
