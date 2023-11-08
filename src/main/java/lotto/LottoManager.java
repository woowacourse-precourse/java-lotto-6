package lotto;

import java.util.List;

public class LottoManager {

    Input input;
    Output output;
    List<Lotto> lottoList;
    int howManyLottos;
    List<Integer> winningNumbers;
    int bonusNumber;

    public LottoManager(){
        input=new Input();
        output=new Output();
    }

    public void startLotto(){

        // 얼마로 로또 살지
        output.instructInputMoney();
        howManyLottos=input.getInput()/1000;
        output.showLottoPurchaseCount(howManyLottos);

        // 개수에 맞게 로또 번호 생성
        LottoGame lottoGame=new LottoGame();
        lottoList=lottoGame.generateLottos(howManyLottos);
        output.showPurchaseLottoNumber(lottoList);

        // 당첨 번호
        output.instructInputWinningNumbers();
        winningNumbers=input.getWinningNumber();
        output.instructInputBonusNumber();
        bonusNumber=input.getBonusNumber();

        // 당첨 로직

        /*
        3개 일치 (5,000원) - 1개
        4개 일치 (50,000원) - 0개
        5개 일치 (1,500,000원) - 0개
        5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
        6개 일치 (2,000,000,000원) - 0개

         */
    }

}
