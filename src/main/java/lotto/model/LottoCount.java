package lotto.model;

import java.util.Objects;

public final class LottoCount {
    private static final String MINIMUM_COUNT_EXCEPTION_FORMAT = "로또 구입 개수는 %d개 이상이어야 합니다.";
    private static final int MINIMUM_COUNT = 1;

    private final int count;

    LottoCount(int count) {
        validate(count);
        this.count = count;
    }

    private void validate(int count) {
        if (count < MINIMUM_COUNT) {
            String formattedExceptionMessage = String.format(MINIMUM_COUNT_EXCEPTION_FORMAT, MINIMUM_COUNT);
            throw new IllegalArgumentException(formattedExceptionMessage);
        }
    }

    public static LottoCount from(InvestMoney investMoney) {
        int purchaseLottoCount = LottoPrice.STANDARD_PRICE.calculateLottoCount(investMoney);
        return new LottoCount(purchaseLottoCount);
    }

    public int calculateUserMoney() {
        return LottoPrice.STANDARD_PRICE.multiply(count);
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
        LottoCount that = (LottoCount) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
