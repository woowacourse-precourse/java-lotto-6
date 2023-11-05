package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Game {
    public Lottos createLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(Generator.createNumbers()));
        }

        return new Lottos(lottos);
    }


    public long compareLottoNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        return lottoNumbers.stream().filter(winningNumbers::contains).count();
    }

    public Boolean compareBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    public int[] createResult(Lottos lottos, List<Integer> winningNumbers, int bonusNumber) {
        int[] result = new int[6];
        for (Lotto lotto : lottos.getLottos()) {
            int index = checkAnswer(compareLottoNumbers(lotto.getNumbers(), winningNumbers),
                    compareBonusNumber(lotto.getNumbers(), bonusNumber));
            result[index]++;
        }
        return result;
    }


    public int checkAnswer(long count, boolean bonus) {
        int index = 0;

        if (count == 3) {
            index = 1;
        }
        if (count == 4) {
            index = 2;
        }
        if (count == 5 && !bonus) {
            index = 3;
        }
        if (count == 5 && bonus) {
            index = 4;
        }
        if (count == 6 && !bonus) {
            index = 5;
        }
        return index;
    }


}
