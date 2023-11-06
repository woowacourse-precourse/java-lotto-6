package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.ExceptionMessage;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static int LOTTO_MIN_NUMBER = 1;
    private static int LOTTO_MAX_NUMBER = 45;
    private static int LOTTO_ENTITY_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            ExceptionMessage.lengthException();
            throw new IllegalArgumentException();
        }
        if(!numbers.stream().allMatch(number -> number >=LOTTO_MIN_NUMBER && number <= LOTTO_MAX_NUMBER)){
            ExceptionMessage.rangeException();
            throw new IllegalArgumentException();
        }
        if(numbers.stream().distinct().count() != LOTTO_ENTITY_SIZE){
            ExceptionMessage.duplicateException();
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers(){
        return this.numbers;
    }

    public static List<Integer> generateLotto(){
        return sortLotto(Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_ENTITY_SIZE));
    }

    public static List<Integer> sortLotto(List<Integer> lotto){
        return lotto.stream().sorted().collect(Collectors.toList());
    }

    public int countHit(Lotto lottoWinning){
        return (int) numbers.stream()
                .filter(lottoWinning::containNumber)
                .count();
    }

    public boolean containNumber(int number){
        return numbers.contains(number);
    }
}
