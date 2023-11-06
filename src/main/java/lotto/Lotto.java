package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        String ErrorCode = "[ERROR] 로또 번호는 중복되지 않는 6개 번호 입니다. 프로그렘을 종료합니다.";
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorCode);
        }
        for (Integer integer : numbers) {
            int count = 0;
            for (Integer integer2 : numbers) {
                if (integer == integer2)
                    count++;
            }
            if (count == 2)
                throw new IllegalArgumentException(ErrorCode);
        }
    }

    // TODO: 추가 기능 구현
    public boolean lottoContains(int a) {
        for (Integer integer : numbers) {
            if (a == integer)
                return true;
        }

        return false;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countMatch(List<Integer> user) {
        int count = 0;
        int[] tmp = new int[46];

        for (Integer integer : user) {
            tmp[integer] = 1;
        }

        for (int i : numbers) {
            count += tmp[i];
        }

        return count;
    }
}
