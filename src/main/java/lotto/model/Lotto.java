package lotto.model;

import lotto.utils.LottoExceptions;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;
    static private final int DRAW_COUNT = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        sort();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != DRAW_COUNT) {
            throw new IllegalArgumentException(LottoExceptions.InvalidCountError.getErrorMessage());
        }
    }

    public int match(int winnerNumber){
        return Collections.binarySearch(numbers, winnerNumber);
    }

    private void sort(){
        Collections.sort(numbers);
    }

    public String printLotto() {
       return Arrays.toString(numbers.toArray());
    }
}
