package lotto.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LottoValidator {
    private static final int SIZE = 6;
    private static final int MIN = 1;
    private static final int MAX = 45;

    public void lottoNumbers(List<String> splittedNumbers) {
        checkSize(splittedNumbers);
        for (String number : splittedNumbers) {
            checkNum(number);
        }
        checkDuplicate(splittedNumbers);
    }

    public void bonusNumber(String bonus, List<String> splittedNumbers) {
        checkNum(bonus);
        checkDuplicateBonus(bonus, splittedNumbers);
    }

    private void checkSize(List<String> splittedNumbers) {
        if (splittedNumbers.size() != SIZE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE.getMessage());
        }
    }
    
    private void checkNum(String number) {
        checkInteger(number);
        int realNumber = Integer.valueOf(number);
        if (realNumber < MIN || realNumber > MAX) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_RANGE.getMessage());
        }

    }

    private void checkInteger(String number) {
        try {
            Integer.valueOf(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INTEGER.getMessage());
        }
    }

    private void checkDuplicate(List<String> splittedNumbers) {
        HashSet<String> nonDuplicate = new HashSet<>(splittedNumbers);
        if (nonDuplicate.size() != splittedNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATE.getMessage());
        }
    }

    private void checkDuplicateBonus(String bonus, List<String> splittedNumbers) {
        List<String> sum = new ArrayList<>(splittedNumbers);
        sum.add(bonus);
        checkDuplicate(sum);
    }
}
