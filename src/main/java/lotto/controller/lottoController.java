package lotto.controller;

import static lotto.view.messagePrinter.printPurchasedLottos;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.model.Lotto;
import lotto.view.userInput;
import lotto.view.messagePrinter;
import lotto.model.Cash;
import lotto.service.lottoService;

public class lottoController {

    private final lottoService service;


    public lottoController(){
        this.service = new lottoService();

    }

    final int lottoNumberLimit = 6;
    final int lottoNumberStart = 1;
    final int lottoNumberEnd = 45;

    public void run(){
        messagePrinter.printPurchaseAmount();
        Cash cash = new Cash(userInput.getInteger());

        messagePrinter.printPurchaseAmount(cash.getCount());

        lottoService.publishLottos(cash.getCount());

        messagePrinter.printPurchasedLottos();

    }



}
