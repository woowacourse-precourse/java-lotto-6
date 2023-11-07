package lotto.controller;

import lotto.View;
import lotto.constant.Rank;
import lotto.constant.ViewMessage;
import lotto.model.Lotto;
import lotto.model.WinningLottoDTO;

import java.util.List;

public class ResultMachine {
    private final View view = new View();

    public Rank[] getWinningStat(List<Lotto> myLottos, WinningLottoDTO winningLotto) {
        int hits;
        boolean isMatchBonusNumber = false;
        Rank[] ranks = Rank.values();
        for (Lotto myLotto : myLottos) {
            hits = getRank(myLotto, winningLotto.getLotto());
            if (hits == 5) {
                isMatchBonusNumber = getMatchBonusNumber(winningLotto.getLotto(), winningLotto.getBonusNumber());
            }
            ranks[Rank.findRank(hits, isMatchBonusNumber).ordinal()].increaseMatchCount();
        }
        return ranks;
    }

    public void printWinningStat(Rank[] ranks) {
        view.printLine();
        view.print(ViewMessage.PRINT_WINNING_STAT.getMessage());
        for (Rank rank : ranks) {
            if (rank.getHits() == -1) continue;
            view.print(view.getPrintMatches(rank));
        }
    }

    public void printYieldRate(int purchaseQuantity, Rank[] ranks) {
        double sum = 0;
        double yieldRate;

        for (Rank rank : ranks) {
            sum += rank.getPrize() * (double)rank.getMatchCount();
        }
        yieldRate = sum / ((double)purchaseQuantity * 10);
        view.print(view.getPrintYieldRate(yieldRate));
    }


    private int getRank(Lotto myLotto, Lotto winningLotto) {
        int hits = 0;

        for (int myLottoNumber : myLotto.getLottoNumber()) {
            if (winningLotto.getLottoNumber().contains(myLottoNumber)) {
                hits++;
            }
        }
        return hits;
    }

    private boolean getMatchBonusNumber(Lotto winningLotto, int bonusNumber) {
        return winningLotto.getLottoNumber().contains(bonusNumber);
    }
}
