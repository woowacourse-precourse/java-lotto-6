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

    public  LottoGameDto.CreateResponse createBudget() {
        IO.printNoticeln(SystemMessage.AMOUNT_INPUT.getMessage());

        LottoGameDto.CreateResponse response = inputBudget();

        IO.printNoticeln(response.getAmount()+ SystemMessage.PURCHASE_NIO.getMessage());
        return response;
    }
    private LottoGameDto.CreateResponse inputBudget(){
        try{
            String budget=IO.inputBudget();
           return lottoGameService.createLottoGame(budget);
        }catch (IllegalArgumentException e) {
            IO.printNoticeln(e.getMessage());
            return inputBudget();
        }
    }

    public LottoGameDto.Response createLottoGame( LottoGameDto.InitRequest request) {
        LottoGameDto.Response response = lottoGameService.initLottoGame(request);
        for (List<Integer> lottoNumber : response.getLottoNubers()  ) {
            IO.printLotto(lottoNumber);
        }
        return response;
    }


    public LottoGameDto.Result processLottoGame(Long requestId) {
        IO.printNoticeln(SystemMessage.ANSWER_INPUT.getMessage());

        List<Integer> integers = inputWinningNumber();
        IO.printNoticeln(SystemMessage.BONUS_INPUT.getMessage());
        Integer integer = inputBonusNumber(integers);
        return lottoGameService.doLottoGame(new LottoGameDto.Request(requestId,integers,integer));
    }

    private Integer inputBonusNumber( List<Integer> integers) {
        try{
            return IO.BonusNumber(integers);
        }catch (IllegalArgumentException e) {
            IO.printNoticeln(e.getMessage());
            return inputBonusNumber(integers);
        }
    }

    private List<Integer> inputWinningNumber() {
        try{
            return IO.inputWinningNumber();
        }catch (IllegalArgumentException e) {
            IO.printNoticeln(e.getMessage());
            return inputWinningNumber();
        }
    }

}
