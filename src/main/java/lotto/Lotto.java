package lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

    }

    static void checkDuplicate(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>();

        for(int number: numbers){
            if(number<0){
                throw new IllegalArgumentException();
            }

            if(set.isEmpty()){
                set.add(number);
                continue;
            }

            if (set.contains(number)){

                throw new IllegalArgumentException();

            }

            set.add(number);


        }
    }

    public List<Integer> getNumbers() {

        ArrayList<Integer> sortedNumbers = new ArrayList<>();

        for(int number: numbers){

            sortedNumbers.add(number);
        }
        sortedNumbers.sort(Comparator.naturalOrder());
        return sortedNumbers;
    }
}
