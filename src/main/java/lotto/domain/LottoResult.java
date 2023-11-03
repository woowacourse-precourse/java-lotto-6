package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.dto.LottoDto;
import lotto.dto.WinningNumbersDto;

public class LottoResult {
    private final Map<Prize, Integer> prizeCount;

    public LottoResult() {
        prizeCount = new EnumMap<>(Prize.class);
        for (Prize prize : Prize.values()) {
            prizeCount.put(prize, 0);
        }
    }

    public void calculateResults(List<LottoDto> lottoDtos, WinningNumbersDto winningNumbersDto) {
        for (LottoDto lottoDto : lottoDtos) {
            Prize prize = determinePrizeForLotto(lottoDto, winningNumbersDto);
            recordPrize(prize);
        }
    }

    private Prize determinePrizeForLotto(LottoDto lottoDto, WinningNumbersDto winningNumbersDto) {
        int matchCount = countMatches(lottoDto.getNumbers(), winningNumbersDto.getWinningNumbers());
        boolean hasBonus = lottoDto.getNumbers().contains(winningNumbersDto.getBonusNumber());
        return Prize.valueOf(matchCount, hasBonus);
    }

    //
    public void recordPrize(Prize prize) {
        prizeCount.merge(prize, 1, Integer::sum);
    }

    private int countMatches(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public Map<Prize, Integer> getPrizeCount() {
        return prizeCount;
    }

    // 추가적으로 당첨 통계를 출력하는 메소드 등을 구현할 수 있습니다.
}
