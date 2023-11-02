package controller;

import java.util.ArrayList;
import java.util.List;
import view.InputView;
import view.OutputView;

import lotto.Lotto;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoController {
    private int money;

    private List<Lotto> lottoList = new ArrayList<>();

//    public LottoController() {
//    }

    public void set() {
        money = InputView.Money();
        int ticketCount = OutputView.LottoTicketCount(money);
        makeLottoLists(ticketCount);
    }

    private void makeLottoLists(int ticketCount) {
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoList.add(new Lotto(numbers));
            lottoList.get(i).printNumbers();
        }
    }
}
