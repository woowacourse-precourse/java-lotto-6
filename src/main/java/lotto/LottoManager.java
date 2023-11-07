package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.common.Announcement;
import lotto.common.Constraint;
import lotto.common.ErrorMessage;

public class LottoManager {

    private final List<Lotto> lottos;

    LottoManager() {
        lottos = new ArrayList<>();
    }

    public void purchaseLottos() {
        Announcement.INPUT_AMOUNT.speak();
        int amount = getAmount();
        for (int i = 0; i < amount / 1000; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, Constraint.LOTTO_MAX_SIZE.getValue());
            this.lottos.add(new Lotto(randomNumbers));
        }
        Announcement.PURCHASE_LOTTOS.speak(lottos.size());
    }

    private int getAmount() {
        while (true) {
            try {
                String input = Console.readLine();
                validateNumericInput(input);
                int amount = Integer.parseInt(input);
                validateInputAmountUnit(amount);
                return amount;
            } catch (IllegalArgumentException e) {
                ErrorMessage.printExceptionMessage(e);
            }
        }
    }

    private void validateNumericInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_AMOUNT_NOT_NUMERIC.getMessage());
        }
    }

    private void validateInputAmountUnit(int input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_AMOUNT_INVALID_UNIT.getMessage());
        }
    }
}
