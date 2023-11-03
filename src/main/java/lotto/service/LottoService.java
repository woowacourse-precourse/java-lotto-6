package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.domain.Rank;
import lotto.domain.WinningLottoTicket;
import lotto.exception.PurchaseValidationException;
import lotto.view.InputView;

import java.util.HashMap;
import java.util.Map;

public class LottoService {

    public int getPurchaseAmount() {
        InputView.promptPurchaseAmount();
        while (true) {
            try {
                return parseAndValidatePurchaseAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int parseAndValidatePurchaseAmount() {
        String purchaseAmountView = InputView.readPurchaseAmount();
        validateIsNumeric(purchaseAmountView);

        int price = Integer.parseInt(purchaseAmountView);
        validatePurchaseAmount(price);

        return price;
    }

    private void validateIsNumeric(String input) {
        PurchaseValidationException.checkIsNumeric(input);
    }

    private void validatePurchaseAmount(int price) {
        PurchaseValidationException.checkValidPurchaseAmount(price);
    }

    public LottoTickets purchaseLottoTicket(int amount) {
        return LottoTickets.buy(amount);
    }

    public Map<Rank, Integer> calculateStatistics(LottoTickets lottoTickets, WinningLottoTicket winningLottoTicket) {
        Map<Rank, Integer> statistics = new HashMap<>();
        for (Rank rank : Rank.values()) {
            statistics.put(rank, 0);
        }

        for (Lotto lotto : lottoTickets.getLottoTickets()) {
            Rank rank = winningLottoTicket.match(lotto);
            statistics.put(rank, statistics.get(rank) + 1);
        }

        return statistics;
    }
}
