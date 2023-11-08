package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {

    private static final int MAX_LOTTO_SIZE = 6;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;
    private final List<Integer> numbers;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkItemUnique(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkItemUnique(List<Integer> numbers){

        boolean unique = false;
        Set<Integer> uniqueElements = new HashSet<>();
        for (Integer element : numbers) {

            if (!(uniqueElements.add(element))) {
                unique = true;
            }

        }
        if(unique){
            throw new IllegalArgumentException();
        }
    }

    public void printLotto(){

        System.out.println(numbers);

    }

    public static List<Integer> makeLotto(){

        return new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, MAX_LOTTO_SIZE));

    }

    List<Integer> getLottoNumbers(){

        return numbers;

    }

}
