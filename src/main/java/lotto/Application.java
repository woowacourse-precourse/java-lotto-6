package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        int purchaseAmount = UserInput.getUserPurchaseAmount();

        LottoManager lottoManager = new LottoManager();

        // 구입금액에 따라 로또 번호를 발행함
        List<Lotto> lottoList = lottoManager.publishLotto(purchaseAmount);

        // 로또 번호 출력
        for(Lotto lotto : lottoList) {
            lotto.showLottoNumbers();
        }

        String arr[] = UserInput.getUserLottoNumbers();

        int bonusNumber = UserInput.getUserBonusNumber();

        lottoManager.setLottoWinnerNumber(arr, bonusNumber);

        lottoManager.checkWining(lottoList);

        lottoManager.showWiningStatics(purchaseAmount);
    }
}
