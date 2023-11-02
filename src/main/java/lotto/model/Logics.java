package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
public class Logics {
    public List<Integer> makeRandomList() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static StringBuilder ListToString (List<Integer> numbers) {
        StringBuilder result = new StringBuilder("[");
        for(int i = 0; i < numbers.size(); i++) {
            result.append(numbers.get(i));
            if(i != numbers.size()-1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result;
    }

    public static int strToInt (String str) {
        return Integer.parseInt(str);
    }

}
