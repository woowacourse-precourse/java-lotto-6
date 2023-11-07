package dto;

import java.util.List;

public class WinningNumberDTO {
    private List<Integer> commonNumbers;
    private Integer bonusNumber;

    public WinningNumberDTO(CommonNumberDTO commonNumbers, BonusNumberDTO bonusNumber) {
        this.commonNumbers = commonNumbers.getNumbers();
        this.bonusNumber = bonusNumber.getNumber();
    }

    public List<Integer> getCommonNumbers() {
        return commonNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
