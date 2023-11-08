package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private final int LOTTO_PRICE = 1000;
    PlayerInput input = new PlayerInput();
    private final int time = input.inputMoney() / LOTTO_PRICE;

    public int getTime() {
        return this.time;
    }

    public ArrayList<List<Integer>> lottoGenerator() {
        ArrayList<List<Integer>> randoms = new ArrayList<>();
        NumberGenerator generator = new NumberGenerator();
        for (int i = 0; i < time; i++) {
            List<Integer> randomNumber = generator.makeRandomNumber();
            Lotto lotto = new Lotto(randomNumber);
            randoms = lotto.makeRandoms(randomNumber);
        }
        return randoms;
    }
}

