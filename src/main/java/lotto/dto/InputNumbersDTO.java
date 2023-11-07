package lotto.dto;

public class InputNumbersDTO {

    private String inputNumbers;

    private String bonusNumber;

    public InputNumbersDTO(String inputNumbers, String bonusNumber) {
        this.inputNumbers = inputNumbers;
        this.bonusNumber = bonusNumber;
    }

    public String getInputNumbers() {
        return inputNumbers;
    }

    public String getBonusNumber() {
        return bonusNumber;
    }

}
