package lotto.domain;

import static lotto.contents.ContentNumbers.ZERO;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.dto.LottoDto;
import lotto.dto.WinningNumbersDto;

public class LottoResult {
    private final Map<Prize, Integer> prizeCount;

    public LottoResult() {
        prizeCount = new EnumMap<>(Prize.class);
        initializePrizeCount();
    }

    private void initializePrizeCount() {
        for (Prize prize : Prize.values()) {
            prizeCount.put(prize, ZERO.getNumber());
        }
    }

    public void calculateResults(List<LottoDto> lottoDtos, WinningNumbersDto winningNumbersDto) {
        for (LottoDto lottoDto : lottoDtos) {
            Prize prize = calculatePrize(lottoDto, winningNumbersDto);
            recordPrize(prize);
        }
    }

    private Prize calculatePrize(LottoDto lottoDto, WinningNumbersDto winningNumbersDto) {
        int matchCount = countMatches(lottoDto.numbers(), winningNumbersDto.winningNumbers());
        boolean hasBonus = lottoDto.numbers().contains(winningNumbersDto.bonusNumber());
        return Prize.valueOf(matchCount, hasBonus);
    }

    private void recordPrize(Prize prize) {
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
}
