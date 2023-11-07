package controller;

import lotto.dto.LottoGameDto;
import lotto.service.LottoGameService;
import lotto.util.IO;
import lotto.util.SystemMessage;

import java.util.ArrayList;
import java.util.List;

public class LottoGameController {
    private LottoGameService lottoGameService;



    public LottoGameController(LottoGameService lottoGameService) {
        this.lottoGameService = lottoGameService;
    }

    public int createBudget() {
        IO.printNoticeln(SystemMessage.AMOUNT_INPUT.getMessage());

        Integer amount=IO.inputBudget();
        IO.printNoticeln(amount+ SystemMessage.PURCHASE_NIO.getMessage());
        return amount;
    }

    public LottoGameDto.Response createLottoGame(int amount) {
        LottoGameDto.Response response = lottoGameService.initLottoGame(amount);
        for (List<Integer> lottoNumber : response.getLottoNubers()  ) {
            IO.printLotto(lottoNumber);
        }
        return response;
    }


    public LottoGameDto.Result processLottoGame(Long requestId) {
        IO.printNoticeln(SystemMessage.ANSWER_INPUT.getMessage());
        List<Integer> integers = IO.inputWinningNumber();
        IO.printNoticeln(SystemMessage.BONUS_INPUT.getMessage());
        Integer integer = IO.BonusNumber();
        return lottoGameService.doLottoGame(new LottoGameDto.Request(requestId,integers,integer));
    }

}
