package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class MakeLottoCard {
    List<List<Integer>> numbers = new ArrayList<>();

    public MakeLottoCard(Integer number) {
        makeCard(number);
    }

    public List<Integer> pickNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 7) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    public void makeCard(Integer number) {
        for (int i = 0; i < number; i++) {
            List<Integer> nums = pickNumbers();
            numbers.add(nums);
        }
    }
}
