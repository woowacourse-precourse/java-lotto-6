package lotto.domain;

import java.util.List;
import java.util.stream.Stream;

public class LottoTicketDispenser {

    private final LottoNumberGenerateStrategy lottoNumberGenerator;

    public LottoTicketDispenser(LottoNumberGenerateStrategy lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public PurchasedLottoTickets buyAutoCreatedTicket(int cost) {
        validateCost(cost);
        int amountOfTickets = cost / Lotto.PRICE;
        return new PurchasedLottoTickets(createAutoLottoTickets(amountOfTickets));
    }

    private void validateCost(int cost) {
        if (isPayable(cost)) {
            throw new IllegalArgumentException(String.format("로또 구입 금액은 %d 단위입니다.", Lotto.PRICE));
        }
    }

    private boolean isPayable(int cost) {
        return cost % Lotto.PRICE != 0;
    }

    private List<Lotto> createAutoLottoTickets(int amount) {
        return Stream.generate(lottoNumberGenerator::createLotto)
                .limit(amount)
                .map(Lotto::new)
                .toList();
    }

}
