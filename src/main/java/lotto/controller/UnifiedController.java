package lotto.controller;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.SystemConstant.DEFAULT_DEPTH;
import static lotto.SystemConstant.LOTTO_PRICE;
import static lotto.controller.InputController.request;
import static lotto.view.OutputView.printLottoTicketsInfo;
import static lotto.view.SystemMessage.ASK_MONEY;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Ticket;


public class UnifiedController {
    private final List<Ticket> lottoTickets;

    public UnifiedController() {
        this.lottoTickets = new ArrayList<>();
    }

    public void start() {
        String input = request(ASK_MONEY, DEFAULT_DEPTH);
        int numOfTickets = calcNumOfTickets(input);
        addLottoTickets(numOfTickets);
        printLottoTicketsInfo(new ArrayList<>(this.lottoTickets));
    }

    public int calcNumOfTickets(String input) {
        int money = Integer.parseInt(input);
        return money / LOTTO_PRICE;
    }

    public void addLottoTickets(int numOfTickets) {
        for (int i = 0; i < numOfTickets; i++) {
            this.lottoTickets
                    .add(new Ticket(new Lotto(pickUniqueNumbersInRange(1, 45, 6))));
        }
    }
}
