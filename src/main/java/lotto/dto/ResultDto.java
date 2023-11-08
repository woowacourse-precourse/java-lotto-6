package lotto.dto;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import lotto.model.LottoResult;
import lotto.model.Ranking;

public record ResultDto(
        List<ResultItemDto> resultItems,
        BigDecimal roi
) {
    public static ResultDto of(LottoResult result) {
        List<ResultItemDto> resultItems = Arrays.stream(Ranking.values())
                .sorted(Comparator.reverseOrder())
                .filter(ranking -> ranking != Ranking.NONE)
                .map(ranking -> new ResultItemDto(ranking, ranking.getNumberOfMatch(), ranking.isBonusMatch(),
                        ranking.getPrizeMoney(), result.getCount(ranking)))
                .toList();
        return new ResultDto(resultItems, result.getRoi());
    }
}
