package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoBuyer;
import lotto.generator.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {

    public void run() {
        int lottoPurchaseAmount = InputView.requestLottoPurchaseAmount();

        int lottoQuantity = lottoPurchaseAmount / 1000; // 구입금액을 몇장인지 변환해주는 기능이 필요함.

        List<Lotto> lottoList = new ArrayList<>();
        for (int i=0; i<lottoQuantity; i++) {
            List<Integer> lottoNumbers = LottoGenerator.generateLottoNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            lottoList.add(lotto);
        }

        LottoBuyer lottoBuyer = new LottoBuyer(lottoQuantity, lottoList);

        OutputView.announceLottoPurchaseQuantity(lottoBuyer.getPurchaseQuantity());
        OutputView.announceMultipleLottoNumbers(lottoBuyer.getLottoTickets());
    }
}
