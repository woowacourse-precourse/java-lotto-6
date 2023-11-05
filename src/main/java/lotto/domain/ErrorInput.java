package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ErrorInput {
    static public void win_size() {

    }

    static public void bonus_size() {

    }

    static public List<Integer> win_range(String[] input) {
        for(int i=0;i<input.length;i++) {
            if (Integer.parseInt(input[i]) < 1 || Integer.parseInt(input[i]) > 45)
                throw new IllegalArgumentException("[ERROR]");
        }
        Integer[] intinput = Stream.of(input).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        List<Integer> winnum = Arrays.asList(intinput);
        return winnum;
    }

    static public int bonus_range(int number) {
        if(number < 1 || number > 45) throw new IllegalArgumentException("[ERROR]");
        return number;
    }
}