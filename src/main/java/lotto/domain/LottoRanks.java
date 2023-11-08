package lotto.domain;

import static java.util.stream.Collectors.toMap;
import static lotto.constants.NumberConstant.LONG_TYPE_ONE;
import static lotto.constants.NumberConstant.LONG_TYPE_ZERO;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.enums.WinningGrade;

public class LottoRanks {

    private final Map<WinningGrade, Long> lottoRanks;

    private LottoRanks(final List<WinningGrade> winningGrades) {
        this.lottoRanks = generateLottoRanks(winningGrades);
    }

    public static LottoRanks from(final List<WinningGrade> winningGrades) {
        return new LottoRanks(winningGrades);
    }

    public RankingResult receiveRankingResult() {
        final Map<WinningGrade, Long> result = Arrays.stream(WinningGrade.values())
                .filter(WinningGrade::isGreaterThanStartLottoCount)
                .collect(toMap(
                        grade -> grade,
                        grade -> lottoRanks.getOrDefault(grade, LONG_TYPE_ZERO)));

        return RankingResult.from(result);
    }

    private Map<WinningGrade, Long> generateLottoRanks(final List<WinningGrade> winningGrades) {
        return winningGrades.stream()
                .collect(toMap(
                        grade -> grade,
                        grade -> LONG_TYPE_ONE,
                        (existing, replacement) -> existing,
                        () -> new EnumMap<>(WinningGrade.class)));
    }
}
