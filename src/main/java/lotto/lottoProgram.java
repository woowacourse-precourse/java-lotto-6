package lotto;

import java.util.ArrayList;

public class lottoProgram {
    int price;
    int lottoCount;
    Lottos lottos;
    ArrayList<Lotto> lottoNumber;
    WinningLotto winningLotto;
    ArrayList<Integer> matchingStatus;

    public lottoProgram(){
        start();
    };
    void start(){
        setPriceAndLottoCount();
        makeAndPrintLottos();
        inputWinningLotto();
        checkMatching();
        printStaticAndRevenue();
    }

    void setPriceAndLottoCount(){
        InputPriceAndCalculateLottoCount priceAndLottoCount = new InputPriceAndCalculateLottoCount();
        price = priceAndLottoCount.inputPrice();
        lottoCount = priceAndLottoCount.calculateLottoCount();
    }

    void makeAndPrintLottos(){
        lottos = new Lottos(lottoCount);
        lottos.showLottoNumber();
        lottoNumber = lottos.getLottos();
    }

    void inputWinningLotto(){
        InputWinningLotto inputWinningLotto = new InputWinningLotto();
        winningLotto = inputWinningLotto.inputLotto();
    }

    void checkMatching(){
        MatchingLotto matchingLotto = new MatchingLotto(lottoNumber, winningLotto);
        matchingStatus = matchingLotto.getMatchingStatus();
    }

    void printStaticAndRevenue(){
        new PrintStatisticAndRevenue(matchingStatus,price);
    }

}