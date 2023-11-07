package lotto.controller;

import lotto.domain.Lotto;
import lotto.view.Output;

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

        lottos = setting.pickLottos(repetitions);
    }
}
