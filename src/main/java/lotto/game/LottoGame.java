package lotto.game;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.AutomaticLottoStorage;
import lotto.domain.LottoStorage;
import lotto.util.LottoGameInputer;
import lotto.util.LottoGamePrinter;

public class LottoGame {

    private LottoStorage lottoStorage;
    private AutomaticLottoStorage automaticLottoStorage;

    public void start () {
        Integer amount = inputLottoPurchaseAmount();
        automaticLottoStorage = new AutomaticLottoStorage(amount);
    }

    // 구입 금액 입력
    public Integer inputLottoPurchaseAmount() {
        LottoGamePrinter.println("구입금액을 입력해 주세요.");
        return LottoGameInputer.inputToInteger();
    }

    // 구매 목록 출력
    public void
    // 당첨 번호 입력

    // 보너스 번호 입력

    // 당첨 통계
    //  수익률 출력
}
