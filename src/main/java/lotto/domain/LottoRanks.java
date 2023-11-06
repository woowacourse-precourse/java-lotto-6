package lotto.domain;

import static java.util.Collections.unmodifiableMap;
import static java.util.stream.Collectors.toMap;
import static lotto.domain.constants.NumberConstant.INCREASE_NUMBER;
import static lotto.domain.constants.NumberConstant.LONG_TYPE_ZERO;
import static lotto.domain.constants.NumberConstant.START_LOTTO_COUNT;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.enums.WinningGrade;

public class LottoRanks {

    private final Map<WinningGrade, Long> lottoRanks;

    private LottoRanks(final List<WinningGrade> winningGrades) {
        final Map<WinningGrade, Long> result = generateLottoRanks(winningGrades);
        this.lottoRanks = unmodifiableMap(result);
    }

    public static LottoRanks from(final List<WinningGrade> winningGrades) {
        return new LottoRanks(winningGrades);
    }

    public RankingResult generateLottoRanksResult() {
        final Map<WinningGrade, Long> result = Arrays.stream(WinningGrade.values())
                .filter(grade -> grade.getMatchingCount() >= START_LOTTO_COUNT)
                .collect(toMap(
                        grade -> grade,
                        grade -> lottoRanks.getOrDefault(grade, LONG_TYPE_ZERO)
                ));

        return RankingResult.from(result);
    }

    private Map<WinningGrade, Long> generateLottoRanks(final List<WinningGrade> winningGrades) {
        final Map<WinningGrade, Long> result = new EnumMap<>(WinningGrade.class);

        return winningGrades.stream()
                .collect(toMap(
                        grade -> grade,
                        grade -> receiveLottoRank(result, grade) + INCREASE_NUMBER,
                        (existing, replacement) -> existing,
                        () -> new EnumMap<>(WinningGrade.class)
                ));
    }

    private Long receiveLottoRank(final Map<WinningGrade, Long> result, final WinningGrade winningGrade) {
        return result.getOrDefault(winningGrade, LONG_TYPE_ZERO);
    }
}
