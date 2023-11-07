package lotto.controller;

import lotto.domain.dto.InputMoney;
import lotto.domain.dto.PurchasedLottoDTO;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    public static void lottoStart(){
        inputMoney();
        PurchasedLottoDTO purchasedLottoDTO = LottoService.purchasedLottoToDTO();
        OutputView.printPurchasedLotto(purchasedLottoDTO);
    }

    private static void inputMoney(){
        try{
            InputMoney money = InputView.inputMoney();
            LottoService.lottoStart(money);
        } catch (IllegalArgumentException e){
            OutputView.printErrorMessage(e);
            inputMoney();
        }
    }
}
