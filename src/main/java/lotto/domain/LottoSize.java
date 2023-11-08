package lotto.domain;

public class LottoSize {
    private final int lottoSize;

    public LottoSize(final int lottoSize) {
        this.lottoSize = lottoSize;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoSize);
    }
}
