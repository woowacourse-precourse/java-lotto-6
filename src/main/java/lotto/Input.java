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
        try {
            Cost cost = new Cost(inputView.inputBuyingCost());
            return cost.getQuantity();
        } catch (IllegalArgumentException e) {
            return cost();
        }
    }
    public Lotto winningNumberWithoutBonus() {
        List<Integer> winningNumbers;

        do{
            winningNumbers = stringConverter.convertToIntegerList(inputView.inputWinningNumbers());
        }while (winningNumbers.equals(emptyList()));

        return makeWinningLotto(winningNumbers);
    }

    private Lotto makeWinningLotto(List<Integer> winningNumbers) {
        Lotto lotto;
        try {
            lotto = new Lotto(winningNumbers);
        } catch (IllegalArgumentException e) {
            lotto = winningNumberWithoutBonus();
        }
        return lotto;
    }


    public WinningLotto bonusNumber(Lotto winningLottoWithoutBonus) {
        WinningLotto winningLotto;
        try {
            int bonusNumber = inputView.inputBonusNumber();
            winningLotto = new WinningLotto(winningLottoWithoutBonus, bonusNumber);
        } catch (IllegalArgumentException e) {
            winningLotto = bonusNumber(winningLottoWithoutBonus);
        }
        return winningLotto;
    }
}
