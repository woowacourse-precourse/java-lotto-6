package lotto;

public class LottoGame {

    public LottoGame(){
    }

    public void startProcess(){
        GuideMessage.ofInputMoney();
        int money = GameInput.insertMoney();
    }
}
