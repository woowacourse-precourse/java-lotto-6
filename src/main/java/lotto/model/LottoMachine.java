package lotto.model;

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
        int lottoCount = calculateLottoCount(purchaseAmount);
        createAndAddLotto(lottoCount);
    }

    private int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    private void createAndAddLotto(int lottoCount) {
        IntStream.range(0, lottoCount)
                .mapToObj(i -> lottoFactory.createLotto())
                .forEach(lottoTickets::addLotto);
    }

    public LottoTickets getLottoTicketsContainer() {
        return this.lottoTickets;
    }
}
