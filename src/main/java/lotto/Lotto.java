package lotto;

import java.util.*;

public class Lotto { // 로또 정답을 입력 받고 유효한 지 판별, 해당 번호의 당첨 여부 리스트 return

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.err.println("[ERROR] 로또 번호를 6개 입력해야 합니다.");
            throw new IllegalArgumentException();
        }

        for(int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i) > 45 || numbers.get(i) < 1) {
                System.err.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
        }

        if(checkRedun(numbers)) {
            System.err.println("[ERROR] 당첨 번호는 중복된 숫자가 있으면 안됩니다.");
            throw new IllegalArgumentException();
        }

    }

    protected List<Integer> DetermineRank(List<List<Integer>> numberInfo, int bonus) {
        List<Integer> rankList = new ArrayList<>();

        for(int i = 0; i < numberInfo.size(); i++) {
            rankList.add(grade(numberInfo.get(i), bonus));
        }

        return rankList;
    }

    private int grade(List<Integer> myNumbers, int bonus) { // 로또 번호 1장을 받아서 등수를 return
        int count = 0;

        for(int i = 0; i < myNumbers.size(); i++) {
            if(Collections.frequency(numbers, myNumbers.get(i)) > 0) {
                count++;
            }
        }
        // rank return
        if(count == 6) {
            return 1;
        }
        if(count == 5) {
            if(Collections.frequency(myNumbers, bonus) > 1) {
                return 2; // 2등
            }
            return 3;
        }
        if(count == 4) {
            return 4;
        }
        if(count == 3) {
            return 5;
        }
        return 0;
    }

    private boolean checkRedun(List<Integer> nums) {
        Set<Integer> numSet = new HashSet<>(nums);
        if(numSet.size() != nums.size()) {
            return true;
        }
        return false;
    }
}
