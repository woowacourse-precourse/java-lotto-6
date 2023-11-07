package lotto;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.sort;

public class Util {

    private static final String error1 = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String error2 = "[ERROR] 보너스 번호는 중복될 수 없습니다.";

    public static Integer checkNumberValidate(String line) {
        try {
            return Integer.parseInt(line);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    public static Integer checkTotalPrice(Integer price) {
        if(price % 1000 != 0) throw new IllegalArgumentException();
        return price / 1000;
    }

    public static List<Integer> winningNumberCalculate(String line) {
        String[] temp = line.split(",");
        List<Integer> re = new ArrayList<>();
        for(String a: temp) {
            re.add(Integer.parseInt(a));
        }
        sort(re);
        return re;
    }

    public static List<Integer> winningNumberCalculate(List<Integer> winningNumbers, String line) {
        List<Integer> bonus = new ArrayList<>();
        try {
            int temp = Integer.parseInt(line);
            if(winningNumbers.contains(temp)) throw new IllegalArgumentException(error2);
            bonus.add(temp);
            return bonus;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
