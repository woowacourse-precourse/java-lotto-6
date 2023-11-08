package lotto;

import java.security.Provider.Service;

public class Application {
    public static void main(String[] args) {
        LottoGameService lottoGameService = new LottoGameService();
        lottoGameService.playGame();
    }
}
