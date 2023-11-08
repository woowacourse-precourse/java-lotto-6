package lotto.domain;

import java.util.List;
import java.util.stream.Stream;

public class LottoTicketDispenser implements TicketDispenser<Lotto> {

    private final NumberGenerateStrategy lottoNumberGenerator;

    public LottoTicketDispenser(NumberGenerateStrategy lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    @Override
    public List<Lotto> buyAutoCreatedTicket(int cost) {
        validateCost(cost);
        int amountOfTickets = cost / Lotto.PRICE;
        return createAutoLottoTickets(amountOfTickets);
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
        return Stream.generate(lottoNumberGenerator::createNumber)
                .limit(amount)
                .map(Lotto::new)
                .toList();
    }

    @Override
    public Lotto createWinningTicket(NumberGenerateStrategy strategy) {
        return new Lotto(strategy.createNumber());
    }
}
