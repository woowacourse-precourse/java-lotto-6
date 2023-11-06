package lotto.model;

import java.util.HashMap;
import java.util.HashSet;

public class LottoResult {

    private static HashMap<Integer, Integer> result = new HashMap<>();
    public LottoResult(HashMap result) {
        this.result = result;
    }

    public static HashMap statistics(int count, int choice) {
        if (count == 3) {
            int num = result.get(4);
            num++;
            result.put(4,num);
        }
        if (count == 4) {
            int num = result.get(3);
            num++;
            result.put(3,num);
        }
        if (count == 5 && choice == 1) {
            int num = result.get(1);
            num++;
            result.put(1,num);
        }
        if (count == 5 && choice == 0) {
            int num = result.get(2);
            num++;
            result.put(2,num);
        }
        if (count == 6) {
            int num = result.get(0);
            num++;
            result.put(0,num);
        }
        return result;
    }
}
