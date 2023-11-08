package lotto;

import java.util.List;

public class LottoGame {
    LottoRepository lottoRepository = new LottoRepository();

    public void start() {
        int num = LottoView.inputMoney()/1000;
        List<Lotto> randomLottos = LottoGenerator.generateLottos(num);
        lottoRepository.addLotto(randomLottos);

        LottoView.showLottos(lottoRepository);

        while(true){
            Lotto winningLotto = LottoView.inputWinningLotto();
            if(lottoRepository.setWinningLotto(winningLotto)){
                break;
            }
        }

        while(true) {
            int bonusNum = LottoView.inputBonusNumber();
            if(lottoRepository.setBonusNum(bonusNum)){
                break;
            }
        }

        LottoView.showStatus(lottoRepository);
    }
}
