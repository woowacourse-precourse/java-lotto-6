package lotto.controller;


import lotto.model.CalculateNumberOfLotto;
import lotto.model.LottoDraw;
import lotto.model.Lotto;

import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.model.MyLottoNumbers;


public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void StartLotto() {
        try {

            int NumberOfLotto = CalculateNumberOfLotto.InputCost(inputView.inputCost()).getCalculateNumberOfLotto();
            outputView.printNumberOfLotto(NumberOfLotto);

            MyLottoNumbers myLottoNumbers = MyLottoNumbers.generateLottoList(NumberOfLotto);
            outputView.printMyNumbers(myLottoNumbers);


            Lotto winningNumbers = new Lotto(inputView.inputOriginalNumber());
            LottoDraw lottoDraw = LottoDraw.by(winningNumbers);


        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException();
        }
    }

}
