package lotto.dto.request;

import java.util.List;

public class WinningLottoNumbersDto {
    private final List<Integer> winningLottoNumbers;

    public WinningLottoNumbersDto(List<Integer> winningLottoNumbers) {
        this.winningLottoNumbers = winningLottoNumbers;
    }

    public List<Integer> getWinningLottoNumbers() {
        return winningLottoNumbers;
    }
}
