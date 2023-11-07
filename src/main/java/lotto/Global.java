package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Global {
    private List<Lotto> issuedLottos;
    private HashMap<Rank, Integer>  rankStatistics;

    public Global() {
        this.issuedLottos = new ArrayList<>();
        this.rankStatistics = new HashMap<>();
    }

    public void setIssuedLottos(List<Lotto> issuedLottos) {
        this.issuedLottos = issuedLottos;
    }

    public int getLottoCount(int money) {
        return money / 1000;
    }

    public List<Lotto> getIssuedLottos(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = getRandomNumber();
            Collections.sort(lottoNumbers);
            Lotto lotto = new Lotto(lottoNumbers);
            issuedLottos.add(lotto);
        }
        return issuedLottos;
    }

    private List<Integer> getRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public void printIssuedLottoCountAndNumbers() {
        int lottoCount = issuedLottos.size();
        System.out.println("\n" + lottoCount + "개를 구매했습니다.");

        for (Lotto lotto : issuedLottos) {
            lotto.printLottoNumbers();
        }
    }

    public HashMap<Rank, Integer> calculateRanking(List<Integer> winningLotto) {
        initRankStatistics();
        for (Lotto lotto : issuedLottos) {
            Rank rank = lotto.compareWithWinningNumbers(winningLotto);
            int value = rankStatistics.get(rank);
            rankStatistics.put(rank, ++value);
        }
        return rankStatistics;
    }

    private void initRankStatistics() {
        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            rankStatistics.put(rank, 0);
        }
    }

    public void printRanking() {
        System.out.println("\n당첨 통계\n---");
        printEachRanking(Rank.FIFTH);
        printEachRanking(Rank.FOURTH);
        printEachRanking(Rank.THIRD);
        printEachRanking(Rank.SECOND);
        printEachRanking(Rank.FIRST);
    }

    private void printEachRanking(Rank rank) {
        String rankLabel = rank.getLabel();
        int rankCount = rankStatistics.get(rank);
        System.out.println(rankLabel + " - " + rankCount + "개");
    }
}
