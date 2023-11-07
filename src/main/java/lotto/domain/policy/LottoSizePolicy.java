package lotto.domain.policy;

public enum LottoSizePolicy {
    LOTTO_SIZE(6);

    int size;

    LottoSizePolicy(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
