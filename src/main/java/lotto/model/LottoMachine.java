package lotto.model;

import static lotto.exception.ExceptionMessage.INVALID_PURCHASE_AMOUNT;

import java.util.stream.IntStream;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;

    private final LottoFactory lottoFactory;

    private final LottoTickets lottoTickets;

    public LottoMachine(LottoFactory lottoFactory, LottoTickets lottoTickets) {
        this.lottoFactory = lottoFactory;
        this.lottoTickets = lottoTickets;
    }

    public void purchaseLottoTickets(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        int lottoCount = calculateLottoCount(purchaseAmount);
        createAndAddLotto(lottoCount);
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0 || purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException (INVALID_PURCHASE_AMOUNT.getErrorMessage());
        }
    }

    private int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    private void createAndAddLotto(int lottoCount) {
        IntStream.range(0, lottoCount)
                .mapToObj(i -> lottoFactory.createLotto())
                .forEach(lottoTickets::addLotto);
    }

    public LottoTickets getLottoTickets() {
        return this.lottoTickets;
    }
}
