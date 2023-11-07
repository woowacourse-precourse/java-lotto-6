package lotto.client;

import controller.LottoGameController;
import lotto.dto.LottoGameDto;

public class LottoGameClient {
    private LottoGameController lottoGameController;

    public LottoGameClient(LottoGameController lottoGameController) {
        this.lottoGameController = lottoGameController;
    }

    public void run() {
        LottoGameDto.Response response = lottoGameController.createLottoGame();
        LottoGameDto.Request request = new LottoGameDto.Request(response.getLottoGameId());
        lottoGameController.processLottoGame(request);
    }


}
