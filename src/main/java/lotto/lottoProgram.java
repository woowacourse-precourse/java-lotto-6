package lotto;

public class lottoProgram {
    int price;
    int lottoCount;
    Lottos lottos;
    WinningLotto winningLotto;

    public lottoProgram(){
        start();
    };
    void start(){
        setPriceAndLottoCount();
        makeAndPrintLottos();
        inputWinningLotto();
    }

    void setPriceAndLottoCount(){
        InputPriceAndCalculateLottoCount priceAndLottoCount = new InputPriceAndCalculateLottoCount();
        price = priceAndLottoCount.inputPrice();
        lottoCount = priceAndLottoCount.calculateLottoCount();
    }

    void makeAndPrintLottos(){
        lottos = new Lottos(lottoCount);
        lottos.showLottoNumber();
    }

    void inputWinningLotto(){
        InputWinningLotto inputWinningLotto = new InputWinningLotto();
        winningLotto = inputWinningLotto.inputLotto();
    }
}