package lotto.domain.dto;

import java.util.List;

public record LottoDto(List<Integer> numbers) {
    public int matchWinningLottoCount(final WinningLottoDto winningLottoDto) {
        return (int) numbers.stream().filter(i -> numbers.contains(winningLottoDto.numbers())).count();
    }

    public boolean hasBonusNumber(final BonusNumberDto bonusNumberDto) {
        return numbers.stream().anyMatch(i -> i.equals(bonusNumberDto.number()));
    }
}
