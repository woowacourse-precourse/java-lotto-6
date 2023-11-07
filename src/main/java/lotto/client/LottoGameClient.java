package lotto.client;

import controller.LottoGameController;
import lotto.dto.LottoGameDto;

public class LottoGameClient {
    private LottoGameController lottoGameController;

    public LottoGameClient(LottoGameController lottoGameController) {
        this.lottoGameController = lottoGameController;
    }

    public void run() {
        LottoGameDto.CreateResponse createResponse = lottoGameController.createBudget();
        LottoGameDto.Response response = lottoGameController.createLottoGame(new LottoGameDto.InitRequest(createResponse.getLottoGameId()));
        lottoGameController.processLottoGame(response.getLottoGameId());
    }


}
