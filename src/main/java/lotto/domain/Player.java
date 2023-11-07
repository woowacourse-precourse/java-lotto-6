package lotto.domain;

import java.util.ArrayList;

public class Player {
    private final ArrayList<Lotto> lottos;
    private final Lotto WINNING_NUMBERS;
    private final int BONUS_NUMBER;

    public Player(ArrayList<Lotto> lottos, Lotto winningnumbers, int bonus) {
        this.lottos = lottos;
        WINNING_NUMBERS = winningnumbers;
        BONUS_NUMBER = bonus;
    }

    private ArrayList<Lotto> getLottos() {
        return lottos;
    }


}
