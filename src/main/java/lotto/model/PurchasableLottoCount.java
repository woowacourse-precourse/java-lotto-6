package lotto.model;

import java.util.Objects;

public final class PurchasableLottoCount {
    private static final String MINIMUM_COUNT_EXCEPTION_FORMAT = "로또 구입 개수는 %d개 이상이어야 합니다.";
    private static final int MINIMUM_COUNT = 1;

    private final int count;

    PurchasableLottoCount(int count) {
        validate(count);
        this.count = count;
    }

    private void validate(int count) {
        if (count < MINIMUM_COUNT) {
            String exceptionMessage = String.format(MINIMUM_COUNT_EXCEPTION_FORMAT, MINIMUM_COUNT);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    public static PurchasableLottoCount from(int lottoCount) {
        return new PurchasableLottoCount(lottoCount);
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PurchasableLottoCount that = (PurchasableLottoCount) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
