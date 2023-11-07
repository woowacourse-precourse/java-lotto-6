package lotto;

import java.util.List;

public class Converter {
    final static int firstPrize = 2000000000;
    final static int secondPrize = 30000000;
    final static int thridPrize = 1500000;
    final static int forthPrize = 50000;
    final static int fifthPrize = 5000;
    final static int noPrize = 0;

    public static int parseToInt(String rawValue) {
        try {
            return Integer.parseInt(rawValue);
        } catch (NumberFormatException wrongType) {
            throw new IllegalArgumentException("정수를 입력해주세요");
        }
    }

    public int carculateWinPrize(List<Integer> wins) {
        int sum = 0;
        wins.set(0,wins.get(0)*firstPrize);
        wins.set(1,wins.get(1)*secondPrize);
        wins.set(2,wins.get(2)*thridPrize);
        wins.set(3,wins.get(3)*forthPrize);
        wins.set(4,wins.get(4)*fifthPrize);
        wins.set(5,wins.get(5)*noPrize);
        for (int value:wins) {
            sum += value;
        }
        return sum;
    }
}
