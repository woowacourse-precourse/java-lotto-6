package lotto.domain.lottoresult;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public enum LottoResult {
    FIFTH(3,5000),
    FOURTH(4,50000),
    THIRD(5,1500000),
    SECOND(5, 30000000),
    FIRST(6,2000000000),
    NONE(0,0);

    private static final List<LottoResult> lottoResults = getLottoResultsWihoutNone();

    private final int numberOfSame;
    private final long prizeMoney;

    LottoResult(int numberOfSame, long prizeMoney) {
        this.numberOfSame = numberOfSame;
        this.prizeMoney = prizeMoney;
    }

    private static List<LottoResult> getLottoResultsWihoutNone() {
        return Arrays.stream(values())
                .filter(lottoResult -> !lottoResult.isNone()).toList();
    }

    public static LottoResult getResult(int numberOfSame, boolean matchWithBonusNumber) {
        if (matchWithBonusNumber) {
            return checkResultWithoutOneExcept(numberOfSame, THIRD);
        }
        return checkResultWithoutOneExcept(numberOfSame, SECOND);
    }

    private static LottoResult checkResultWithoutOneExcept(int numberOfSame, LottoResult exceptLottoResult) {
        return Arrays.stream(values())
                .filter(lottoResult -> lottoResult != exceptLottoResult)
                .filter(checkSameNumberOfSame(numberOfSame))
                .findAny()
                .orElse(NONE);
    }

    private static Predicate<LottoResult> checkSameNumberOfSame(int numberOfSame) {
        return lottoResult -> lottoResult.numberOfSame == numberOfSame;
    }

    public static Map<LottoResult, Integer> getInitialLottoResultsRepository() {
        Map<LottoResult, Integer> initialLottoResultsRepository = new HashMap<>();
        for (LottoResult value : values()) {
            initialLottoResultsRepository.put(value, 0);
        }
        return initialLottoResultsRepository;
    }

    public static int getSizeOfLottoResult() {
        return lottoResults.size();
    }

    public static LottoResult getSomeLottoResult(int index) {
        return lottoResults.get(index);
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public int getNumberOfSame() {
        return numberOfSame;
    }

    public boolean isNone() {
        return this == NONE;
    }

    public boolean isSecond() {
        return this == SECOND;
    }
}
