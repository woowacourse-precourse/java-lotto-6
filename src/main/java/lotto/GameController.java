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
        int ticketCnt = amountToCnt();
        printTicketCnt(ticketCnt);

        lottoList = makeLottoList(ticketCnt);


    }

    public int amountToCnt(){
        lottoAmount = new LottoAmount(InputView.getInputAmount());
        return lottoAmount.amountChangeToLottoCnt();
    }

    private List<Lotto> makeLottoList(int ticketCnt) {
        lottoList = new ArrayList<>();
        for (int i = 0; i < ticketCnt; i++) {
            lottoList.add(makeLotto());
        }
        return lottoList;
    }

    private Lotto makeLotto(){
        LottoNumber lottoNumbers = new LottoNumber();
        lotto = new ArrayList<>();

        lotto = lottoNumbers.setLottoNumbers();
        System.out.println(lotto);
        return new Lotto(lotto);
    }
}
