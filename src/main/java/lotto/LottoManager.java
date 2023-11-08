package lotto;

import java.util.List;

public class LottoManager {

    Input input;
    Output output;
    List<Lotto> lottoList;
    int howManyLottos;


    public LottoManager(){
        input=new Input();
        output=new Output();
    }

    public void startLotto(){
        output.instructInputMoney();
        howManyLottos=input.getInput()/1000;
        output.showLottoPurchaseCount(howManyLottos);

        LottoGame lottoGame=new LottoGame();
        lottoList=lottoGame.generateLottos(howManyLottos);
        output.showPurchaseLottoNumber(lottoList);

        output.instructInputWinningNumbers();
        input.getWinningNumber();
        output.instructInputBonusNumber();
        input.getBonusNumber();
        System.out.println("end");
    }

}
