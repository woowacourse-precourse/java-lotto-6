package lotto;

import java.util.List;

public class LottoGame {
    LottoRepository lottoRepository = new LottoRepository();

    public void start() {
        int num = LottoView.inputMoney()/1000;
        List<Lotto> randomLottos = LottoGenerator.generateLottos(num);
        lottoRepository.addLotto(randomLottos);

        LottoView.showLottos(lottoRepository);

        Lotto winningLotto = LottoView.inputWinningLotto();
        lottoRepository.setWinningLotto(winningLotto);

        int bonusNum = LottoView.inputBonusNumber();
        lottoRepository.setBonusNum(bonusNum);

        LottoView.showStatus(lottoRepository);
    }
}
