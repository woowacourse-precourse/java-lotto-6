package lotto;

public class lottoProgram {
    int price;
    int lottoCount;

    public lottoProgram(){
        start();
    };
    void start(){
        setPriceAndLottoCount();
        makeAndPrintLottos();
    }

    void setPriceAndLottoCount(){
        InputPriceAndCalculateLottoCount priceAndLottoCount = new InputPriceAndCalculateLottoCount();
        price = priceAndLottoCount.inputPrice();
        lottoCount = priceAndLottoCount.calculateLottoCount();
    }

    void makeAndPrintLottos(){
        Lottos lottos = new Lottos(lottoCount);
        lottos.showLottoNumber();
    }
}