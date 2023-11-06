package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public int LottoResults(List<Integer> winningNumber, int bonusNumber) {
        List<Integer> tempWinningNumber = new ArrayList<>(winningNumber);
        tempWinningNumber.retainAll(numbers);
        int matchedNumbers = tempWinningNumber.size();
        if (matchedNumbers == 3) {
            return 5000;
        }
        if (matchedNumbers == 4) {
            return 50000;
        }
        if (matchedNumbers == 5 && numbers.contains(bonusNumber)) {
            return 30000000;
        }
        if (matchedNumbers == 5) {
            return 1500000;
        }
        if (matchedNumbers == 6) {
            return 2000000000;
        }
        return 0;
    }

//  3개 일치 (5,000원) - 1개
//  4개 일치 (50,000원) - 0개
//  5개 일치 (1,500,000원) - 0개
//  5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
//  6개 일치 (2,000,000,000원) - 0개

}
