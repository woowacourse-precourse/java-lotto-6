package model;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateCheck(numbers);
        sortLotto(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static void duplicateCheck(List<Integer> numbers){
        Set<Integer> set = new HashSet<>(numbers);
        if(set.size() != numbers.size()){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString(){
        return String.format(numbers.toString());
    }
    void sortLotto(List<Integer> numbers){
        numbers.sort(Comparator.naturalOrder());
    }
}
