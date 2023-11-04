package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoIssuer {

    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoIssuer(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<Lotto> issue(final Integer numberOfTickets) {
        List<Lotto> issuedLotto = new ArrayList<>();
        for (int issueCount = 0; issueCount < numberOfTickets; issueCount++) {
            issuedLotto.add(new Lotto(lottoNumberGenerator.create()));
        }
        return issuedLotto;
    }
}
