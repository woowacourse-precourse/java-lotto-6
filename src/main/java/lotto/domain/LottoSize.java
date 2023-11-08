package lotto.domain;

//todo: 필요한가?
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
