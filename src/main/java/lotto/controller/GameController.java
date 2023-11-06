package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoBuyer;
import lotto.domain.LottoManager;
import lotto.generator.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {

//    while (true) {
//        System.out.println("구입금액을 입력해 주세요.");
//        String stringPurchaseAmount = Console.readLine();
//
//        try {
//            return Integer.parseInt(stringPurchaseAmount);
//        } catch (NumberFormatException e) {
//            System.err.print("[ERROR] 올바른 입력이 아닙니다. ");
//        }
//    }
    LottoManager lottoManager = new LottoManager();

    public void run() {
        int lottoQuantity = lottoManager.isValidPurchaseAmount(InputView.requestLottoPurchaseAmount());

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
