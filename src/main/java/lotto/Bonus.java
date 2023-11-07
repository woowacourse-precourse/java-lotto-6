package lotto;

import java.util.List;

public class Bonus {
    private Integer number;

    public Bonus() {
        this.number = 0;
    }

    public Integer getNumber() {
        return number;
    }

    public void save(String readLine) {
        Integer number = validate(readLine);
        this.number = number;
    }

    public void isContained(List<Integer> winningNumbers) {
        if (winningNumbers.contains(this.number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되어서는 안 됩니다.");
        }
    }

    private Integer validate(String readLine) {
        String noEmptyReadLine = removeEmpty(readLine);
        Integer bonusNumber = translateToNumber(noEmptyReadLine);
        checkBoundary(bonusNumber);
        return bonusNumber;
    }

    private String removeEmpty(String readLine) {
        return readLine.replaceAll("\\s", "");
    }

    private Integer translateToNumber(String readLine) {
        Integer result;
        try {
            result = Integer.parseInt(readLine);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력되어야 합니다.");
        }
        return result;
    }

    private void checkBoundary(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 번호는 1~45 범위 내에 해당해야 합니다.");
        }
    }
}
