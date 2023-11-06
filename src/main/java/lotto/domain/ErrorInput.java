package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ErrorInput {
    static public List<Integer> win_range(String[] input) {
        if(input.length != 6) throw new IllegalArgumentException("[ERROR]");
        for (int i = 0; i < input.length; i++) {
            range(input[i]);
            if (Integer.parseInt(input[i]) < 1 || Integer.parseInt(input[i]) > 45)
                throw new IllegalArgumentException("[ERROR]");
        }
        Integer[] intinput = Stream.of(input).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        List<Integer> winnum = Arrays.asList(intinput);
        return winnum;
    }

    static public int range(String number) {
        if(number.length() < 1 || number.length() > 2) throw new IllegalArgumentException("[ERROR]");
        for(int i=0;i<number.length();i++)
            if(number.charAt(i) < '0' || number.charAt(i) > '9' ) throw new IllegalArgumentException("[ERROR]");
        int intnum = Integer.parseInt(number);
        if (intnum < 1 || intnum > 45) throw new IllegalArgumentException("[ERROR]");
        return intnum;
    }
}