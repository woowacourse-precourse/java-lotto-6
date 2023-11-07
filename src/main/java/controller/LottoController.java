package controller;

import constants.Grade;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.AnswerLotto;
import lotto.Lotto;
import lotto.LottoNumber;
import lotto.Money;
import lotto.PointCalculator;
import lotto.PointResult;
import utils.Parser;
import utils.RandomUtils;
import view.InputView;
import view.OutputView;

public class LottoController {
    public void run() {
        Money money = generateMoney();
        PointResult pointResult = generatePointResult(money.getLottoPurchaseCount());
        printLottoResult(money, pointResult);
    }

    private PointResult generatePointResult(int lottoPurchaseCount) {
        List<Lotto> lottos = generateLottoWithCount(lottoPurchaseCount);
        AnswerLotto answerLotto = generateAnswerLotto();
        List<Double> lottoPointResult = getLottoPointResult(lottos, answerLotto);
        return new PointResult(lottoPointResult);
    }

    private List<Lotto> generateLottoWithCount(int count) {
        OutputView.printLottoPurchaseCount(count);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    private Lotto generateLotto() {
        List<LottoNumber> randomLottoNumbers = RandomUtils.generateRandomLottoNumber().stream()
                .sorted()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
        Lotto lotto = new Lotto(randomLottoNumbers);
        System.out.println(lotto.getGeneratedLottoString());
        return lotto;
    }

    private Money generateMoney() {
        OutputView.printMoneyInputMessage();
        return new Money(Integer.parseInt(InputView.inputNaturalNumber()));
    }

    private AnswerLotto generateAnswerLotto() {
        OutputView.printAnswerLottoNumberInputMessage();
        List<LottoNumber> lottoNumbers = Parser.stringToLottoNumbers(InputView.inputAnswerLotto());
        LottoNumber bonusNumber = createBonusNumber();
        return new AnswerLotto(lottoNumbers, bonusNumber);
    }

    private LottoNumber createBonusNumber() {
        OutputView.printBonusNumberInputMessage();
        return LottoNumber.of(Integer.parseInt(InputView.inputNaturalNumber()));
    }

    private List<Double> getLottoPointResult(List<Lotto> lottos, AnswerLotto answerLotto) {
        PointCalculator pointCalculator = new PointCalculator();
        List<Double> lottoPointResult = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottoPointResult.add(pointCalculator.calculateTotalPoint(lotto, answerLotto));
        }
        return lottoPointResult;
    }

    private void printLottoResult(Money money, PointResult pointResult) {
        OutputView.printLottoResultMessage();
        OutputView.printHorizontalRule();
        for (Grade grade : Grade.values()) {
            OutputView.printResult(grade, pointResult.getCountByGrade(grade));
        }
        OutputView.printEarningRate(pointResult.calculateEarningRate(money));
    }
}
