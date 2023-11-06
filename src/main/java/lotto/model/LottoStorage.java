package lotto.model;

import java.util.List;

public class LottoStorage {
    private final List<Lotto> lottoStorage;

    private LottoStorage(List<Lotto> lottoStorage) {
        this.lottoStorage = lottoStorage;
    }

    public static LottoStorage from(List<Lotto> lottoStorage) {
        return new LottoStorage(lottoStorage);
    }

    public List<Lotto> getLottoStorage() {
        return List.copyOf(lottoStorage);
    }

}
