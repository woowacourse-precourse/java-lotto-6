package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {

    private int price;

    public void start() {
        try {
            priceInput();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            start();
        }
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(String input) {
        int price = numberFormatValidate(input);
        unitValidate(price);

        this.price = price;
    }

    public void priceInput() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        setPrice(input);
    }

    private int numberFormatValidate(String input) {
        int number;

        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[error] 숫자를 입력해주십시오.");
        }

        return number;
    }

    private void unitValidate (int price) {
        if (price < Const.priceUnit || price % Const.priceUnit != 0) {
            throw new IllegalArgumentException("[error] " + Const.priceUnitOutput + " 단위의 금액을 입력해주십시오.");
        }
    }

    public void printLottos(User user) {
        System.out.println(user.getLottoCount() + "개를 구매했습니다.");
        List<Lotto> lottos = user.getLottos();

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
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
            throw new IllegalArgumentException("[error] 숫자의 범위는 1~45 입니다.");
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
            throw new IllegalArgumentException("[error] 보너스 번호는 당첨 번호와 중복되지 않은 숫자여야 합니다.");
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

        String sb = Const.fifthPlaceCount + " " + Const.fifthPrize + " - " + user.getFifthPlace() + "개" +
                '\n' + Const.fourthPlaceCount + " " + Const.fourthPrize + " - " + user.getFourthPlace() + "개" +
                '\n' + Const.thirdPlaceCount + " " + Const.thirdPrize + " - " + user.getThirdPlace() + "개" +
                '\n' + Const.secondPlaceCount + " " + Const.secondPrize + " - " + user.getSecondPlace() + "개" +
                '\n' + Const.firstPlaceCount + " " + Const.firstPrize + " - " + user.getFirstPlace() + "개";

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
}
