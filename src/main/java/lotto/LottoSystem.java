package lotto;

import lotto.constant.LottoConstant;
import lotto.constant.RottoResult;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoSystem {

    private final static OutputView outputView = new OutputView();
    private final static InputView inputView = new InputView();

    public static void start() {
        Money money = inputView.inputLottoPrice();

        List<Lotto> lottos = buyLottos(money);

        outputView.outputLottoTickets(money.calculateLottoSize(), lottos);

        CalculateLotto answerLotto = inputView.inputWinningNumber();
        BonusNumber bonusNumber = inputView.inputBonusNumber();
        List<Integer> includeNumbers = isCheckincludeNumbers(answerLotto, lottos, bonusNumber);

        List<Integer> result = calculateLottoResult(includeNumbers);

        outputView.outputLottoResult(result);
        outputView.outputRateOfReturn(calculateBill(result,money));
    }

    private static List<Integer> initArrayList() {
        List<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < LottoConstant.LENGTH.getNumber(); i++) {
            arrayList.add(0);
        }
        return arrayList;
    }

    private static List<Lotto> buyLottos(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoSize = money.calculateLottoSize();
        for (int i = 0; i < money.calculateLottoSize(); i++) {
            lottos.add(new Lotto(Random.generate()));
        }

        return lottos;
    }

    private static List<Integer> isCheckincludeNumbers(CalculateLotto answerLotto, List<Lotto> lottos, BonusNumber bonusNumber) {
        List<Integer> includeNumbers = new ArrayList<>();
        for (int i = 0; i < lottos.size(); i++) {
            includeNumbers.add(answerLotto.isCheckedLottoAnswer(lottos.get(i), bonusNumber.getBonusNumber()));
        }
        return includeNumbers;
    }

    private static List<Integer> calculateLottoResult(List<Integer> includeNumbers){
        List<Integer> result = initArrayList();
        for (int i = 0; i < includeNumbers.size(); i++) {
            if (includeNumbers.get(i) >= 3) {
                int index = RottoResult.getIndex(includeNumbers.get(i));
                result.add(index, result.get(index) + 1);
            }
        }
        return result;
    }

    private static double calculateBill(List<Integer> result, Money money){
        return (RottoResult.calculateAmout(result) / money.getPrice()) * 100;
    }
}
