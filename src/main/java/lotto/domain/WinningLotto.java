package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    private final Lotto winning;

    private int bonus;

    public WinningLotto(List<Integer> numbers,String bonus) {
        this.winning = new Lotto(numbers);
        int numberBonus = validateBonus(bonus);
        validateDuplicateBonus(numberBonus);
        validateRangeBonus(numberBonus);
        this.bonus = numberBonus;
    }



    public Lotto getWinning() {
        return this.winning;
    }

    public int getBonus() {
        return this.bonus;
    }

    private void validateRangeBonus(int bonus) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("수의 범위는 1 ~ 45 입니다.");
        }
    }

    private void validateDuplicateBonus(int bonus) {
        if (this.winning.find(bonus)) {
            throw new IllegalArgumentException("중복된 수를 입력하셨습니다.");
        }
    }

    private int validateBonus(String number) {
        try {
            int intNumber = Integer.parseInt(number);
            return intNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력하세요");
        }

    }

    private void validateDuplicate(List<Integer> splitNumber) {
        if (splitNumber.size() != splitNumber.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 수를 입력하면 안됩니다.");
        }

    }

    private void validateRange(List<Integer> splitNumber) {
        for (Integer now : splitNumber) {
            if (now < 1 || now > 45) {
                throw new IllegalArgumentException("수의 범위는 1 ~ 45 입니다.");
            }
        }
    }

    private void toList(String[] split, List<Integer> splitNumber) {
        for (String now : split) {
            try {
                Integer nowNumber = Integer.parseInt(now);
                splitNumber.add(nowNumber);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("정수를 입력하세요");
            }
        }
    }

    private void validateSize(List<Integer> inputNumbers) {
        if (inputNumbers.size() != 6) {
            throw new IllegalArgumentException("6개의 수를 입력해주세요");
        }


    }



}
