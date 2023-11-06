package lotto;

import java.util.List;

public class LottoGame {
    LottoRepository lottoRepository = new LottoRepository();

    public void start() {
        int money = LottoView.inputMoney();
        List<Lotto> randomLottos = LottoGenerator.generateLottos(money);
        lottoRepository.addLotto(randomLottos);
        //함수로 묶어서 각 단계를 처리
        LottoView.showLottos(lottoRepository);

        Lotto winningLotto = LottoView.inputWinningLotto();
        lottoRepository.setWinningLotto(winningLotto);

        int bonusNum = LottoView.inputBonusNumber();
        lottoRepository.setBonusNum(bonusNum);

        LottoView.showStatus(lottoRepository);
    }
}
