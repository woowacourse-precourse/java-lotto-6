package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.enumeration.NumberRange;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LottoNumberCreator {
    private static final String COMMA = ",";

    public LottoNumberCreator() {}

    public Lottos createLottoNumbers(int number) {
        List<Lotto> bundleLotto = new ArrayList<>();

        for(int i = 0; i < number; i++) {
            bundleLotto.add(new Lotto(Randoms.pickUniqueNumbersInRange(NumberRange.MIN.getValue(), NumberRange.MAX.getValue(), NumberRange.LOTTO_NUMBER_COUNT.getValue())));
        }

        return new Lottos(bundleLotto);
    }

    public List<Integer> stringToList(String input) {
        List<Integer> winningNumbers = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(input, COMMA);

        while(stringTokenizer.hasMoreTokens()) {
            winningNumbers.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        return winningNumbers;
    }
}
