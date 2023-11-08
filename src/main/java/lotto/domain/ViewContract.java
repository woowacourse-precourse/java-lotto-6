package lotto.domain;

import java.util.List;

public interface ViewContract {

    String requestPurchaseAmount();

    void showPurchaseLottoTickets(PurchasedLottoTickets purchasedLottoTickets);

    void showErrorMessage(String message);

    List<Integer> requestWinningLottoNumbers();

    int requestBonusNumber();

    void showStatistics(PurchasedLottoStatistics statistics);
}
