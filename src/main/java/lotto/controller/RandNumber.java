package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandNumber {
//    public static List<Integer> randomLottoNumber(){
//        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
//        return numbers;
//    }

    public static List<Integer> makeLottoNumber() {
        List<Integer> numbers = new ArrayList<>();
        Set<Integer> uniqueNumbers = new HashSet<>();

        while (uniqueNumbers.size() < 6) {
            int randomNumber = generateRandomNumber();
            if (isUniqueNumber(uniqueNumbers, randomNumber)) {
                addUniqueNumber(numbers, uniqueNumbers, randomNumber);
            }
        }
        return numbers;
    }

    private static int generateRandomNumber() {
        return Randoms.pickNumberInRange(1,45);
    }

    private static boolean isUniqueNumber(Set<Integer> uniqueNumbers, int number){
        return !uniqueNumbers.contains(number);
    }

    private static void addUniqueNumber(List<Integer> numbers, Set<Integer> uniqueNumbers, int number){
        uniqueNumbers.add(number);
        numbers.add(number);
    }
}
