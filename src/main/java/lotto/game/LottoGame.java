package lotto.game;

import lotto.domain.AutomaticLottoStorage;
import lotto.domain.LottoStorage;
import lotto.util.LottoGameInputer;
import lotto.util.LottoGamePrinter;

public class LottoGame {

    private LottoStorage lottoStorage;
    private AutomaticLottoStorage automaticLottoStorage;

    public void start () {
        inputLottoPurchaseAmount();
        printAutomaticLottoResults();

    }

    // 구입 금액 입력
    public void inputLottoPurchaseAmount() {
        LottoGamePrinter.println("구입금액을 입력해 주세요.");
        Integer amount = LottoGameInputer.inputToInteger();
        automaticLottoStorage = AutomaticLottoStorage.from(amount);
    }

    // 자동 로또 구매 목록 출력
    public void printAutomaticLottoResults() {
        automaticLottoStorage.showAutomaticLottosResult();
    }

    // 당첨 번호 입력
    public void inputWinningLotto() {

    }

    // 보너스 번호 입력
    public void inputBonusNumber() {

    }

    // 당첨 통계

    // 수익률 출력

}
