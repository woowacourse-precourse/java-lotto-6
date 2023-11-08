package lotto;

import controller.LottoGameController;
import lotto.client.LottoGameClient;
import lotto.repository.LottoGameRepository;
import lotto.service.LottoGameService;

public class Application {
    public static void main(String[] args) {
        LottoGameRepository lottoGameRepository = new LottoGameRepository();
        LottoGameService lottoGameService = new LottoGameService(lottoGameRepository);
        LottoGameController lottoGameController = new LottoGameController(lottoGameService);
        LottoGameClient lottoGameClient = new LottoGameClient(lottoGameController);

        lottoGameClient.run();
    }
}
