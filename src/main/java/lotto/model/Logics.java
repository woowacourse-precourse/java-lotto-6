package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
public class Logics {
    public static List<Integer> makeRandomList() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    //List<Integer>는 그냥 출력을 해도된다.
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

    public static double benefit (int money, int sum) {
        double temp = (double) sum / (double) money;
        return temp*100;
    }

}
