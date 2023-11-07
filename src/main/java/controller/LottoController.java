package controller;

import constants.Grade;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.AnswerLotto;
import lotto.BonusNumber;
import lotto.Lotto;
import lotto.Money;
import lotto.PointCalculator;
import lotto.PointResult;
import utils.Parser;
import utils.RandomUtils;
import view.InputView;
import view.OutputView;

public class LottoController {

    private List<Lotto> lottos;
    private AnswerLotto answerLotto;
    private BonusNumber bonusNumber;
    private Money money;
    private final PointCalculator pointCalculator = new PointCalculator();

    public void run() {
        OutputView.printMoneyInputMessage();
        money = generateMoney();
        int lottoPurchaseCount = money.getLottoPurchaseCount();
        OutputView.printLottoPurchaseCount(lottoPurchaseCount);
        lottos = generateLottoWithCount(lottoPurchaseCount);

        //당첨 번호 입력
        OutputView.printAnswerLottoNumberInputMessage();
        answerLotto = new AnswerLotto(Parser.stringToIntegerList(InputView.inputAnswerLotto()));
        //보너스 번호 입력
        OutputView.printBonusNumberInputMessage();
        bonusNumber = new BonusNumber(Integer.parseInt(InputView.inputNaturalNumber()), answerLotto);

        // 당첨 통계
        OutputView.printLottoResultMessage();
        // --- 출력
        OutputView.printHorizontalRule();

        PointResult pointResult = new PointResult(getLottoResult(lottos));

        for (Grade grade : Grade.values()) {
            OutputView.printResult(grade, pointResult.getCountByGrade(grade));
        }

        OutputView.printEarningRate(pointResult.calculateEarningRate(money));
    }


    private List<Double> getLottoResult(List<Lotto> lottos) {
        List<Double> lottoResult = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottoResult.add(pointCalculator.calculateTotalPoint(lotto, answerLotto, bonusNumber));
        }
        return lottoResult;
    }

    private List<Lotto> generateLottoWithCount(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    private Lotto generateLotto() {
        List<Integer> randomLottoNumbers = RandomUtils.generateRandomLottoNumber().stream()
                .sorted()
                .collect(Collectors.toList());
        Lotto lotto = new Lotto(randomLottoNumbers);
        System.out.println(lotto.getGeneratedLottoString());
        return lotto;
    }

    private Money generateMoney() {
        return new Money(Integer.parseInt(InputView.inputNaturalNumber()));
    }

    private int getLottoPurchaseCount() {
        return generateMoney().getLottoPurchaseCount();
    }
}
