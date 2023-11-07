package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller {
    public void run() {
        int money = inputMoneyFromUser();
        List<Lotto> lottoTickets = purchaseLotto(money);
        printLottoNumbers(lottoTickets);
        WinningNumber winningNumber = inputWinningNumberFromUser();
        List<LottoRank> rankList = compareLottoNumber(winningNumber, lottoTickets);
        lottoResult(rankList, money);
    }

    private void lottoResult(List<LottoRank> rankList, int money) {
        Statistic statistic = new Statistic(rankList);
        OutputView.lottoResultMessage(statistic, money);
    }

    private List<LottoRank> compareLottoNumber(WinningNumber winningNumber, List<Lotto> lottoTickets) {
        List<LottoRank> rankList = new ArrayList<>();
        for (Lotto lotto : lottoTickets) {
            rankList.add(winningNumber.compareNumbers(lotto.getNumbers()));
        }
        return rankList;
    }

    private int inputMoneyFromUser() {
        try {
            Money money = new Money(InputView.inputMoney());
            return money.getMoney();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMoneyFromUser();
        }
    }

    private List<Lotto> purchaseLotto(int money) {
        int purchasableLotto = money / 1000;
        OutputView.purchaseLottoMessage(purchasableLotto);
        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i < purchasableLotto; i++) {
            List<Integer> randomLottoNumber = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(randomLottoNumber);
            Lotto lotto = new Lotto(randomLottoNumber);
            lottoTickets.add(lotto);
        }
        return lottoTickets;
    }

    private void printLottoNumbers(List<Lotto> lottoTickets) {
        OutputView.lottoNumberMessage(lottoTickets);
    }

    private WinningNumber inputWinningNumberFromUser() {
        try {
            Lotto lotto = new Lotto(InputView.inputLottoNumber());
            int inputBonusNumber = InputView.inputBonusNumber();
            return new WinningNumber(lotto.getNumbers(), inputBonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNumberFromUser();
        }
    }
}
