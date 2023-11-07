package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoGameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final TicketVendingMachine ticketVendingMachine = new TicketVendingMachine();
    private PrizeCalculator prizeCalculator;
    private LottoDrawMachine lottoDrawMachine;

    public LottoGameController() {
        Integer purchaseAmount = purchaseAmount();
        LottoTicket lottoTicket = buyTicket(purchaseAmount);

        setThisWeekLotto();

        prizeResult(lottoTicket, purchaseAmount);
    }

    private Integer purchaseAmount(){
        outputView.getAmount();
        return inputView.purchaseAmount();
    }

    private LottoTicket buyTicket(Integer amount){
        LottoTicket lottoTicket = ticketVendingMachine.buyTicket(amount);
        outputView.ticketResult(lottoTicket.getCount(), lottoTicket.getLottoTickets());
        return lottoTicket;
    }

    private void setThisWeekLotto(){
        Lotto lotto = winningNumbers();
        int bonus = bonusNumber();
        lottoDrawMachine  = new LottoDrawMachine(lotto, bonus);
        prizeCalculator = new PrizeCalculator(lotto, bonus);
    }

    private void prizeResult(LottoTicket lottoTicket, int purchaseAmount){
        LottoResult lottoResult = prizeCalculator.evaluateLotto(lottoTicket, purchaseAmount);
        outputView.prizeResult(lottoResult.getPrizeResults(), lottoResult.getEarnRate());
    }

    private Lotto winningNumbers(){
        outputView.getWinningNumbers();
        List<Integer> lotto = inputView.winningNumbers();
        return new Lotto(lotto);
    }

    private int bonusNumber(){
        outputView.getBonusNumber();
        int bonus = inputView.bonusNumber();
        return bonus;
    }
}
