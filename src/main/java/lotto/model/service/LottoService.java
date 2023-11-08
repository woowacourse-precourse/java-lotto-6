package lotto.model.service;

import lotto.model.domain.*;
import lotto.util.LottoGenerator;

public class LottoService {

    public Lottos makeLottoAndLottos(User user) {
        Lottos lottos = new Lottos();

        for (int i = 0; i < user.getHavingLottosCount(); i++) {
            Lotto lotto = new Lotto(LottoGenerator.generateRandomNumList());
            lottos.addNewLotto(lotto);
        }

        return lottos;
    }

    public int makeIdentifyNum(Lotto lotto, WinningNum winningNum, BonusNum bonusNum) {
        int identifyNum = 0;
        for (int o : winningNum.getWinningnum()) {
            if (lotto.getLotto().contains(o)) {
                identifyNum+=1;
            }
        }
        if (identifyNum == 5 && lotto.getLotto().contains(bonusNum.getBonusNum())) {
            identifyNum=10;
        }
        return identifyNum;
    }
}
