package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Player;
import lotto.view.ErrorMessage;
import lotto.view.LottoView;

import java.util.ArrayList;

public class LottoMakingController {
    private static final LottoView view = new LottoView();
    private final int MONEY_UNIT = 1000;
    private final int LOTTO_COUNT = 6;
    private int money;
    private int lottoCount;

    public void createLottoCount() {
        while (true) {
            try {
                String input = view.inputMoney();
                validateIsNumber(input);
                validateMoneyUnit(money);
                break;
            } catch (NumberFormatException e) {
                view.outputError(ErrorMessage.ERROR_NOT_NUMBER_MESSAGE.getValue());
            } catch (IllegalArgumentException e) {
                view.outputError(e.getMessage());
            }
        }
    }

    private void validateIsNumber(String number) throws NumberFormatException {
        money = Integer.parseInt(number);
    }

    private void validateMoneyUnit(int money) {
        if (money % MONEY_UNIT != 0)
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_THOUSAND_MESSAGE.getValue());
        lottoCount = money / MONEY_UNIT;
    }

    public ArrayList<Lotto> createLottos() {
        ArrayList<Lotto> lottos = new ArrayList<Lotto>();
        for (int i = 0; i < lottoCount; i++)
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        view.outputLottos(lottos, lottos.size());

        return lottos;
    }

}
