package lotto.view;

import lotto.model.Game;

public interface GameView {
    void showInputRequiredMessage(String key);

    void showProgressOf(Game game);

    void showResultOf(Game game);
}
