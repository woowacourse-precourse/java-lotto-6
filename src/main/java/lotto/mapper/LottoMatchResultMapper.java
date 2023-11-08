package lotto.mapper;

import lotto.dto.LottoMatchResultDto;
import lotto.model.WinningCriteria;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoMatchResultMapper {
    public static List<LottoMatchResultDto> mapToDtos(Map<WinningCriteria, Integer> lottoResult) {
        List<LottoMatchResultDto> resultDtos = new ArrayList<>();

        for (WinningCriteria criteria : WinningCriteria.values()) {
            int matchCount = criteria.getMatchCount();
            boolean isBonusMatch = criteria.isBonusMatch();
            int winningAmount = criteria.getWinningAmount();
            int count = lottoResult.getOrDefault(criteria, 0);

            resultDtos.add(new LottoMatchResultDto(matchCount, isBonusMatch, winningAmount, count));
        }
        return resultDtos;
    }
}
