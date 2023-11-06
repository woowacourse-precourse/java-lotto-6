package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private final static int MIN = 1;
    private final static int MAX = 45;
    private final static int NUMBER = 6;
    private List<Lotto> lottos = new ArrayList<>();

    public void start() {
        UserInput input = new UserInput();
        int count = input.purchase();
        generateLottoNumbers(count);
        input.luckyNumber();
        input.bonusNumber();
    }

    public List<Lotto> generateLottoNumbers(int count) {
        for (int i = 0; i < count; i++) {
            List<Integer> generateNumbers = Randoms.pickUniqueNumbersInRange(MIN, MAX, NUMBER);
            Lotto lotto = new Lotto(generateNumbers);
            lottos.add(lotto);
        }
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getRandomNumber());
        }
        return lottos;
    }

    public void guessNumbers(List<Lotto> random, List<Lotto> lucky, int bonus){

    }
}