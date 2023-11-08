package lotto.controller;

import lotto.domain.Lotto;
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
        Lotto myLotto = userInputService.createLotto(); //사용자가 로또 넘버를 작성한 것을 토대로 로또 객체를 만든다.
//      List <Lotto> customerLotto = lottoService.createRandomLotto(num); //로또를 생성한다.

    }
}
