package lotto;

public class LottoGame {

    public LottoGame(){
    }

    public void startProcess(){
        int money = -1;
        while(money < 0){
            GuideMessage.ofInputMoney();
            money = GameInput.insertMoney();
        }
        Lottos lottos = Lottos.issueLottos(money);
        int issueNumber = lottos.getSize();
        GuideMessage.ofIssuedLottos(lottos,issueNumber);

        GuideMessage.ofInputWinningNumber();
        GameInput.insertWinnigNumbers();

        GuideMessage.ofInputBounsNumber();
        GameInput.insertBonusNumber();

    }

}
