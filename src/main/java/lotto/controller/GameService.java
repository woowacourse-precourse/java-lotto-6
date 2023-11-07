package lotto.controller;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    private Setting setting;
    private List<Lotto> lottos;

    public GameService() {
        setting = new Setting();
        lottos = new ArrayList<>();
    }

    public void play() {
        int repetitions = setting.purchaseLotto();

        for (int i = 0; i < repetitions; i++) {
            Lotto lotto = new Lotto(setting.pickLotto());
            lottos.add(lotto);
        }
    }
}
