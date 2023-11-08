package lotto.domain;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.Message.ErrorMessage;

public class WinningLotto {

    private final List<Integer> numbers;
    int bonusNumber;

    public WinningLotto(List<Integer> numbers, int number) {
        this.numbers = numbers;
        this.bonusNumber = number;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.toString());
        }else if(1 > this.bonusNumber && this.bonusNumber > 45){
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_OUT_OF_RANGE.toString());
        }

        for(int i = 0; i < numbers.size(); i++){
            if (numbers.contains(numbers.get(i))){
                throw new IllegalArgumentException(ErrorMessage.LOTTON_NUMBER_DUPLICATION.toString());
            }else if (1 > numbers.get(i) && numbers.get(i) > 45){
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.toString());
            }else if (this.bonusNumber == numbers.get(i)){
                throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATION.toString());
            }
        }
    }

    public Map<Integer, Integer> compareLottos(List<Lotto> lottos) {
        List<Integer> resultNumber = new ArrayList<>();
        for (Lotto lotto : lottos) {
            resultNumber.add(lotto.checkNumber(numbers, bonusNumber));
        }
        return changeNumbersMap(resultNumber);
    }

    public Map<Integer, Integer> changeNumbersMap(List<Integer> resultNumber) {
        List<Integer> excludeValues = Arrays.asList(0, 1, 2);
        Map<Integer, Integer> countByNumberAsInteger = resultNumber.stream()
                .filter(number -> !excludeValues.contains(number))
                .collect(Collectors.groupingBy(
                        number -> number,
                        Collectors.summingInt(e -> 1)
                ));

        for (int key = 3; key <= 7; key++) {
            countByNumberAsInteger.putIfAbsent(key, 0);
        }

        return countByNumberAsInteger;
    }

}


