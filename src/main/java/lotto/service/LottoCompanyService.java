package lotto.service;

import lotto.model.Lotto;
import lotto.model.LottoCompany;
import java.util.List;

public class LottoCompanyService {

    private final LottoCompany lottoCompany;
    private final List<Lotto> lottos;

    private LottoCompanyService(final LottoCompany lottoCompany, final List<Lotto> lottos) {
        this.lottoCompany = lottoCompany;
        this.lottos = lottos;
    }

    public static LottoCompanyService of(final LottoCompany lottoCompany, final List<Lotto> lottos) {
        return new LottoCompanyService(lottoCompany, lottos);
    }
}
