package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

import static lotto.ErrorCode.LOTTERY_NUMBER_DUPLICATED_ERROR;
import static lotto.ErrorCode.LOTTERY_SIZE_ERROR;
import static lotto.LottoRank.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTERY_SIZE_ERROR.getMessage());
        }

        boolean[] isExistedNumber = new boolean[46];
        numbers.forEach(number -> {
            if(isExistedNumber[number])
                throw new IllegalArgumentException(LOTTERY_NUMBER_DUPLICATED_ERROR.getMessage());
            isExistedNumber[number] = true;
        });
    }

    public boolean isNumberExisted(int number){
        return numbers.contains(number);
    }

    // TODO: 추가 기능 구현
    public void printNumbers() {
        System.out.println(getSortedNumberString());
    }

    public String getSortedNumberString(){
        StringJoiner stringJoiner = new StringJoiner(", ");
        getSortedNumber().forEach(number -> stringJoiner.add(number + ""));
        return "[" + stringJoiner + "]";
    }

    private List<Integer> getSortedNumber() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    public LottoRank getRank(Lotto winningLotto, int bonusNumber) {
        long numberScore = this.numbers.stream()
                .filter(winningLotto.numbers::contains)
                .count();
        if (numberScore == 6)
            return FIRST;
        else if (numberScore == 5 && this.numbers.contains(bonusNumber))
            return SECOND;
        else if (numberScore == 5)
            return THIRD;
        else if (numberScore == 4)
            return FORTH;
        else if (numberScore == 3)
            return FIFTH;
        return SIXTH;
    }
}
