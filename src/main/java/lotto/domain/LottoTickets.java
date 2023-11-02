package lotto.domain;

import static lotto.exception.ExceptionMessage.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.exception.LottoException;
import lotto.util.Parser;

public class LottoTickets {
    private final LottoNumberGenerator lottoNumberGenerator = LottoNumberGenerator.INSTANCE;
    private final int purchaseMoney;
    private List<Lotto> lottos;

    private LottoTickets(int purchaseMoney) {
        this.purchaseMoney = purchaseMoney;
    };

    public static LottoTickets purchase(String inputMoney) {
        return new LottoTickets(Parser.StringParseInt(inputMoney));
    }

    public int getLottoTicketQuantity() {
        int ticketQuantity = moneyToTicket();
        generateLottoTicket(ticketQuantity);
        return lottos.size();
    }

    public List<String> getLottoNumbers() {
        return lottos.stream()
                .map(Lotto::getLottoNumber)
                .collect(Collectors.toList());
    }

    private int moneyToTicket() {
        // TODO: 매직넘버 상수화하기
        if (purchaseMoney % 1_000 > 0) {
            throw new LottoException(INDIVISIBLE);
        }
        return purchaseMoney / 1_000;
    }

    private void generateLottoTicket(int ticketQuantity) {
        lottos = IntStream.range(0, ticketQuantity)
                .mapToObj(lotto -> new Lotto(lottoNumberGenerator.generateLottoNumbers()))
                .collect(Collectors.toList());
    }
}
