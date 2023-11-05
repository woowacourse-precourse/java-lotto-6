package lotto.print;

import java.util.List;
import java.util.StringJoiner;
import lotto.Lotto;

public class Result {
    public static void printLottoNumber(List<Lotto> lottoNumbers) {
        for (Lotto numbers : lottoNumbers) {
            System.out.print("[");
            System.out.print(joinNumber(numbers.getNumbers()));
            System.out.println("]");
        }
    }

    public static String joinNumber(List<Integer> numbers){
        StringJoiner joiner = new StringJoiner(", ");
        for(int number : numbers){
            joiner.add(String.valueOf(number));
        }
        return joiner.toString();
    }
}
