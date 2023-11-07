package lotto.utils;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoUtil {
    final String NUM_REG = "[0-9]+";

    public String getUserInput() {
        return Console.readLine();
    }

    public List<List<Integer>> getLottos(int count) {
        List<List<Integer>> lottos = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(numbers);
        }
        return lottos;
    }

    public void validateNumberCheck(String number) {
        String deleteCommaNumber = number.replaceAll(",", "").replaceAll(" ", "");
        if(!deleteCommaNumber.matches(NUM_REG)) {
            throw new IllegalArgumentException(ExceptionMessage.WINNING_NUMBER.getValue());
        }
    }

    public List<Integer> convertNumbers(String number) {
        List<String> numbers = new ArrayList<>(Arrays.asList(number.replaceAll(" ","").split(",")));
        numbers.removeIf(String::isEmpty);
        return  numbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
