package lotto.client;

import controller.LottoGameController;
import lotto.dto.LottoGameDto;

public class LottoGameClient {
    private LottoGameController lottoGameController;

    public LottoGameClient(LottoGameController lottoGameController) {
        this.lottoGameController = lottoGameController;
    }

    public void run() {
        int budget = lottoGameController.createBudget();
        LottoGameDto.Response response = lottoGameController.createLottoGame(budget);
        lottoGameController.processLottoGame(response.getLottoGameId());
    }


}
