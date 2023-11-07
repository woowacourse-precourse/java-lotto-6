package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.Money;
import lotto.domain.WinningNumber;
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
        WinningNumber winningNumber = inputWinnigNumberFromUser();
        List<LottoRank> rankList = compareLottoNumber(winningNumber, lottoTickets);

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
        OutputView.lineBreakMessage();
        List<Lotto> lottoTickets = new ArrayList<Lotto>();

        for (int i = 0; i < purchasableLotto; i++) {
            List<Integer> randomLottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(randomLottoNumber);
            Lotto lotto = new Lotto(randomLottoNumber);
            lottoTickets.add(lotto);
        }
        return lottoTickets;
    }

    private void printLottoNumbers(List<Lotto> lottoTickets) {
        OutputView.lottoNumberMessage(lottoTickets);
    }

    private WinningNumber inputWinnigNumberFromUser() {
        try {
            Lotto lotto = new Lotto(InputView.inputLottoNumber());
            int inputBonusNumber = InputView.inputBonusNumber();
            WinningNumber winningNumber = new WinningNumber(lotto.getNumbers(), inputBonusNumber);
            return winningNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinnigNumberFromUser();
        }
    }
}
