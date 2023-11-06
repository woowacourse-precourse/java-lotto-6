package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinLotto {

    private List<Integer> numbers;
    private int bonusNumber;
    private final int NUMBERSIZE = 6;
    private final int MAXRANGE = 45;
    private final int MINRANGE = 1;

    public WinLotto(String winNums, String bonusNumber) {

        this.numbers = changeNumbers(winNums);
        this.bonusNumber = validateBonusNum(bonusNumber);
    }

    private List<Integer> changeNumbers(String winNums) {

        List<Integer> checkNums = new ArrayList<>();
        String[] checkInput = winNums.split(",");
        validate(checkInput);
        for (int i = 0; i < checkInput.length; i++) {

            checkNums.add(Integer.parseInt(checkInput[i]));
        }

        return checkNums;
    }

    private void validate(String[] checkNums) {

        validateSize(checkNums);
        validateNum(checkNums);
        validateRange(checkNums);
        validateDuplicate(checkNums);
    }

    private void validateSize(String[] checkNums) {

        if (checkNums.length != NUMBERSIZE) {

            throw new IllegalArgumentException();
        }
    }

    private void validateNum(String[] checkNums) {

        try {

            for (String str : checkNums) {

                Integer.parseInt(str);
            }
        } catch (NumberFormatException e) {

            throw new IllegalArgumentException();
        }
    }

    private void validateRange(String[] checkNums) {

        for (String str : checkNums) {

            int num = Integer.parseInt(str);

            if (num < MINRANGE || num > MAXRANGE) {

                throw new IllegalArgumentException();
            }
        }
    }

    private void validateDuplicate(String[] checkNums) {

        Set<Integer> set = new HashSet<>();
        for (String str : checkNums) {

            int num = Integer.parseInt(str);
            if (!set.add(num)) {

                throw new IllegalArgumentException();
            }
        }
    }

    private int validateBonusNum(String bonusNumber) {

        try {

            int num = Integer.parseInt(bonusNumber);
            validateBonusNumDuplicate(num);
            return num;
        } catch (NumberFormatException e) {

            throw new IllegalArgumentException();
        }
    }

    private void validateBonusNumDuplicate(int bonusNumber) {

        if (numbers.contains(bonusNumber)) {

            throw new IllegalArgumentException();
        }
    }

    public int compareLotto(Lotto lotto) {

        int compareResult = 0;
        for (int num : numbers) {

            if (lotto.compareNum(num)) {

                compareResult++;
            }
        }

        return compareResult;
    }

    public int compareBonusLotto(Lotto lotto) {

        int compareBonusNum = 0;

        if (lotto.compareBonusNum(bonusNumber)) {

            compareBonusNum++;
        }

        return compareBonusNum;
    }
}
