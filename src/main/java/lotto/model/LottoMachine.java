package lotto.model;

import lotto.config.LottoConfig;
import lotto.dto.response.LottoTicketsDto;
import lotto.util.NumberGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private final NumberGenerator numberGenerator;
    private final Money money;

    private LottoMachine(NumberGenerator numberGenerator, Money money) {
        this.numberGenerator = numberGenerator;
        this.money = money;
    }

    public static LottoMachine of(NumberGenerator numberGenerator, Money money) {
        return new LottoMachine(numberGenerator, money);
    }

    public LottoTicketsDto createLottoTickets() {
        int ticketCount = getTicketCount(money);
        List<Lotto> lottoTickets = IntStream.range(0, ticketCount)
                .mapToObj(i -> createLottoTicket())
                .collect(Collectors.toList());
        Lottos lottos = Lottos.from(lottoTickets);
        return LottoTicketsDto.of(lottos, money);
    }

    private Lotto createLottoTicket() {
        return new Lotto(generateLottoNumbers());
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> numbers = numberGenerator.generate(
                LottoConfig.START_OF_LOTTO_NUMBER.getValue(),
                LottoConfig.END_OF_LOTTO_NUMBER.getValue(),
                LottoConfig.LOTTO_NUMBER_COUNT.getValue()
        );
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private static int getTicketCount(Money money) {
        return money.getAmount() / LottoConfig.LOTTO_PRICE.getValue();
    }

}
