package lotto.controller;

import java.util.List;
import lotto.Lotto;

public class GameController {

    void buyLotto(int money) {
        int count = money / 1000;

        Lotto[] lottos = new Lotto[count];
        Generator generator = new Generator();

        for(Lotto lotto : lottos) {
            List<Integer> lottoNumbers = generator.lottoNumbers();
            lotto = new Lotto(lottoNumbers);
        }

    }
}
