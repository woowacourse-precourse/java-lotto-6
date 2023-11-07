package dto;

import java.util.List;

public class WinningNumberDTO {
    private List<Integer> commonNumbers;
    private int bonusNumber;

    public WinningNumberDTO(List<Integer> commonNumbers, int bonusNumber) {
        this.commonNumbers = commonNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getCommonNumbers() {
        return commonNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
