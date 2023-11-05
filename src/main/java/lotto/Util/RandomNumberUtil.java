package lotto.Util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberUtil {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int NumberQuantity = 6;

    public List<Integer> generateRandomNumberList() {
        List<Integer> randomNumberList = new ArrayList<>();
        IntStream.range(0, NumberQuantity)
                .forEach(i -> randomNumberList.add(generateRandomNumber()));

        return randomNumberList;
    }

    //TODO : 재귀로 짜도 괜찮은지 확인
    public int generateRandomNumber() {
        List<Integer> numberList = new ArrayList<>();
        int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        if (hasNumberDuplicatesInList(numberList, randomNumber)) {
            generateRandomNumber();
        }
        numberList.add(randomNumber);
        return randomNumber;
    }

    private boolean hasNumberDuplicatesInList(List<Integer> numberList, int number) {
        boolean hasDuplicate;

        hasDuplicate = numberList.stream()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                .values()
                .stream()
                .anyMatch(count -> count > 1);

        return hasDuplicate;
    }
}
