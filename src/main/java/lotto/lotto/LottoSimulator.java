package lotto.lotto;

import java.util.List;
import lotto.input.InputManager;
import lotto.output.OutputManager;
import lotto.simulation.LottoConstant;

public final class LottoSimulator {
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoSimulator(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public void start() {
        int lottoMoney = getLottoMoney();
        int lottoCount = calculateLottoCount(lottoMoney);
        List<Lotto> lottos = generateLottos(lottoCount);
        printLottos(lottos);

        List<Integer> lottoAnswerNumbers = getLottoAnswers();
        int bonusNumber = getBonusNumber(lottoAnswerNumbers);
        LottoAnswer lottoAnswer = makeLottoAnswer(lottoAnswerNumbers, bonusNumber);

        List<LottoResult> lottoResults = calculateLottoResults(lottos, lottoAnswer);
        LottoStatus lottoStatus = calculateLottoStatus(lottoMoney, lottoResults);
        printLottoStatus(lottoStatus);
    }

    private void printLottoStatus(LottoStatus lottoStatus) {
        OutputManager.print(lottoStatus);
    }

    private LottoStatus calculateLottoStatus(int lottoMoney, List<LottoResult> lottoResults) {
        LottoStatus lottoStatus = new LottoStatus(lottoMoney);
        lottoResults.forEach(lottoStatus::insert);
        return lottoStatus;
    }

    private List<LottoResult> calculateLottoResults(List<Lotto> lottos, LottoAnswer lottoAnswer) {
        return lottos.stream()
                .map(lotto -> lotto.calcLottoResult(lottoAnswer))
                .toList();
    }

    private LottoAnswer makeLottoAnswer(List<Integer> lottoAnswerNumbers, int bonusNumber) {
        return new LottoAnswer(lottoAnswerNumbers, bonusNumber);
    }

    private int getBonusNumber(List<Integer> lottoAnswerNumbers) {
        OutputManager.printBonusNumberInputGuide();
        return InputManager.getBonusNumber(lottoAnswerNumbers);
    }

    private List<Integer> getLottoAnswers() {
        OutputManager.printAnswerNumbersInputGuide();
        return InputManager.getLottoNumbers();
    }

    private void printLottos(List<Lotto> lottos) {
        String lottosPrintedString = LottoPrinter.printAll(lottos);
        OutputManager.print(lottosPrintedString);
    }

    private List<Lotto> generateLottos(int lottoCount) {
        return LottoGenerator.generate(lottoNumberGenerator, lottoCount);
    }

    private int calculateLottoCount(int lottoMoney) {
        return lottoMoney / LottoConstant.LOTTO_PRICE;
    }

    private int getLottoMoney() {
        OutputManager.printLottoBuyMoneyInputGuide();
        return InputManager.getLottoMoney();
    }
}
