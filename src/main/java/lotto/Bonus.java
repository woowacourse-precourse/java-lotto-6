package lotto;

import java.util.List;

public class Bonus extends Input {
    private Integer number;

    public Bonus() {
        this.number = 0;
    }

    public Integer getNumber() {
        return number;
    }

    public void save(String readLine, List<Integer> winningNumbers) {
        Integer number = validate(readLine);
        isContained(winningNumbers);
        this.number = number;
    }

    protected Integer validate(String readLine) {
        String noEmptyReadLine = removeEmpty(readLine);
        Integer bonusNumber = translateToValueType(noEmptyReadLine);
        checkBoundary(bonusNumber);
        return bonusNumber;
    }

    protected String removeEmpty(String readLine) {
        return readLine.replaceAll("\\s", "");
    }

    protected Integer translateToValueType(String noEmptyReadLine) {
        Integer result;
        try {
            result = Integer.parseInt(noEmptyReadLine);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력되어야 합니다.");
        }
        return result;
    }

    private void isContained(List<Integer> winningNumbers) {
        if (winningNumbers.contains(this.number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되어서는 안 됩니다.");
        }
    }
}
