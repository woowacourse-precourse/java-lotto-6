package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.WinNum;
import lotto.service.LottoService;

import java.util.List;

import static lotto.template.Print.*;

public class LottoController {

    private static final LottoService lottoService = new LottoService();

    public static void run() {

        int amount = lottoService.getAmount();

        List<Lotto> myLottoList = lottoService.createLottoList(amount);

        printMyLottoList(myLottoList);

        WinNum winNum = lottoService.createWinNum();

        lottoService.getResult(myLottoList, winNum);

        printResult(amount);

    }

}
