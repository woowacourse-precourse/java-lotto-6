package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    private static final int MIN = 1;
    private static final int MAX = 45;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        between_number(numbers);
        Find_Duplicates(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private static void between_number(List<Integer> numbers){
        for (int i=0; i<numbers.size(); i++){
            if(numbers.get(i)>MAX||numbers.get(i)<MIN){
                throw new IllegalArgumentException();
            }
        }
    }

    private static void Find_Duplicates(List<Integer> numbers){
        Set<Integer> duplicates = new HashSet<>();
        for (int i = 0; i < numbers.size(); i++) {
            duplicates.add(numbers.get(i));
        }
        if(duplicates.size() !=6){
            throw new IllegalArgumentException();
        }
    }

}
