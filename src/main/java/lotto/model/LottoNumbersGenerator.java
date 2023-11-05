package lotto.model;

import static lotto.Constraints.MAX_NUMBER;
import static lotto.Constraints.MIN_NUMBER;
import static lotto.Constraints.SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbersGenerator {
    public List<Integer> generateLottoNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        addNumbers(randomNumbers);
        sortLottoNumbers(randomNumbers);
        return randomNumbers;
    }

    // List에 숫자 6개 추가
    private void addNumbers(List<Integer> randomNumbers) {
        while (randomNumbers.size() < SIZE.getValue()) {
            int randomNumber = createRandomNonDuplicateNumber(randomNumbers);
            randomNumbers.add(randomNumber);
        }
    }

    // 랜덤 숫자 1개 생성
    private int createRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER.getValue(), MAX_NUMBER.getValue());
    }

    // 중복되지 않은 숫자 생성
    private int createRandomNonDuplicateNumber(List<Integer> randomNumbers) {
        int randomNumber;
        do {
            randomNumber = createRandomNumber();
        } while (randomNumbers.contains(randomNumber));
        return randomNumber;
    }

    // List 정렬
    private void sortLottoNumbers(List<Integer> randomNumbersList) {
        Collections.sort(randomNumbersList);
    }
}