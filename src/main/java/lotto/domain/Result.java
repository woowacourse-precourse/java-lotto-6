package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.dto.LottoResponseDtos.LottoResponseDto;
import lotto.utils.constant.LottoConstant;

public class Result {
    private final Map<Ranking, Integer> result = new EnumMap<>(Ranking.class);

    public Result(List<LottoResponseDto> lottoDtos, WinningNumber winningNumber) {
        putResult(lottoDtos, winningNumber);
    }

    private void putResult(List<LottoResponseDto> lottoDtos, WinningNumber winningNumber) {
        List<Ranking> rankings = calculateRankings(lottoDtos, winningNumber);
        for (Ranking ranking : rankings) {
            result.put(ranking, result.getOrDefault(ranking, 0) + 1);
        }
    }

    public List<Ranking> calculateRankings(List<LottoResponseDto> lottoDtos, WinningNumber winningNumber) {
        return lottoDtos.stream()
            .map(l -> findRanking(l.getLottoNumbers(), winningNumber))
            .collect(Collectors.toList());
    }

    public Ranking findRanking(List<Integer> lotto, WinningNumber winningNumber) {
        int count = winningNumber.countWinningNumber(lotto);
        boolean checkBonus = winningNumber.checkBonusNumber(lotto);
        return Ranking.findRanking(count, checkBonus);
    }

    public int calculateTotalPrize() {
        return result.entrySet().stream()
            .mapToInt(e -> e.getKey().multiply(e.getValue()))
            .sum();
    }
}
