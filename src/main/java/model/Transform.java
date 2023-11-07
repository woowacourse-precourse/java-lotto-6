package model;

import static constants.ConstantNumbersManager.LOTTO_NUMBER_SIZE;
import static constants.ConstantNumbersManager.MAXIMUM_LOTTO_NUMBER;
import static constants.ConstantNumbersManager.MINIMUM_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import constants.ConstantStringManager;
import java.util.ArrayList;
import java.util.List;

public class Transform {
    public List<Integer> winningNumberToList(String input) {
        String[] parts = input.split(ConstantStringManager.SPLIT_TARGET.getMessage());
        List<Integer> numbers = new ArrayList<>();

        for (String part : parts) {
            int number = Integer.parseInt(part);
            numbers.add(number);
        }
        return numbers;
    }

    public List<Integer> generateRandomList() {
        List<Integer> randoms;
        while (true) {
            try {
                randoms = Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER,
                        LOTTO_NUMBER_SIZE);
                break;
            } catch (IllegalArgumentException e) {
                // 유효한 로또 번호를 생성할 수 없는 경우 다시 시도
            }
        }
        return randoms;
    }
}