package lotto.utils;

import java.util.Arrays;

public enum LottoCount {
    THREE("3개 일치",3, 5000),
    FOUR("4개 일치",4, 50000),
    FIVE("5개 일치",5, 1500000),
    SIX("6개 일치",6, 2000000000),
    BONUS("5개 일치, 보너스 볼 일치", Integer.MAX_VALUE, 30000000),
    NONE("3개 미만", Integer.MIN_VALUE, 0);

    private final String content;
    private final long duplicatedCount;
    private final long price;

    LottoCount(String content, long duplicatedCount, long price) {
        this.content = content;
        this.duplicatedCount = duplicatedCount;
        this.price = price;
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
}
