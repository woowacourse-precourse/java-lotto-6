package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import lotto.constant.Condition;

public class LottoBuyer {
    private final List<Lotto> purchasedLottoes;
    private final Lotto winningNumbers;
    private final int bonusNumber;
    private final int money;

    public LottoBuyer(List<Lotto> purchasedLottoes, Lotto winningNumbers, int bonusNumber, int money) {
        this.purchasedLottoes = purchasedLottoes;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.money = money;
    }

    private void calculateRankEachLotto(List<Integer> myPrizes, Lotto lotto){
        int matchNumbers = lotto.compareLottoWithWinningNumber(winningNumbers);
        boolean matchBonusNumber = lotto.compareLottoWithBonusNumber(bonusNumber);
        int idx = Prize.checkPrize(matchNumbers, matchBonusNumber);
        myPrizes.set(idx, myPrizes.get(idx) + 1);
    }

    public List<Integer> retrieveAllResult(){
        List<Integer> myRanks = Arrays.asList(0, 0, 0, 0, 0, 0);
        purchasedLottoes
                .forEach(lotto -> calculateRankEachLotto(myRanks, lotto));
        return myRanks;
    }

}
