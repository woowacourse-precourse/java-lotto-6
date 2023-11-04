package lotto;

import camp.nextstep.edu.missionutils.Console;

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
        if (price < Const.priceUnit || price % Const.priceUnit != 0) {
            throw new IllegalArgumentException("[ERROR] " + Const.priceUnitOutput + " 단위의 금액을 입력해주십시오.");
        }
    }

    public Lotto createUserNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] splitNumbers = Console.readLine().replaceAll(" ", "").split(",");

        try {
            return createLotto(splitNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            return createUserNumbers();
        }
    }

    public Lotto createLotto(String[] splitNumbers) {
        List<Integer> userNumbers = new ArrayList<>();

        for (String splitNumber : splitNumbers) {
            int number = numberFormatValidate(splitNumber);
            arrangeValidate(number);

            userNumbers.add(number);
        }

        return Lotto.createUserNumbers(userNumbers);
    }

    private void arrangeValidate(int number) {
        if (Const.winningRangeStartNumber > number || Const.winningRangeEndNumber < number) {
            throw new IllegalArgumentException("[ERROR] 숫자의 범위는 1~45 입니다.");
        }
    }

    public void bonusNumberInput(User user) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();

        try {
            createBonusNumber(input, user);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            bonusNumberInput(user);
        }

    }

    public void createBonusNumber(String input, User user) {
        int number = numberFormatValidate(input);
        duplicateWithLotto(number, user);
        arrangeValidate(number);
        user.setBonusNumber(number);
    }

    private void duplicateWithLotto(int number, User user) {
        List<Integer> numbers = user.getUserLotto().getNumbers();

        if (numbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않은 숫자여야 합니다.");
        }
    }

    public void printWinningResult(User user) {
        List<Lotto> purchasedLottos = user.getLottos();
        int bonusNumber = user.getBonusNumber();

        for (Lotto lotto : purchasedLottos) {
            countMatchingNumbers(user, lotto, bonusNumber);
        }

        System.out.println("당첨 통계");
        System.out.println("---");

        String sb = Const.fifthPlaceCount + " (" + String.format("%,d", Const.fifthPrize) + "원" + ") - " + user.getFifthPlace() + "개" +
                '\n' + Const.fourthPlaceCount + " (" + String.format("%,d", Const.fourthPrize) + "원" + ") - " + user.getFourthPlace() + "개" +
                '\n' + Const.thirdPlaceCount + " (" + String.format("%,d", Const.thirdPrize) + "원" + ") - " + user.getThirdPlace() + "개" +
                '\n' + Const.secondPlaceCount + " (" + String.format("%,d", Const.secondPrize) + "원" + ") - " + user.getSecondPlace() + "개" +
                '\n' + Const.firstPlaceCount + " (" + String.format("%,d", Const.firstPrize) + "원" + ") - " + user.getFirstPlace() + "개";

        System.out.println(sb);
    }

    private void countMatchingNumbers(User user, Lotto purchasedLotto, int bonusNumber) {
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

    private void countScore(User user, int count, boolean bonusHit) {
        user.setFifthPlace(count);
        user.setFourthPlace(count);
        user.setThirdPlace(count);
        user.setSecondPlace(count, bonusHit);
        user.setFirstPlace(count);
    }

    public void getYield(User user, int price) {
        int total = user.getFifthPlace() * Const.fifthPrize
                + user.getFourthPlace() * Const.fourthPrize
                + user.getThirdPlace() * Const.thirdPrize
                + user.getSecondPlace() * Const.secondPrize
                + user.getFirstPlace() * Const.firstPrize;

        double yield = Math.round(((double) total / price) * 100 * 100.0) / 100.0;
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }
}
