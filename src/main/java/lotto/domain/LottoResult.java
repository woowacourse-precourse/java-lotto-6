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
            Prize prize = determinePrizeForLotto(lottoDto, winningNumbersDto);
            recordPrize(prize);
        }
    }

    private Prize determinePrizeForLotto(LottoDto lottoDto, WinningNumbersDto winningNumbersDto) {
        int matchCount = countMatches(lottoDto.getNumbers(), winningNumbersDto.getWinningNumbers());
        boolean hasBonus = lottoDto.getNumbers().contains(winningNumbersDto.getBonusNumber());
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

    public String formatPrizeResults() {
        StringBuilder resultBuilder = new StringBuilder();

        for (Prize prize : Prize.values()) {
            if (prize != Prize.NONE) {
                int count = prizeCount.getOrDefault(prize, 0);
                resultBuilder.append(String.format("%d개 일치 (%s원) - %d개\n",
                        prize.getMatchCount(),
                        formatPrizeMoney(prize.getPrizeMoney()),
                        count));
            }
        }

        return resultBuilder.toString();
    }

    private String formatPrizeMoney(int prizeMoney) {
        return String.format("%,d", prizeMoney); // 숫자를 3자리마다 쉼표를 찍어서 포맷팅
    }

    public Map<Prize, Integer> getPrizeCount() {
        return prizeCount;
    }
}
