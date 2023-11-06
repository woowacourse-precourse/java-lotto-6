package model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import utility.Lotto;

public class Transform {

    public List<Integer> winningNumberToList(String input) {
        List<Integer> numbers = new ArrayList<>();
        String[] parts = input.split(",");
        for (String part : parts) {
            int number = Integer.parseInt(part);
            numbers.add(number);
        }
        return numbers;
    }

    public List<Integer> generateRandomList() {
        List<Integer> randomList = null;
        while (randomList == null) {
            try {
                randomList = Randoms.pickUniqueNumbersInRange(1, 45, 6);
                Lotto lotto = new Lotto(randomList);
            } catch (IllegalArgumentException e) {
                // 유효한 로또 번호를 생성할 수 없는 경우 다시 시도
            }
        }
        return randomList;
    }

    public List<List<Integer>> fullLottoValue(List<List<Integer>> fullLottoValue, List<Integer> randomList) {
        fullLottoValue.add(randomList);
        return fullLottoValue;
    }
}

