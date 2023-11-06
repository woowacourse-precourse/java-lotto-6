package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println(InputMessage.purchaseAmount);
        int result = inputPurchaseAmount();
        List<Lotto> lottos = createLottos(result);
    }

    public static int inputPurchaseAmount() {
        int result = validate(Console.readLine());
        if (result == -1) {
            inputPurchaseAmount();
        }
        return result;
    }

    public static int validate(String input) {
        try {
            checkNull(input);
            checkEmpty(input);
            int number = checkNumber(input);
            checkZero(number);
            checkUnit(number);
            return number;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public static void checkEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.REQUIRED_VALUE);
        }
    }

    public static int checkNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_NUMBER);
        }
    }

    public static void checkUnit(int purchaseAmount) {
        if (purchaseAmount % LottoNumbers.PURCHASE_AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_UNIT);
        }
    }

    public static void checkZero(int purchaseAmount) {
        if (purchaseAmount < LottoNumbers.PURCHASE_AMOUNT_MIN) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_ZERO);
        }
    }

    public static void checkNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessage.NULL);
        }
    }

    public Lotto createLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(LottoNumbers.START_LOTTO_NUMBER,
                LottoNumbers.END_LOTT0_NUMBER, LottoNumbers.COUNT));
    }

    public static List<Lotto> createLottos(int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        int count = purchaseAmount / LottoNumbers.PURCHASE_AMOUNT_UNIT;

        for (int i = 0; i < count; i++) {
            lottos.add(createLotto());
        }

        return lottos;
    }
}
