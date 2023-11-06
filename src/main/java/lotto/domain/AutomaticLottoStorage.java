package lotto.domain;

import java.util.List;

public class AutomaticLottoStorage {

    private List<AutomaticLotto> automaticLottos;
    private LottoStorage lottoStorage;

    public AutomaticLottoStorage(final LottoStorage lottoStorage) {
        this.automaticLottos = AutomaticLotto.from(lottoStorage.getTicketCount());
        this.lottoStorage = lottoStorage;
    }

    public static AutomaticLottoStorage of(final LottoStorage lottoStorage) {
        return new AutomaticLottoStorage(lottoStorage);
    }
}
