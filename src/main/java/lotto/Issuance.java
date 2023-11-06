package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Issuance {
    public List<List<Integer>> Issue(int purchase_count) {
        List<List<Integer>> purchase_lottos = new ArrayList<>();
        for (int i=0; i<purchase_count; i++) {
            List<Integer> tempNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> numbers = new ArrayList<>(tempNumbers);
            numbers.sort(null);
            purchase_lottos.add(numbers);
        }
        return purchase_lottos;
    }
}
