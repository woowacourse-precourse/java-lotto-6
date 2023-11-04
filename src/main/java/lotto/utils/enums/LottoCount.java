package lotto.utils.enums;

import java.util.Arrays;

public enum LottoCount {
    THREE("3개 일치", 3, 5000, "5,000원"),
    FOUR("4개 일치", 4, 50000, "50,000원"),
    FIVE("5개 일치", 5, 1500000, "1,500,000원"),
    BONUS("5개 일치, 보너스 볼 일치", Integer.MAX_VALUE,
            30000000, "30,000,000원"),
    SIX("6개 일치", 6, 2000000000, "2,000,000,000원"),
    NONE("3개 미만", Integer.MIN_VALUE, 0, "0원");

    private final String content;
    private final long duplicatedCount;
    private final long price;
    private final String priceCommaFormat;

    LottoCount(String content, long duplicatedCount, long price, String priceCommaFormat) {
        this.content = content;
        this.duplicatedCount = duplicatedCount;
        this.price = price;
        this.priceCommaFormat = priceCommaFormat;
    }

    public static LottoCount findByCount(long count) {
        return Arrays.stream(LottoCount.values())
                .filter(lottoCount -> lottoCount.getDuplicatedCount() == count)
                .findAny()
                .orElse(NONE);
    }

    public String getContent() {
        return content;
    }

    public long getDuplicatedCount() {
        return duplicatedCount;
    }

    public long getPrice() {
        return price;
    }

    public String getPriceCommaFormat() {
        return priceCommaFormat;
    }
}
