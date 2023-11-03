package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private int lottoCnt;

    public void run() {
        part1();
        part2();
        part3();
    }

    public void part1() {
        OutputView.printBuyInputPrice();
        String userInput = InputView.userInput();
        int userPrice = InputView.userInputParsedInt(userInput);
        lottoCnt = userPrice / 1000;
        OutputView.printBuyLottoCount(lottoCnt);
    }

    public void part2(){
        List<Lotto> lottoies = new ArrayList<>();
        for (int i = 0; i < lottoCnt; i++) {
            Lotto lotto = LottoFactory.generateLotto();
            lottoies.add(lotto);
        }

        for (Lotto lottos : lottoies) {
            System.out.println(lottos);
        }
    }

    public void part3(){
        OutputView.printEntertWinningNumber();
        InputView.userInput();
        OutputView.printEnterBounsNumber();
        InputView.userInput();
    }


}
