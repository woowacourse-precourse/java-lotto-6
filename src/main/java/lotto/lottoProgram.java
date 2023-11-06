package lotto;

public class lottoProgram {
    int price;
    int lottoCount;

    public lottoProgram(){
        start();
    };
    void start(){
        setPriceAndLottoCount();
    }

    void setPriceAndLottoCount(){
        inputPriceAndCalculateLottoCount priceAndLottoCount = new inputPriceAndCalculateLottoCount();
        price = priceAndLottoCount.inputPrice();
        lottoCount = priceAndLottoCount.calculateLottoCount();
    }
}