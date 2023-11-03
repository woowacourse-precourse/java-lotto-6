package model;

import java.util.List;

public class GameManager {

    private final LottosWithBonus lottos;
    private LottosWithBonus answerLotto;

    private GameManager(final LottosWithBonus lottos) {
        this.lottos = lottos;
    }

    public static GameManager createDefault(final int lottoCount) {
        return new GameManager(LottosWithBonus.createAsManyAsCount(lottoCount));
    }
}
