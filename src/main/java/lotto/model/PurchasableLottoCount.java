package lotto.model;

import java.util.Objects;

public final class PurchasableLottoCount {
    private static final String MINIMUM_COUNT_EXCEPTION_FORMAT = "로또 구입 개수는 %d개 이상 %d개 이하로 구매할 수 있습니다.";
    private static final int MAX_COUNT = 100;
    private static final int MIN_COUNT = 1;

    private final int count;

    private PurchasableLottoCount(int count) {
        validate(count);
        this.count = count;
    }

    private void validate(int count) {
        if (isOutOfRange(count)) {
            String exceptionMessage = String.format(MINIMUM_COUNT_EXCEPTION_FORMAT, MIN_COUNT, MAX_COUNT);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    private static boolean isOutOfRange(int count) {
        return count < MIN_COUNT || count > MAX_COUNT;
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
