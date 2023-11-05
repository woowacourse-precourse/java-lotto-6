package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoIssuer {

    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoIssuer(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public LottoTickets issue(final Integer numberOfTickets) {
        List<Lotto> issuedLottos = new ArrayList<>();
        for (int issueCount = 0; issueCount < numberOfTickets; issueCount++) {
            issuedLottos.add(new Lotto(lottoNumberGenerator.create()));
        }
        return new LottoTickets(issuedLottos);
    }
}
