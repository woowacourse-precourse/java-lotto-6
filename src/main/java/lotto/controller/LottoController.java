package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(){
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start(){
        int buyCount = calculateLottoCount(inputView.readBuyAmount());
        outputView.displayPurchaseCount(buyCount);
        Lottos lottos = new Lottos(buyCount);
        printInfo(lottos.getLottos());
        lottos.checkWinningNumbers(parseNumbers(inputView.readWinningNumbers()), inputView.readBonusNumber());
    }

    private void printInfo(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            outputView.printInfo(lotto.getNumbers());
        }
    }


    private List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int calculateLottoCount(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("로또는 1000원 단위만 구매할 수 있습니다.");
        }
        return money / 1000;
    }

}
