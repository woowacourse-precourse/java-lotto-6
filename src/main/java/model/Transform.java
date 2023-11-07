package model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Transform {
    public List<Integer> winningNumberToList(String input) {
        String[] parts = input.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String part : parts) {
            int number = Integer.parseInt(part);
            numbers.add(number);
        }
        return numbers;
    }

    public List<Integer> generateRandomList() {
        List<Integer> randomList;

        while (true) {
            try {
                randomList = Randoms.pickUniqueNumbersInRange(1, 45, 6);
                break;
            } catch (IllegalArgumentException e) {
                // 유효한 로또 번호를 생성할 수 없는 경우 다시 시도
            }
        }
        return randomList;
    }
}