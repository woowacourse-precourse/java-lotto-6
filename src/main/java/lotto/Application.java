package lotto;

import lotto.domain.User;
import lotto.service.LottoGame;

public class Application {
    public static void main(String[] args) {
        new LottoGame(new User()).play();
    }
}
