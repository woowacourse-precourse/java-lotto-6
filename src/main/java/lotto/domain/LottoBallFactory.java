package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoBallFactory {
    private static final Map<Integer, LottoBall> lottoBallPool = new HashMap<>();

    private LottoBallFactory() {
    }

    public static LottoBall grabFromPool(int number) {
        return lottoBallPool.get(number);
    }

    public static boolean isExists(int number) {
        return lottoBallPool.containsKey(number);
    }

    public static void addToPool(int number, LottoBall lottoBall) {
        lottoBallPool.put(number, lottoBall);
    }
}
