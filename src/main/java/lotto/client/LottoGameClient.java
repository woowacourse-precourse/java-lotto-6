package lotto.client;

import controller.LottoGameController;
import lotto.dto.LottoGameDto;
import lotto.util.IO;
import lotto.util.SystemMessage;

public class LottoGameClient {
    private LottoGameController lottoGameController;

    public LottoGameClient(LottoGameController lottoGameController) {
        this.lottoGameController = lottoGameController;
    }

    public void run() {
        LottoGameDto.CreateResponse createResponse = lottoGameController.createBudget();
        LottoGameDto.Response response = lottoGameController.createLottoGame(new LottoGameDto.InitRequest(createResponse.getLottoGameId()));
        LottoGameDto.Result result = lottoGameController.processLottoGame(response.getLottoGameId());
        printResult(result);

    }

    private void printResult(LottoGameDto.Result result) {
        IO.printNoticeln(SystemMessage.RESULT_OUTPUT.getMessage());
        IO.printNoticeln(SystemMessage.RESULT_START.getMessage());
        IO.printNoticeln(SystemMessage.THREE.getMessage()+result.getThree()+SystemMessage.EA.getMessage());
        IO.printNoticeln(SystemMessage.FOUR.getMessage()+result.getFour()+SystemMessage.EA.getMessage());
        IO.printNoticeln(SystemMessage.FIVE.getMessage()+result.getFive()+SystemMessage.EA.getMessage());
        IO.printNoticeln(SystemMessage.FIVEANDBONUS.getMessage()+result.getFiveAndBonus()+SystemMessage.EA.getMessage());
        IO.printNoticeln(SystemMessage.SIX.getMessage()+result.getSix()+SystemMessage.EA.getMessage());
        IO.printNoticeln(SystemMessage.TOTAL1.getMessage()+result.getRate()+SystemMessage.TOTAL2.getMessage());
    }


}
