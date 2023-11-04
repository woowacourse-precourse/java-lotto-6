package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller {
    private List<Lotto> lottoTickets;
    public void run() {
        /**
         * 돈 입력 받기 x
         * 돈 만큼 로또 발행하기 x
         *
         */
        purchaseLotto(inputMoneyFromUser());

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

    private void purchaseLotto(int money) {
        int purchasableLotto = money / 1000;
        lottoTickets = new ArrayList<Lotto>();

        for (int i = 0; i < purchasableLotto; i++) {
            List<Integer> randomLottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(randomLottoNumber);
            Lotto lotto = new Lotto(randomLottoNumber);
            lottoTickets.add(lotto);
        }
    }
}
