package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Winning {
    private List<Integer> numbers;
    private Integer bonusNumber;

    public Winning() {
        numbers = new ArrayList<>();
        bonusNumber = 0;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public void saveNumbers(String readLine) {
        validateSaveNumbers(readLine);
        String[] split = readLine.split(",");
        List<Integer> numbers = Arrays.stream(split)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        this.numbers = this.numbers;
    }

    private void validateSaveNumbers(String readLine) {
        String noEmptyReadLine = removeEmpty(readLine);

    }

    private String removeEmpty(String readLine) {
        return readLine.replaceAll("\\s", "");
    }

    public void saveBonusNumber(String readLine) {
        validateBonusNumber(readLine);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(String readLine) {
        String noEmptyReadLine = removeEmpty(readLine);
        Integer bonusNumber = translateToNumber(noEmptyReadLine);
        checkBoundary(bonusNumber);
        checkDuplication(bonusNumber);
    }

    private Integer translateToNumber(String readLine) {
        Integer result = 0;
        try {
            result = Integer.parseInt(readLine);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return result;
    }

    private void checkBoundary(Integer bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplication(Integer bonusNumber) {
        if (this.numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
