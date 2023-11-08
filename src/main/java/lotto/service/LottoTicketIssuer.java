package lotto.service;

import lotto.model.Lotto;
import lotto.model.LottoTicket;
import lotto.utils.LottoNumberGenerator;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketIssuer {
    public static LottoTicket issue(Integer amount) {
        return new LottoTicket(
                IntStream.range(0, amount)
                        .mapToObj(i -> issueSingleLotto())
                        .collect(Collectors.toList())
        );
    }

    private static Lotto issueSingleLotto() {
        return new Lotto(LottoNumberGenerator.pickLottoNumbers());
    }
}
