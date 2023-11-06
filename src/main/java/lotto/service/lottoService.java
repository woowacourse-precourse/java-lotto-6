package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoService {
    public static Integer inputPrice(String price) {
        return validatePrice(price) / 1000;
    }

    private static Integer validatePrice(String price) {
        int tempPrice = Integer.parseInt(price);
        if (tempPrice % 1000 == 0) {
            return tempPrice;
        }
        throw new IllegalArgumentException("잘못된 숫자");
    }

    public static List<Lotto> generateLottoList(Integer numberOfLotto) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            lottoList.add(new Lotto(generateLotto()));
        }
        return lottoList;
    }

    private static List<Integer> generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }

}
