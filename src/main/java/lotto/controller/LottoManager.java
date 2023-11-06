package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoAnswer;
import lotto.model.Lottos;
import lotto.model.PurchaseAmount;
import lotto.model.Rank;
import lotto.view.input.BonusNumberInput;
import lotto.view.input.Input;
import lotto.view.input.LottoAnswerInput;

public class LottoManager {

    private final static String DELIMITER = ",";

    private final Lottos lottos;
    private final LottoAnswer lottoAnswer;

    public LottoManager(PurchaseAmount purchaseAmount) {
        this.lottos = createLottos(purchaseAmount);
        this.lottoAnswer = createLottoAnswer();
    }

    private Lottos createLottos(PurchaseAmount purchaseAmount) {
        Lottos lottos = new Lottos(purchaseAmount);
        return lottos;
    }

    private LottoAnswer createLottoAnswer() {
        Lotto answer = readLotto();
        BonusNumber bonusNumber = readBonusNumber(answer);
        return new LottoAnswer(answer, bonusNumber);
    }

    private Lotto readLotto() {
        Input input = new LottoAnswerInput();
        String numbersInput = input.readLine();
        List<Integer> numbers = Arrays.stream(numbersInput.split(DELIMITER))
                .map(Integer::parseInt).toList();
        return new Lotto(numbers);
    }

    private BonusNumber readBonusNumber(Lotto answer) {
        Input input = new BonusNumberInput();
        BonusNumber bonusNumber;
        while (true) {
            try {
                String numberInput = input.readLine();
                bonusNumber = new BonusNumber(Integer.parseInt(numberInput));
                bonusNumberValidation(answer, bonusNumber);
                break;
            } catch (IllegalArgumentException ignore) {

            }
        }
        return bonusNumber;
    }

    private void bonusNumberValidation(Lotto answer, BonusNumber bonusNumber) {
        if (answer.isContainBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public List<Rank> calculateResults() {
        List<Rank> results = new ArrayList<>();

        for (Lotto lotto : lottos) {
            results.add(lottoAnswer.getRankOf(lotto));
        }

        return results;
    }
}
