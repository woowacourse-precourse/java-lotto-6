package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class ErrorInput {
    static public List<Integer> win_range(String[] input) {
        if (input.length != 6) throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요.");
        for (int i = 0; i < input.length; i++) {
            range(input[i]);
            if (Integer.parseInt(input[i]) < 1 || Integer.parseInt(input[i]) > 45)
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        Integer[] intinput = Stream.of(input).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        List<Integer> winnum = Arrays.asList(intinput);
        Set<Integer> winset = new HashSet<>(winnum);
        if(winset.size() != winnum.size()) throw new IllegalArgumentException("[ERROR] 중복 요소가 있습니다.");
        return winnum;
    }

    static public int bonus_range(int number, List<Integer> win) {
        if (win.contains(number)) throw new IllegalArgumentException("[ERROR] 당첨 번호와 다른 번호여야 합니다.");
        return number;
    }

    static public int range(String number) {
        if (number.length() < 1 || number.length() > 2) throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자여야 합니다.");
        for (int i = 0; i < number.length(); i++)
            if (number.charAt(i) < '0' || number.charAt(i) > '9') throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        int intnum = Integer.parseInt(number);
        if (intnum < 1 || intnum > 45) throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        return intnum;
    }

    static public String buy_range(String price) {
        if(price.length() == 0) throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        for(int i=0;i<price.length();i++){
            if(price.charAt(i) < '0' || price.charAt(i) > '9') throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
        return price;
    }

    static public int buy_price(int price) {
        if(price % 1000 > 0 || price == 0) throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위 입니다.");
        return price;
    }
}