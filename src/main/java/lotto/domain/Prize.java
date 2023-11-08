package lotto.domain;

public class Prize {
    private int firstPrize = 0;
    private int secondPrize = 0;
    private int thirdPrize = 0;
    private int forthPrize = 0;
    private int fifthPrize = 0;

    public void countPrize(Lottos lottos, WinningNumber winningNumber, BonusNumber bonusNumber) {
        for (int i = 0; i < lottos.getLottoCnt(); ++i) {
            Lotto lotto = lottos.getLotto(i);
            int matchCnt = compare(lotto, winningNumber);
            boolean hasBonus = false;

            if (matchCnt == 5) {
                hasBonus = lotto.contain(bonusNumber.getBonusNumber());
            }
            updatePrizeCount(matchCnt, hasBonus);
        }
    }

    public int compare(Lotto lotto, WinningNumber winningNumber) {
        return lotto.getMatchCnt(winningNumber);
    }

    private void updatePrizeCount(int matchCnt, boolean hasBonus) {
        if (matchCnt == 3) {
            fifthPrize++;
        } else if (matchCnt == 4) {
            forthPrize++;
        } else if (matchCnt == 5 && hasBonus) {
            secondPrize++;
        } else if (matchCnt == 5 ) {
            thirdPrize++;
        } else if (matchCnt == 6) {
            firstPrize++;
        }
    }
}
