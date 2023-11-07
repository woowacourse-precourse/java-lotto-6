package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.UserLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserLottoService {
    public Lotto stringToLotto(String input) {
        String[] inputArray = input.split(",");
        List<Integer> lottoNums = new ArrayList<>();
        for (String str : Arrays.asList(inputArray)) {
            lottoNums.add(Integer.parseInt(str));
        }

        return new Lotto(lottoNums);
    }

    public UserLotto getUserLotto(Lotto lotto, int bonusNum, int amount) {
        return new UserLotto(lotto, bonusNum, amount);
    }
}
