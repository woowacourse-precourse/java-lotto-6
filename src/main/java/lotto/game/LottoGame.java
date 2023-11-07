package lotto.game;

import java.util.List;
import lotto.domain.AutomaticLottoStorage;
import lotto.domain.LottoStorage;
import lotto.domain.WinningLotto;
import lotto.util.LottoGameInputer;
import lotto.util.LottoGamePrinter;
import lotto.util.LottoProfitCalculator;

public class LottoGame {

    private LottoStorage lottoStorage;
    private AutomaticLottoStorage automaticLottoStorage;

    public void start () {
        inputLottoPurchaseAmount();
        printAutomaticLottoResults();
        createLottoStorageWithWinningNumbers();

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
    public List<Integer> inputWinningLottoNumbers() {
        LottoGamePrinter.println("당첨 번호를 입력해 주세요.");
        return LottoGameInputer.convertCommaSeparatedValuesToList();
    }
}
