package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.service.LottoService;
import lotto.view.InputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void start() {
        InputView.printPayAmountInputMessage();
        String lottoPayAmount = Console.readLine();
        // TODO : 로또 구매 기능 인풋 Validate
        lottoService.processStart(Integer.parseInt(lottoPayAmount));

        InputView.printJackpotNumberInputMessage();
        String jackpotNumberInput = Console.readLine();
        // TODO : 당첨번호 인풋 Validate

        List<Integer> jackpotNumbers = converteToList(jackpotNumberInput);


    }

    private List<Integer> converteToList(String jackpotNumberInput) {
        List<Integer> jackpotNumbers = new ArrayList<>();
        for (String number : jackpotNumberInput.split(",")) {
            jackpotNumbers.add(Integer.parseInt(number));
        }
        return jackpotNumbers;
    }
}
