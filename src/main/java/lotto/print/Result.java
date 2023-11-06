package lotto.print;

import java.util.List;
import java.util.StringJoiner;
import lotto.Lotto;
import lotto.enums.Message;
import lotto.util.User;

public class Result {
    User user = new User();
    public void printLottoNumber(List<Lotto> lottoNumbers) {
        Message.PURCHASE_LOTTO.getMessage();
        for (Lotto numbers : lottoNumbers) {
            System.out.print("[");
            System.out.print(joinNumber(numbers.getNumbers()));
            System.out.println("]");
        }
    }

    public String joinNumber(List<Integer> numbers){
        StringJoiner joiner = new StringJoiner(", ");
        for(int number : numbers){
            joiner.add(String.valueOf(number));
        }
        return joiner.toString();
    }
}
