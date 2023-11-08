package lotto.service;

import java.util.Arrays;
import java.util.List;

public class LottoService {

    public List<Integer> getWinning(List<Integer> myLotto, List<Integer> lotto, int bonusNumber) {
        int lottoCount = 0;
        int bonusCount = 0;

        for (Integer number : myLotto) {
            if(lotto.contains(number)) {
                lottoCount++;
            }
            if(number == bonusNumber) {
                bonusCount++;
            }
        }

        return Arrays.asList(lottoCount, bonusCount);
    }

}
