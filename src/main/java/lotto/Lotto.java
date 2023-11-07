package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final int MAX_AMOUNT = 6;
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
    public static Lotto makeLottoWithRandomNumbers(){
        Set<Integer> lottoes = new HashSet<>();
        while(lottoes.size() != MAX_AMOUNT){
            lottoes.add(Randoms.pickNumberInRange(1, 45));
        }
        return new Lotto(lottoes.stream().sorted().collect(Collectors.toList()));
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }
}
