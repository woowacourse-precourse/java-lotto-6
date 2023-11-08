package lotto.domain;

public interface ViewContract {

    String purchaseAmount();

    void showPurchaseLottoTickets(PurchasedLottoTickets purchasedLottoTickets);

    void showErrorMessage(String message);
}
