package lotto.dto;

public class LottoDrawNumbersEnter {
    private String numbers;
    private String bonusNumber;
    private boolean validInput;

    public LottoDrawNumbersEnter(String numbers, String bonusNumber, boolean validInput) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
        this.validInput = validInput;
    }

    public String getNumbers() {
        return numbers;
    }

    public String getBonusNumber() {
        return bonusNumber;
    }

    public boolean isValidInput() {
        return validInput;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public void setBonusNumber(String bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void setValidInput(boolean validInput) {
        this.validInput = validInput;
    }

}
