package lotto;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoAmount;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.rank.Rank;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.view.OutputView.printTicketCnt;

public class GameController {

    private static final int TICKET_PRICE = 1000;
    private static final int PERCENTAGE = 100;

    private static LottoAmount lottoAmount;
    private static List<Integer> lotto = new ArrayList<>();
    private static List<Lotto> lottoList;
    private static WinningLotto winningResult;

    public GameController() {
    }

    public void start() {
        int ticketCnt = moneyToCnt();
        printTicketCnt(ticketCnt);

    }

    public int moneyToCnt(){
        lottoAmount = new LottoAmount(InputView.getInputAmount());
        return lottoAmount.amountChangeToLottoCnt();
    }
}
