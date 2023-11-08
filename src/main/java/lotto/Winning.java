package lotto;

import static lotto.Constants.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Winning extends InputNumbers {
    private List<Integer> numbers;

    public Winning() {
        numbers = new ArrayList<>();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void save(String readLine) {
        List<Integer> numbers = validate(readLine);
        this.numbers = numbers;
    }

    protected List<Integer> validate(String readLine) {
        String noEmptyReadLine = removeEmpty(readLine);
        checkOtherCharacter(noEmptyReadLine);
        List<Integer> numbers = translateToValueType(noEmptyReadLine);
        checkSize(numbers);
        numbers.forEach(this::checkBoundary);
        checkDuplication(numbers);
        return numbers;
    }

    private void checkOtherCharacter(String noEmptyReadLine) {
        String regex = "^[0-9,]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(noEmptyReadLine);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(WINNING_NUMBER_TYPE_ERROR);
        }
    }
}
