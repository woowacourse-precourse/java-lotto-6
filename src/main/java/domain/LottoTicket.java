package domain;

import java.util.List;

public class LottoTicket {
    private final List<Lotto> lottoNumbers;

    public LottoTicket(List<Lotto> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Lotto> getLottoNumbers() {
        return lottoNumbers;
    }
}