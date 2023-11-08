package lotto;

import java.util.List;

public class Game {
    private int purchasingPrice;
    private List<Integer> winningNumber;
    private int bonusNumber;
    private List<List<Integer>> lottoNumbersCollection;


    void execute(){
        purchaseLotto();
        printLottoNumber();
        printStatistics();
    }

    void purchaseLotto(){
        InputView inputView = new InputView();
        purchasingPrice= inputView.inputLottoPrice();
    }

}
