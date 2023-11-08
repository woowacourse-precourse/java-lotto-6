package lotto.domain.handler.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.event.LottoMessageBroker;
import lotto.domain.event.input.Lotto;
import lotto.domain.event.input.MoneyInputRequested;
import lotto.domain.event.output.TicketsCreated;
import lotto.util.LottoNumberConstants;

public class LottoNumberGeneratorHandler implements RandomGenerator<Lotto> {

    private final LottoMessageBroker lottoMessageBroker;

    public LottoNumberGeneratorHandler(LottoMessageBroker lottoMessageBroker) {
        this.lottoMessageBroker = lottoMessageBroker;
    }

    @Override
    public Lotto generate() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(LottoNumberConstants.MIN_LOTTO_NUMBER.getValue(),
                LottoNumberConstants.MAX_LOTTO_NUMBER.getValue(),
                LottoNumberConstants.NUMBER_OF_LOTTO_NUMBERS.getValue()));
    }


    public void generateLottoTickets(MoneyInputRequested moneyInputRequested) {
        lottoMessageBroker.enqueue(generatelottoTicket(moneyInputRequested.money() / 1000));
    }

    private TicketsCreated generatelottoTicket(int numberOfLottoTickets) {
        TicketsCreated tickets = IntStream.range(LottoNumberConstants.NO_REMAINDER.getValue(), numberOfLottoTickets)
                .mapToObj(i -> generate())
                .collect(Collectors.collectingAndThen(Collectors.toList(), TicketsCreated::new));
        ;
        return tickets;
    }


}
