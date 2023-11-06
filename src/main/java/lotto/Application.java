package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {


    }

    public static List<Lotto> makeRandomLotto(int number){
        List<Lotto> randomLottos = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            randomLottos.add(new Lotto(numbers));
        }
        return randomLottos;
    }
}
