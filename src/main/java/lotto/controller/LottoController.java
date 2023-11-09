package lotto.controller;

import lotto.domain.LuckyLotto;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.service.UserInputService;
import lotto.service.LottoService;
import lotto.service.UserInputServiceImpl;

import java.util.List;

public class LottoController {
    UserInputService userInputService;
    LottoService lottoService;
    public LottoController(){
        userInputService = new UserInputServiceImpl();
        lottoService = new LottoService();
    }
    public void play(){
        int num = userInputService.payForLotto(); //사용자가 돈을 지불한다.
        List <Lotto> customerLotto = lottoService.createRandomLotto(num); //로또를 생성한다.
        LuckyLotto winningLotto = userInputService.createLotto(); //사용자가 로또 넘버를 작성한 것을 토대로 로또 객체를 만든다.
        List<Prize> prizes =lottoService.getPrizes(winningLotto,customerLotto); //로또 넘버와 비교한 카운트를 샌 것들을 가져온다.
        lottoService.printPrize(prizes);
        double rate= lottoService.caculateMoney(lottoService.decideCompentation(prizes),num);//수익률 결정을 위해 가장 높은 수익금 체크
        lottoService.printCaculate(rate);
//      List <Lotto> customerLotto = lottoService.createRandomLotto(num); //로또를 생성한다.

    }
}
