package lotto;

import static java.util.Collections.emptyList;

import java.util.List;
import lotto.domain.Cost;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.view.InputView;

public class Input {
    private final StringConverter stringConverter;
    private final InputView inputView;

    public Input() {
        this.stringConverter = new StringConverter();
        this.inputView = new InputView();
    }

    public int cost() {
        Cost cost;
        do {
            cost = new Cost(inputView.inputBuyingCost());
        } while (!cost.isValid());

        return cost.getQuantity();
    }
    public Lotto winningNumberWithoutBonus() {
        List<Integer> winningNumbers;

        do{
            winningNumbers = stringConverter.convertToIntegerList(inputView.inputWinningNumbers());
        }while (winningNumbers.equals(emptyList()));

        return makeWinningLotto(winningNumbers);
    }

    private Lotto makeWinningLotto(List<Integer> winningNumbers) {
        Lotto lotto = new Lotto(winningNumbers);
        if (!lotto.isValid()) {
            winningNumberWithoutBonus();
        }
        return lotto;
    }


    public WinningLotto bonusNumber(Lotto winningLottoWithoutBonus) {
        WinningLotto winningLotto;

        do {
            int bonusNumber = inputView.inputBonusNumber();
            winningLotto = new WinningLotto(winningLottoWithoutBonus, bonusNumber);
        } while (!winningLotto.isValid());

        return winningLotto;
    }
}
