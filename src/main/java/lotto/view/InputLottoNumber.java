package lotto.view;


import lotto.exception.BlankException;
import lotto.exception.DuplicatedNumberException;
import lotto.exception.NoSixNumberException;
import lotto.exception.NotNumberException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.domain.Constant.LOTTO_NUMBER_COUNT;

public class InputLottoNumber {
    private static final String LOTTO_CHOICE_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final InputThings inputThings = new InputThings();

    public void printNotice() {
        System.out.println(LOTTO_CHOICE_MESSAGE);
    }

    public List<Integer> getValue() {
        printNotice();
        String checkedInput = inputThings.inputThings().trim();
        String getValues = String.join(",", checkedInput);
        validate(checkedInput);
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String lottoNumber : getValues.split(",")) {
            int number = Integer.parseInt(lottoNumber.trim());
            lottoNumbers.add(number);
        }
        validateDuplication(lottoNumbers);
        validateCountOfNumbers(lottoNumbers);
        return lottoNumbers;
    }

    public void validate(String checkedInput) {
        blankInput(checkedInput);
        validateInputIsNumberFormat(checkedInput);

    }

    private void blankInput(String checkedInput) {
        if (checkedInput == null) {
            throw new BlankException();
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        final Set<Integer> checkedNumberValues = new HashSet<>();
        for (Integer number : numbers) {
            checkDuplication(checkedNumberValues, number.toString());
            checkedNumberValues.add(number);
        }
    }

    private void checkDuplication(Set<Integer> checkedNumbers, String checkingNumber) {
        Integer checkNumber = Integer.parseInt(checkingNumber);
        if (checkedNumbers.contains(checkNumber)) {
            throw new DuplicatedNumberException();
        }
    }

    private void validateCountOfNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new NoSixNumberException();
        }
    }

    public void validateInputIsNumberFormat(String checkedInput) {
        String uncheckedNumbers = String.join("", checkedInput.split(","));
        boolean isNumber = isNumberString(uncheckedNumbers);
        if(!isNumber) {
            throw new NotNumberException();
        }
    }

    public boolean isNumberString(String checkedInput) {
        if(checkedInput.isBlank()) {
            return false;
        }
        for (int i = 0; i < checkedInput.length(); i++) {
            char uncheckedCharacter = checkedInput.charAt(i);
            if(!Character.isDigit(uncheckedCharacter)) {
                return false;
            }
        }
        return true;
    }
}