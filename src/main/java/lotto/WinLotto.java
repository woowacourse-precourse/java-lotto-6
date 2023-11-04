package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinLotto {

    private List<Integer> numbers;
    private int bonusNumber;
    private final int NUMBERSIZE = 6;
    private final int MAXRANGE = 45;
    private final int MINRANGE = 1;

    public WinLotto(String winNums, String bonusNumber) {

        this.numbers = changeNumbers(winNums);
        this.bonusNumber = Integer.parseInt(bonusNumber);
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

        List<Integer> list = new ArrayList<>();
        for (String str : checkNums) {

            int num = Integer.parseInt(str);

            list.add(num);
            if (list.contains(num)) {

                throw new IllegalArgumentException();
            }
        }
    }
}
