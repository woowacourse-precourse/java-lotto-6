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

    private Integer purchaseAmount() {
        outputView.getAmount();
        while (true) {
            try {
                return inputView.purchaseAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private LottoTicket buyTicket(Integer amount) {
        while (true) {
            try {
                LottoTicket lottoTicket = ticketVendingMachine.buyTicket(amount);
                outputView.ticketResult(lottoTicket.getCount(), lottoTicket.getLottoTickets());
                return lottoTicket;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                amount = purchaseAmount();
            }
        }
    }

    private void setThisWeekLotto() {
        Lotto lotto = getWinningNumbers();
        int bonus = getBonusNumber();
        lottoDrawMachine = setDrawMachine(lotto, bonus);
        prizeCalculator = new PrizeCalculator(lotto, bonus);
    }

    private Lotto getWinningNumbers() {
        while (true) {
            try {
                return winningNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getBonusNumber() {
        while (true) {
            try {
                return bonusNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private LottoDrawMachine setDrawMachine(Lotto lotto, int bonus) {
        while (true) {
            try {
                return new LottoDrawMachine(lotto, bonus);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                bonus = getBonusNumber();
            }
        }
    }

    private void prizeResult(LottoTicket lottoTicket, int purchaseAmount) {
        LottoResult lottoResult = prizeCalculator.calculateLottoResult(lottoTicket, purchaseAmount);
        outputView.prizeResult(lottoResult.getPrizeResults(), lottoResult.getEarnRate());
    }

    private Lotto winningNumbers() {
        while (true) {
            try {
                outputView.getWinningNumbers();
                List<Integer> lotto = inputView.winningNumbers();
                return new Lotto(lotto);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int bonusNumber() {
        while (true) {
            try {
                outputView.getBonusNumber();
                int bonus = inputView.bonusNumber();
                return bonus;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
