package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.WinNum;
import lotto.enums.LottoEnum;
import lotto.service.LottoService;

import java.util.List;

public class LottoController {

    private static final LottoService lottoService = new LottoService();

    public static void run() {

        int amount = lottoService.getAmount();

        List<Lotto> myLottoList = lottoService.createLottoList(amount);

        lottoService.printMyLottoList(myLottoList);

        WinNum winNum = lottoService.createWinNum();

        lottoService.getResult(myLottoList, winNum);

        LottoEnum.printResult(amount);

    }

}
