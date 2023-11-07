package lotto.service;

import lotto.Lotto;

import java.util.*;

public class NumberMatch {

    private static final int SIZE=6;
    public List<Integer> matching(List<Lotto> lottoNumbers,List<Integer> inputlottoNumbers) {
        List<Integer> winCount = new ArrayList<>();
        for (int i = 0; i < lottoNumbers.size(); i++) {
            List<Integer> notWinLottoNumber = lottoNumbers.get(i).returnNumbers();
            notWinLottoNumber.removeAll(inputlottoNumbers);
            winCount.add(SIZE - notWinLottoNumber.size());
        }
        return winCount;
    }


    public List<Boolean> containBonusAll(List<Lotto> lottoNumbers, int bonus) {
        List<Boolean> containBonus = new ArrayList<>(Collections.nCopies(lottoNumbers.size(), false));
        for (int i = 0; i < lottoNumbers.size(); i++) {
            if (containBouns(lottoNumbers.get(i), bonus)) {
                containBonus.set(i, true);
            }
        }
        return containBonus;
    }

    public boolean containBouns(Lotto lottoNumber, int bonus) {
        List<Integer> lotto = lottoNumber.returnNumbers();
        return lotto.contains(bonus);

    }

}
