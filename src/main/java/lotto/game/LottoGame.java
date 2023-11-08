package lotto.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoGame {

    private static final int PRICE = 1000;
    private final int inputNumber;

    public LottoGame(int inputNumber) {
        this.inputNumber = inputNumber;
    }

    public int getNumberOfGames() {
        return inputNumber / PRICE;
    }

    private Lotto createLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public List<Lotto> createLottoList(int count) {
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottoList.add(createLotto());
        }

        return lottoList;
    }
}
