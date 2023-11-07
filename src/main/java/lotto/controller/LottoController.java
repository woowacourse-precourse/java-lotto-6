package lotto.controller;

import lotto.domain.*;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Lotto.stringToList;
import static lotto.domain.LottoNumbers.randomsLottos;
import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public class LottoController {

    public void start() {
        LottoAmount lottoAmount = inputAmount();
        LottoPlayer lottoPlayer = new LottoPlayer(randomsLottos(lottoAmount));
        printLottos(lottoAmount, lottoPlayer);

        WinningNumber winningNumber = getWinningLotto(inputWinningNumber());
        List<Rank> ranks = getRanks(lottoPlayer, winningNumber);

        OutputView.printResult(ranks, lottoAmount);
    }

    private LottoAmount inputAmount() {
        try {
            return new LottoAmount(inputPrice());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputAmount();
        }
    }


    private Lotto inputWinningNumber() {
        try {
            List<Integer> LottoList = stringToList(inputPrizeNumber());
            return new Lotto(LottoList);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNumber();
        }
    }

    public WinningNumber getWinningLotto(Lotto lotto) {
        String bonusNumber = inputBonus();
        try {
            return new WinningNumber(lotto, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningLotto(lotto);
        }
    }

    public List<Rank> getRanks(LottoPlayer lottoPlayer, WinningNumber winningNumber) {
        List<Rank> ranks = new ArrayList<>();

        for (Lotto lotto : lottoPlayer.getLottos()) {
            Rank rank = Rank.calculateRank(lotto, winningNumber);
            ranks.add(rank);
        }
        return ranks;
    }

}
