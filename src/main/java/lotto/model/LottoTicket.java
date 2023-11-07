package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private final List<Lotto> lottoList;

    public LottoTicket(List<Lotto> lottoList) {
        this.lottoList = new ArrayList<>(lottoList);
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
            return Prize.FIRST.getPrize();
        }
        if (numberOfWinningNumbers == 5 && bonusMatches) {
            return Prize.SECOND.getPrize();
        }
        if (numberOfWinningNumbers == 5) {
            return Prize.THIRD.getPrize();
        }
        if (numberOfWinningNumbers == 4) {
            return Prize.FOURTH.getPrize();
        }
        if (numberOfWinningNumbers == 3) {
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


    public List<Lotto> getLottoList() {
        return new ArrayList<>(lottoList);
    }
}
