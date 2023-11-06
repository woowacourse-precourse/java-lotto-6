package lotto.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import lotto.model.*;
import lotto.service.Service;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachine {
    private static int ticketNumber = 0;
    private static final int TICKET_PRICE = 1000;
    private static final int PERCENTAGE = 100;
    private static List<Lotto> lottos;
    private static Prize prize;

    public void run() {
        try {
            setAmount();
            setLottoNumber();
            setPrize();
            showResult(lottos, prize, ticketNumber);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    private static void setLottoNumber() {
        LottoNumbers lottoNumbers = new LottoNumbers(ticketNumber);
        lottos = lottoNumbers.getLottos();
        OutputView.printLottos(lottos);
    }
    
}