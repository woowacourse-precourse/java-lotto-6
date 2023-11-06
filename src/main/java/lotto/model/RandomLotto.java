package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class RandomLotto {
        public List<List<Integer>> randomLotto = new ArrayList<List<Integer>>();

        public RandomLotto(int quantity) {
            this.randomLotto = generateRandomLotto(quantity);
        }

        public static List<List<Integer>> generateRandomLotto(int quantity) {
        List<List<Integer>> randomLotto = new ArrayList<>();

            for (int i = 0; i < quantity; i++) {
                List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
                Collections.sort(randomNumbers);
                randomLotto.add(randomNumbers);
            }
            return randomLotto;
        }
}
