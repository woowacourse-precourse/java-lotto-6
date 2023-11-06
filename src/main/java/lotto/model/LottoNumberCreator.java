package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LottoNumberCreator {

    public LottoNumberCreator() {}

    public Lottos createLottoNumbers(int number) {
        List<Lotto> lottos = new ArrayList<>();

        for(int i = 0; i < number; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        return new Lottos(lottos);
    }

    public List<Integer> stringToList(String input) {
        List<Integer> winningNumbers = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(input, ",");

        while(stringTokenizer.hasMoreTokens()) {
            winningNumbers.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        return winningNumbers;
    }

}
