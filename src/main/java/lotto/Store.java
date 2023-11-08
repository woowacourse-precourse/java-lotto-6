package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Store {

    public static List<Lotto> publishLotto(int money) {
        int lottopaperNumbers = money / 1000;

        List<Lotto> lotto_list = new ArrayList<>();

        for(int i = 0; i < lottopaperNumbers; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lotto_list.add(lotto);
        }

        System.out.println("8개를 구매했습니다.");
        return lotto_list;
    }
}
