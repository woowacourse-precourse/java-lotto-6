package domain;


public class MainController {

    public void start(){
        purchsePrice();
        myLottoNumbers();
    }

    private void purchsePrice(){
        OutPut.inPutPurchsePrice();
        UserInputStore.lottoPurchase();
    }

    private void myLottoNumbers(){
        Store.randomNumbers();
        OutPut.paperNumbers();
        OutPut.myLottoNumbers();
    }
}
