package lotto.service;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoService {
    public Lotto stringToLotto(String input) {
        String[] inputArray = input.split(",");
        List<Integer> lottoNums = new ArrayList<>();
        for(String str : Arrays.asList(inputArray)) {
            lottoNums.add(Integer.parseInt(str));
        }

      return new Lotto(lottoNums);
    }
}
