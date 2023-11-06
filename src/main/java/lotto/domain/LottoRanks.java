package lotto.domain;

import static java.util.Collections.unmodifiableMap;
import static java.util.stream.Collectors.toMap;
import static lotto.view.NumberConstant.INCREASE_NUMBER;
import static lotto.view.NumberConstant.LONG_TYPE_ZERO;
import static lotto.view.NumberConstant.START_LOTTO_COUNT;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.constants.WinningGrade;

public class LottoRanks {

    private final Map<WinningGrade, Long> lottoRanks;

    private LottoRanks(List<WinningGrade> winningGrades) {
        Map<WinningGrade, Long> result = generateLottoRanks(winningGrades);
        this.lottoRanks = unmodifiableMap(result);
    }

    public static LottoRanks from(List<WinningGrade> winningGrades) {
        return new LottoRanks(winningGrades);
    }

    public RankingResult generateLottoRanksResult() {
        Map<WinningGrade, Long> result = Arrays.stream(WinningGrade.values())
                .filter(grade -> grade.getMatchingCount() >= START_LOTTO_COUNT)
                .collect(toMap(
                        grade -> grade,
                        grade -> lottoRanks.getOrDefault(grade, LONG_TYPE_ZERO)
                ));

        return RankingResult.from(result);
    }

    private Map<WinningGrade, Long> generateLottoRanks(List<WinningGrade> winningGrades) {
        Map<WinningGrade, Long> result = new EnumMap<>(WinningGrade.class);
        return winningGrades.stream()
                .collect(toMap(
                        grade -> grade,
                        grade -> receiveLottoRank(result, grade) + INCREASE_NUMBER,
                        (existing, replacement) -> existing,
                        () -> new EnumMap<>(WinningGrade.class)
                ));
    }

    private Long receiveLottoRank(Map<WinningGrade, Long> result, WinningGrade winningGrade) {
        return result.getOrDefault(winningGrade, LONG_TYPE_ZERO);
    }
}
