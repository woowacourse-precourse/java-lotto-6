package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {

    public static int priceInput(String input) {
        int price = numberFormatValidate(input);
        unitValidate(price);

        return price;
    }

    private static int numberFormatValidate(String input) {
        int number;

        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주십시오.");
        }

        return number;
    }

    private static void unitValidate(int price) {
        if (price < Const.PRICE_UNIT || price % Const.PRICE_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] " + Const.PRICE_UNIT_OUTPUT + " 단위의 금액을 입력해주십시오.");
        }
    }

    public static Lotto createUserNumbers(String[] splitNumbers) {
        List<Integer> userNumbers = new ArrayList<>();

        for (String splitNumber : splitNumbers) {
            int number = numberFormatValidate(splitNumber);
            arrangeValidate(number);

            userNumbers.add(number);
        }

        return Lotto.createUserNumbers(userNumbers);
    }

    private static void arrangeValidate(int number) {
        if (Const.LOTTO_MAX_NUMBER > number || Const.LOTTO_MIN_NUMBER < number) {
            throw new IllegalArgumentException("[ERROR] 숫자의 범위는 1~45 입니다.");
        }
    }

    public static int bonusNumberInput(String input, List<Integer> userCreatedLotto) {
        int bonusNumber = numberFormatValidate(input);
        arrangeValidate(bonusNumber);

        if (userCreatedLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않은 숫자여야 합니다.");
        }

        return bonusNumber;
    }

    public static void printWinningResult(User user) {
        List<Lotto> purchasedLottos = user.getLottos();
        int bonusNumber = user.getBonusNumber();

        for (Lotto lotto : purchasedLottos) {
            countMatchingNumbers(user, lotto, bonusNumber);
        }

        System.out.println("당첨 통계");
        System.out.println("---");

        String result = LottoResult.FIFTH_PLACE_COUNT.getDesc() + user.getFifthPlace() + "개" + '\n' +
                LottoResult.FOURTH_PLACE_COUNT.getDesc() + user.getFourthPlace() + "개" + '\n' +
                LottoResult.THIRD_PLACE_COUNT.getDesc() + user.getThirdPlace() + "개" + '\n' +
                LottoResult.SECOND_PLACE_COUNT.getDesc() + user.getSecondPlace() + "개" + '\n' +
                LottoResult.FIRST_PLACE_COUNT.getDesc() + user.getFirstPlace() + "개";

        System.out.println(result);
    }

    private static void countMatchingNumbers(User user, Lotto purchasedLotto, int bonusNumber) {
        int count = 0;
        boolean bonusHit = false;

        for (Integer lotto : user.getUserLotto().getNumbers()) {
            if (purchasedLotto.getNumbers().contains(lotto)) {
                count++;
            }
        }
        if (purchasedLotto.getNumbers().contains(bonusNumber)) {
            count++;
            bonusHit = true;
        }

        countScore(user, count, bonusHit);
    }

    private static void countScore(User user, int count, boolean bonusHit) {
        user.setFifthPlace(count);
        user.setFourthPlace(count);
        user.setThirdPlace(count);
        user.setSecondPlace(count, bonusHit);
        user.setFirstPlace(count);
    }

    public static void getYield(User user, int price) {
        int total = user.getFifthPlace() * Const.FIFTH_PRIZE
                + user.getFourthPlace() * Const.FOURTH_PRIZE
                + user.getThirdPlace() * Const.THIRD_PRIZE
                + user.getSecondPlace() * Const.SECOND_PRIZE
                + user.getFirstPlace() * Const.FIRST_PRIZE;

        double yield = Math.round(((double) total / price) * 100 * 100.0) / 100.0;
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }
}
