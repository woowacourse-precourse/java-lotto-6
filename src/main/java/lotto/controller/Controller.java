package lotto.controller;

import lotto.domain.Lotties;
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
        Lotties lotties = Lotties.generateLottos(lottoCnt);
        OutputView.pritntLottos(lotties.getLotties());
    }

    public void part3(){
        OutputView.printEntertWinningNumber();
        InputView.userInput();
        OutputView.printEnterBounsNumber();
        InputView.userInput();
    }

    public void part4(){
        
    }


}
