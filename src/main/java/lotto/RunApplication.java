package lotto;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class RunApplication {

    private final static Scanner scanner =  new Scanner(System.in);

    public void run() {
        // 로또 구매비용과 당첨비용, 보너스 번호 입력
        int costOfLotto = getCostOfLotto();
        Lotto lotto = getLottoNumbers();
        int bonus = getBonus(lotto);


    }

    private int getCostOfLotto() {
        int cost = 0;
        try {
            cost = getCostOfLottoWithChainedException();
        } catch (IllegalArgumentException e) {
            getCostOfLotto();
        }

        return cost;
    }

    /**
     * 위에 메서드랑 다르게 try안에서 return해도 문제가 없네?
     */
    private int getCostOfLottoWithChainedException() throws IllegalArgumentException {
        try {
            int cost = scanner.nextInt();
            if (cost % 1000 != 0) {
                System.out.println(ExceptionMessage.로또_구입_비용_천원단위가아닌경우);
                throw new IllegalArgumentException();
            }
            return cost;
        } catch (InputMismatchException ime) {
            System.out.println(ExceptionMessage.로또_구입비용_숫자가아닐때);
            throw new IllegalArgumentException(ime);
        }
    }

    /**
     * 당첨 번호를 1에서 45 사이의 값을 확인하는 메서드를
     * isNumberIn1And45 말고 더 좋은 이름은 없을까?
     */
    private Lotto getLottoNumbers() {
        Lotto lotto = null;
        try {
            List<String> numbers = Arrays.asList(scanner.next().split(","));
            lotto = new Lotto(numbers.stream().map(Integer::parseInt).toList());
            if (isNumberIn1And45(lotto)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ExceptionMessage.당첨번호_1_45_사이가아닌경우);
            getLottoNumbers();
        }

        return lotto;
    }

    private static boolean isNumberIn1And45(Lotto lotto) {
        return lotto.getNumbers().stream().anyMatch(number -> number < 1 || 45 < number);
    }

    private int getBonus(Lotto lotto) {
        int bonus = 0;
        try {
            bonus = getBonusWithChainedException();
            if (bonus < 1 || 45 < bonus) {
                System.out.println(ExceptionMessage.보너스번호가_숫자가아닐때);
                throw new IllegalArgumentException();
            }
            isNotDuplicateNumberWithLotto(lotto, bonus);
        }  catch (IllegalArgumentException iae) {
            return getBonus(lotto);
        }

        return bonus;
    }

    private int getBonusWithChainedException() throws IllegalArgumentException {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println(ExceptionMessage.보너스번호가_숫자가아닐때);
            throw new IllegalArgumentException(ime);
        }
    }

    private void isNotDuplicateNumberWithLotto(Lotto lotto, int bonus) throws IllegalArgumentException {
        for (Integer number : lotto.getNumbers()) {
            if (number.equals(bonus)) {
                System.out.println(ExceptionMessage.보너스번호_중복);
                throw new IllegalArgumentException();
            }
        }
    }
}
