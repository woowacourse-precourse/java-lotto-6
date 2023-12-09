package lotto.controller;

import lotto.domain.LuckyLotto;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.view.InputView;

import java.util.List;

public class LottoController {
    InputView inputView;
    lotto.service.LottoController lottoController;
    public LottoController(){
        inputView = new InputView();
        lottoController = new lotto.service.LottoController();
    }
    public LuckyLotto createLotto(List<Integer> inputLotto,int bonusNum) {
        Lotto lotto = new Lotto(inputLotto);
        return new LuckyLotto(lotto,bonusNum);
    }
    public void play(){
        int num = inputView.payForLotto(); //사용자가 돈을 지불한다.
        List <Lotto> customerLotto = lottoController.createRandomLotto(num); //로또를 생성한다.
        LuckyLotto winningLotto = createLotto(inputView.userInputLottoNum(), inputView.inputBonusNum()); //사용자가 로또 넘버를 작성한 것을 토대로 로또 객체를 만든다.
        List<Prize> prizes = lottoController.getPrizes(winningLotto,customerLotto); //로또 넘버와 비교한 카운트를 샌 것들을 가져온다.
        lottoController.printPrize(prizes);
        double rate= lottoController.caculateMoney(lottoController.decideCompentation(prizes),num);//수익률 결정을 위해 가장 높은 수익금 체크
        lottoController.printCaculate(rate);
//      List <Lotto> customerLotto = lottoService.createRandomLotto(num); //로또를 생성한다.

    }
}
