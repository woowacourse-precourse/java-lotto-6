package lotto.model;

import lotto.config.LottoConfig;
import lotto.dto.response.LottoTicketsDto;
import lotto.util.NumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private final NumberGenerator numberGenerator;

    private LottoMachine(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public static LottoMachine of(NumberGenerator numberGenerator) {
        return new LottoMachine(numberGenerator);
    }

    public LottoTicketsDto purchaseLottoTickets(Money money) {
        int ticketCount = getTicketCount(money);
        List<Lotto> lottoTickets = IntStream.range(0, ticketCount)
                .mapToObj(i -> createLottoTicket())
                .collect(Collectors.toList());
        Lottos lottos = Lottos.from(lottoTickets);
        return LottoTicketsDto.from(lottos);
    }

    private Lotto createLottoTicket() {
        return new Lotto(generateLottoNumbers());
    }

    private List<Integer> generateLottoNumbers() {
        return numberGenerator.generate(LottoConfig.START_OF_LOTTO_NUMBER.getValue()
                , LottoConfig.END_OF_LOTTO_NUMBER.getValue()
                , LottoConfig.LOTTO_NUMBER_COUNT.getValue());
    }

    private static int getTicketCount(Money money) {
        return money.getAmount() / LottoConfig.LOTTO_PRICE.getValue();
    }

}
