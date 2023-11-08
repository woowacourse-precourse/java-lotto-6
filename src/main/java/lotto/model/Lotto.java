package lotto.model;

import static lotto.model.User.lottoBoughtNum;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
//    private final List<Integer> numbers;

//    public Lotto(List<Integer> numbers) {
//        validate(numbers);
//        this.numbers = numbers;
//    }

    public static List<List<Integer>> allLottoList() {
        List<List<Integer>> allLottoList = IntStream.range(0, lottoBoughtNum)
                .mapToObj(i -> Randoms.pickUniqueNumbersInRange(1, 45, 6)
                        .stream()
                        .sorted()
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());

        return allLottoList;
    }

//    private void validate(List<Integer> numbers) {
//        if (numbers.size() != 6) {
//            throw new IllegalArgumentException();
//        }
//    }
}
