package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.PlayerBuyLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private static PlayerBuyLotto playerBuyLotto;
    private static List<Lotto> lottoTickets;
    private static List<Integer> lotto = new ArrayList<>();

    public LottoController() {
    }

//    public void run() {
//        try {
//            startLotto();
//        }catch (IllegalArgumentException e) {
//            e.printStackTrace();
//        }
//    }

    public void startLotto() {
        InputView.inputPlayerPayMessage();
        int lottoTicketCount = inputPlayerBuyLotto();
        OutputView.printBuyLottoCount(lottoTicketCount);

        lottoTickets = makeLottoList(lottoTicketCount);
    }

    public int inputPlayerBuyLotto() {
        while(true){
            try {
                playerBuyLotto = new PlayerBuyLotto(InputView.inputPlayerPay());
                return playerBuyLotto.calcLottoCount();
            }catch (IllegalArgumentException e){
                System.out.print("");
            }
        }
    }

    private static List<Lotto> makeLottoList(int ticketCount) {
        lottoTickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottoTickets.add(makeLotto());
        }
        return lottoTickets;
    }

    private static Lotto makeLotto() {
        lotto = Lottos.setRandomNumbers();
        System.out.println(lotto);
        return new Lotto(lotto);
    }
}
