package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.UserInputService;
import lotto.service.RandomLottoService;

import java.util.List;

public class LottoController {
    UserInputService userInputService;
    RandomLottoService randomLottoService;
    LottoController(){
    }
    void play(){
        List <Lotto> lottos = randomLottoService.createRandomLotto(userInputService.payForLotto());//사용자가 지불한 돈으로 로또를 산다.
        Lotto myLotto = userInputService.createLotto(); //사용자가 로또 넘버를 작성한 것을 토대로 로또 객체를 만든다.

    }
}
