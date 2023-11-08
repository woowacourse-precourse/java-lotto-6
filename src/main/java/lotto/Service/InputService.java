package lotto.Service;

import lotto.Domain.GameInfo;
import lotto.Domain.Lotto;
import lotto.Util.Validation;
import lotto.View.InputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.Util.LottoEnum.LOTTO_PRICE;
import static lotto.Util.LottoNumberCreator.createNumbers;

public class InputService {
    private final InputView inputView = new InputView();
    private int amount = -1;
    private int bonusNumber = -1;
    private List<Integer> winnerNumbers;

    public List<Lotto> createLottoTickets() {
        while (true) {
            try {
                amount = inputView.getPurchaseAmount();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return createLotto();
    }

    private List<Lotto> createLotto() {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Lotto lotto = new Lotto(createNumbers());
            lottoList.add(lotto);
        }
        return lottoList;
    }

    public GameInfo createGameInfo() {
        while (true) {
            try {
                winnerNumbers = inputView.getWinnerNumbers();
                bonusNumber = inputView.getBonusNumber();
                Validation.duplicationCheck(winnerNumbers, bonusNumber);
                break;
            } catch (Exception e) {
                System.out.printf(e.getMessage());
            }
        }
        return new GameInfo(winnerNumbers, bonusNumber, amount * LOTTO_PRICE.getValue());
    }
}
