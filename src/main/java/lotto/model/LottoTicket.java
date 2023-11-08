package lotto.model;

import java.util.*;

public class LottoTicket {
    private final List<Lotto> lottoList;
    public Map<Integer, Integer> rank;

    public LottoTicket(List<Lotto> lottoList) {
        this.lottoList = new ArrayList<>(lottoList);

        // Initialize rank map with values from 1 to 5 mapped to 0
        this.rank = new HashMap<>();
        for (int i = 1; i <= 5; i++) {
            rank.put(i, 0);
        }
    }

    public static LottoTicket generate(int numberOfLotto) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            lottoList.add(Lotto.generate());
        }
        return new LottoTicket(lottoList);
    }

    public int calculateTotalPrize(WinningNumbers winningNumbers, int bonusNumber) {
        int totalPrize = 0;
        for (Lotto lotto : lottoList) {
            int numberOfWinningNumbers = lotto.numberOfWinningNumbers(winningNumbers);
            boolean bonusMatches = lotto.contains(bonusNumber);

            totalPrize += calculatePrize(numberOfWinningNumbers, bonusMatches);
        }
        return totalPrize;
    }

    private int calculatePrize(int numberOfWinningNumbers, boolean bonusMatches) {
        if (numberOfWinningNumbers == 6) {
            increaseRank(1);
            return Prize.FIRST.getPrize();
        }
        if (numberOfWinningNumbers == 5 && bonusMatches) {
            increaseRank(2);
            return Prize.SECOND.getPrize();
        }
        if (numberOfWinningNumbers == 5) {
            increaseRank(3);
            return Prize.THIRD.getPrize();
        }
        if (numberOfWinningNumbers == 4) {
            increaseRank(4);
            return Prize.FOURTH.getPrize();
        }
        if (numberOfWinningNumbers == 3) {
            increaseRank(5);
            return Prize.FIFTH.getPrize();
        }
        return 0;
    }

    public double calculateEarningRate(int totalPrize, int purchaseAmount) {
        if (purchaseAmount == 0) {
            return 0;
        }
        double earningRate = ((double) totalPrize / purchaseAmount) * 100;
        return Math.round(earningRate * 100) / 100.0;
    }

    public void increaseRank(int key) {
        rank.put(key, rank.get(key) + 1);
    }


    public List<Lotto> getLottoList() {
        return new ArrayList<>(lottoList);
    }
}
