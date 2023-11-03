package lotto.domain.lottoresult;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public enum LottoResult {
    FIRST(6), SECOND(5), THIRD(5), FOURTH(4), FIFTH(3), NONE(0);

    private final int numberOfSame;

    LottoResult(int numberOfSame) {
        this.numberOfSame = numberOfSame;
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
}
