package lotto.domain.dto;

import java.util.List;

public record LottoDto(List<Integer> numbers) {
    public int matchWinningLottoCount(final WinningLottoDto winningLottoDto) {
        int matchCount = 0;

        for (Integer number : numbers) {
            matchCount += (int) winningLottoDto.numbers().stream().filter(winningNumber -> winningNumber.equals(number))
                    .count();
        }
        
        return matchCount;
    }

    public boolean hasBonusNumber(final BonusNumberDto bonusNumberDto) {
        return numbers.stream().anyMatch(i -> i.equals(bonusNumberDto.number()));
    }
}
