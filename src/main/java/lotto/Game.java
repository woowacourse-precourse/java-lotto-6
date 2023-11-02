package lotto;

import lotto.type.GameType;

public interface Game {
    void start();

    boolean supports(GameType gameType);
}
