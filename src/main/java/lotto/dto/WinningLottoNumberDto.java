package lotto.dto;


import java.util.List;

public class WinningLottoNumberDto {
    private List<Integer> winnerNumbers;
    private int bonusNumber;

    public WinningLottoNumberDto(List<Integer> winnerNumbers, int bonusNumber) {
        this.winnerNumbers = winnerNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinnerNumbers() {
        return winnerNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
