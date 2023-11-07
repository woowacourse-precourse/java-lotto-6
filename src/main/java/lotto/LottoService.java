package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private static final int LIMIT_NUMBER = 45;
    private static final int PURCHASE_STANDARD = 1000;

    public int inputPurchaseAmount() {
        while (true) {
            String input = Console.readLine();
            try {
                containsNonNumericCharacters(input);
                isPurchaseAmountDivideBy1000(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Lotto> provideLotto(int lottoCnt) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCnt; i++) {
            lottos.add(new Lotto(new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6))));
        }
        return lottos;
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public Lotto inputWinningNumbers() {
        while (true) {
            String input = Console.readLine().trim();
            List<Integer> winningNumbers = new ArrayList<>();
            try {
                for (String number : input.split(",")) {
                    number = number.replaceAll("\\s", "");
                    validateOneNumber(number);
                    winningNumbers.add(Integer.parseInt(number));
                }
                return new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int inputBonusNumber(Lotto winningNumbers) {
        while (true) {
            String input = Console.readLine();
            try {
                validateOneNumber(input);
                isWinningNumbersContainBonusNumber(winningNumbers.getNumbers(), input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void validateOneNumber(String input) {
        containsNonNumericCharacters(input);
        isNumberOverLimit(input);
    }

    public void isWinningNumbersContainBonusNumber(List<Integer> winningNumbers, String bonusNumber) {
        if (winningNumbers.contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WITH_WINNING_NUMBERS.getMessage());
        }
    }

    public void containsNonNumericCharacters(String input) {
        if (!input.matches("[0-9\\s]+")) {
            throw new IllegalArgumentException(ErrorMessage.CONTAINS_NON_NUMERIC_CHARACTERS.getMessage());
        }
    }

    public void isPurchaseAmountDivideBy1000(String input) {
        if (Integer.parseInt(input) % PURCHASE_STANDARD > 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_NOT_DIVIDE_BY_1000.getMessage());
        }
    }

    public void isNumberOverLimit(String input) {
        if (Integer.parseInt(input) > LIMIT_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OVER_LIMIT.getMessage());
        }
    }
}
