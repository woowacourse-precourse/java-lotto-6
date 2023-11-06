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

    public LottoGameDto.Response createLottoGame() {
        IO.printNoticeln(SystemMessage.AMOUNT_INPUT.getMessage());

        String inputMoney=IO.input();

        //input
        List<List<Integer>> buyLottos=new ArrayList<>();
        return lottoGameService.initLottoGame(buyLottos);
    }

}
