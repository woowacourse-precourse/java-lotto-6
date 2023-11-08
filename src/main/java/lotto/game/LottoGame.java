package lotto.game;

import java.util.List;
import lotto.common.PrintMessage;
import lotto.domain.AutomaticLottoStorage;
import lotto.domain.LottoRank;
import lotto.domain.LottoStorage;
import lotto.domain.WinningLotto;
import lotto.util.LottoGameInputer;
import lotto.util.LottoGamePrinter;

public class LottoGame {

    private LottoStorage lottoStorage;
    private AutomaticLottoStorage automaticLottoStorage;

    private LottoGame() {}

    public static LottoGame getInstance() {
        return new LottoGame();
    }

    public void start () {
        inputLottoPurchaseAmount();
        printAutomaticLottoResults();
        createLottoStorageWithWinningNumbers();
        printLottoWinningResultsAndLottoProfitRate();
    }

    // 구입 금액 입력
    public void inputLottoPurchaseAmount() {
        LottoGamePrinter.println(PrintMessage.PURCHASE_AMOUNT_PROMPT.getMessage());
        Integer amount = LottoGameInputer.inputToInteger();
        automaticLottoStorage = AutomaticLottoStorage.from(amount);
    }

    // 자동 로또 구매 목록 출력
    public void printAutomaticLottoResults() {
        automaticLottoStorage.showAutomaticLottosResult();
    }

    // 당첨 번호 입력
    public List<Integer> inputWinningLottoNumbers() {
        LottoGamePrinter.println(PrintMessage.WINNING_NUMBER_PROMPT.getMessage());
        return LottoGameInputer.convertCommaSeparatedValuesToList();
    }

    // 보너스 번호 입력
    public Integer inputWinningBonusNumber() {
        LottoGamePrinter.println(PrintMessage.BONUS_NUMBER_PROMPT.getMessage());
        return LottoGameInputer.inputToInteger();
    }

    // 당첨 번호 및 보너스 번호 WinningLotto 생성
    public WinningLotto createWinningLotto() {
        List<Integer> numbers = inputWinningLottoNumbers();
        Integer bonusNumber = inputWinningBonusNumber();
        return WinningLotto.of(numbers, bonusNumber);
    }

    // 당첨 번호와 함께 LottoStorage 생성
    public void createLottoStorageWithWinningNumbers() {
        WinningLotto winningLotto = createWinningLotto();
        lottoStorage = LottoStorage.of(automaticLottoStorage, winningLotto);
    }

    // 로또 당첨 내역 및 수익률 출력
    public void printLottoWinningResultsAndLottoProfitRate() {
        List<LottoRank> lottoRanks = lottoStorage.compareAllAutomaticLottoWithWinningNumbers();
        lottoStorage.showAllLottoRankResult(lottoRanks);
        lottoStorage.showLottoProfitRate(lottoRanks);
    }
}
