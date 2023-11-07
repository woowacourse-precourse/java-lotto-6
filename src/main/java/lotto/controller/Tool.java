package lotto.controller;

import java.util.List;
import lotto.model.Constants;

public class Tool {
    public static int unsafeString2Int(String str) {
        int money;
        try {
            money = Integer.parseInt(str);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return money;
    }

    public static int unsafeDivideBy1000(int num) {
        if (num % Constants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }

        return num / Constants.LOTTO_PRICE;
    }

    public static <T> void uniqueAdd(List<T> list, T value) {
        if (list.contains(value)) {
            return;
        }
        list.add(value);
    }
}
