package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }


    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(" 값을 6개 입력해야 합니다.");
        }
        Set<Integer> validNums = new HashSet<>();
        for (Integer number : numbers) {
            if (validNums.contains(number) || number<1 || number>45) {
                throw new IllegalArgumentException(" 잘못된 값이 입력되었습니다.");
            }
            validNums.add(number);
        }
    }
    public void checkBonusNum(int bonusNum) {
        for (Integer number : numbers) {
            if (number == bonusNum) {
                throw new IllegalArgumentException("당첨 번호와 중복되는 값입니다.");
            }
        }
    }



    public int checkSameNum(List<Integer> userNum, int bonusNum) {
        HashSet<Integer> set = new HashSet<>(userNum);
        int cnt =0;
        for (Integer number : numbers) {
            if (set.contains(number)) {
                cnt ++;
            }
        }
        if (cnt == 5) {
            if(set.contains(bonusNum)) cnt+=2;
        }
        return cnt;
    }

}
