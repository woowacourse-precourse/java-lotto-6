package lotto.domain;

//todo: 필요한가?
public class LottoSize {
    private final int lottoSize;

    public LottoSize(int lottoSize) {
        this.lottoSize = lottoSize;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoSize);
    }
}
