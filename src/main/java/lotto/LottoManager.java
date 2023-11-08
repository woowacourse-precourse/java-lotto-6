package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.common.Announcement;
import lotto.common.ConstraintNumber;
import lotto.common.ErrorMessage;
import lotto.common.ExceptionHandler;
import lotto.common.LottoNumberValidator;

public class LottoManager {

    private final List<Lotto> lottos;

    LottoManager() {
        lottos = new ArrayList<>();
    }

    public void purchaseLottos() {
        int amount = getAmount();
        for (int i = 0; i < amount / ConstraintNumber.PURCHASE_AMOUNT_UNIT.getValue(); i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45,
                ConstraintNumber.LOTTO_MAX_SIZE.getValue());
            this.lottos.add(new Lotto(randomNumbers));
        }
        Announcement.PURCHASE_LOTTOS.speak(lottos.size());
    }

    private int getAmount() {
        Announcement.INPUT_AMOUNT.speak();
        while (true) {
            try {
                int amount = parseInputToNumber(Console.readLine());
                validateAmountUnit(amount, ConstraintNumber.PURCHASE_AMOUNT_UNIT.getValue());
                return amount;
            } catch (IllegalArgumentException e) {
                ErrorMessage.printExceptionMessage(e);
            }
        }
    }

    private int parseInputToNumber(String input) throws IllegalArgumentException {
        LottoNumberValidator.validateNumeric(input);
        return Integer.parseInt(input);
    }

    private void validateAmountUnit(int amount, int unit) throws IllegalArgumentException {
        if (amount % unit != 0) {
            ExceptionHandler.throwIllegalArgumentException(ErrorMessage.INPUT_AMOUNT_INVALID_UNIT);
        }
    }
}
