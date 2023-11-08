package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoAmount lottoAmount;
        do {
            System.out.println("구입금액을 입력해 주세요.");
            lottoAmount = checkMoneyValidate(Console.readLine());
        } while (lottoAmount.getMoney() == 0);
        System.out.println();
        System.out.println(lottoAmount.getTickets() + "개를 구매했습니다.");

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoAmount.getTickets(); i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }

        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();

        Lotto winningNumbers;
        do {
            System.out.println("당첨 번호를 입력해 주세요.");
            winningNumbers = winningNumbersValidate(Console.readLine());
        } while (winningNumbers == null);
        System.out.println();

        int bonusNumber = 0;
        do {
            System.out.println("보너스 번호를 입력해 주세요.");
            bonusNumber = bonusNumberValidate(Console.readLine(), winningNumbers);
        } while (bonusNumber == 0);
        System.out.println();

        System.out.println("당첨 통계");
        System.out.println("---");
        LottoResult lottoResult = new LottoResult();
        lottoResult.totalRanking(lottos, winningNumbers, bonusNumber);
        lottoResult.calculateRateOfReturn(lottos, winningNumbers, bonusNumber, lottoAmount.getMoney());
        System.out.println(lottoResult);
    }

    private static int bonusNumberValidate(String input, Lotto lotto) {
        int bonusNumber = 0;
        try {
            bonusNumber = isOnlyNumber(input);
            checkRange(bonusNumber);
            checkDuplicationWithBonus(lotto, bonusNumber);
        } catch (IllegalArgumentException e) {
            bonusNumber = 0;
            System.out.println(e.getMessage());
        }
        return bonusNumber;
    }

    private static void checkDuplicationWithBonus(Lotto lotto, int bonusNumber) {
        if (lotto.contains(bonusNumber))
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
    }

    private static void checkRange(int number) {
        if (number < 1 || number > 45)
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    private static LottoAmount checkMoneyValidate(String input) {
        LottoAmount money = new LottoAmount();
        try {
            money.setMoney(isOnlyNumber(input));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return money;
    }

    private static int isOnlyNumber(String input) {
        int number = 0;
        try {
            number = Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자로 입력해 주세요.");
        }
        return number;
    }

    private static Lotto winningNumbersValidate(String input) {
        Lotto lotto = null;
        try {
            lotto = new Lotto(checkInteger(input));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return lotto;
    }

    private static List<Integer> checkInteger(String input) {
        List<Integer> parseNumbers = new ArrayList<>();
        for (String number : List.of(input.split(","))) {
            int n = isOnlyNumber(number);
            parseNumbers.add(n);
        }
        return parseNumbers;
    }
}
