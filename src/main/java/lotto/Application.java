package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.ErrorCode.*;

public class Application {
    private static boolean[] isExistNumber;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입 금액을 입력해 주세요.");
        int times = purchaseLotto();
        System.out.println(times + "개를 구매했습니다.");
        List<Lotto> lottoList = issueLotto(times);

        System.out.println("당첨 번호를 입력해주세요.");
        Lotto winningLotto = drawLotto();
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = drawBonus();
        System.out.println("당첨 통계");
        System.out.println("---");
        int totalReward = award(winningLotto, bonusNumber, lottoList);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", 100.0 * totalReward / (times * 1000));
    }

    private static int award(Lotto winningLotto, int bonusNumber, List<Lotto> lottoList) {
        int[] countOfPrize = calculateResult(winningLotto, bonusNumber, lottoList);
        LottoRank[] ranks = LottoRank.values();
        int totalReward = 0;
        for (int i = 4; i >= 0; i--) {
            LottoRank rank = ranks[i];
            System.out.println(rank.description + " - " + countOfPrize[rank.prize] + "개");
            totalReward += (rank.reward * countOfPrize[rank.prize]);
        }
        return totalReward;
    }

    private static int[] calculateResult(Lotto winningLotto, int bonusNumber, List<Lotto> lottoList) {
        int[] countOfPrize = new int[7];
        for (Lotto lotto : lottoList) {
            LottoRank rank = lotto.getRank(winningLotto, bonusNumber);
            countOfPrize[rank.prize]++;
        }
        return countOfPrize;
    }

    private static int purchaseLotto() {
        int number = 0;
        while (number == 0) {
            try {
                number = purchase();
            } catch (RuntimeException e) {
                handleException(e);
            }
        }
        return number;
    }

    private static int purchase() throws IllegalArgumentException {
        int input = Integer.parseInt(Console.readLine());
        if (input % 1000 != 0)
            throw new IllegalArgumentException(PURCHASE_AMOUNT_ERROR.getMessage());
        return input / 1000;
    }

    private static Lotto drawLotto() {
        Lotto winningLotto = null;
        while (winningLotto == null) {
            try {
                winningLotto = getWinningLotto();
            } catch (RuntimeException e) {
                handleException(e);
            }
        }
        return winningLotto;
    }

    private static int drawBonus() {
        int bonusNumber = 0;
        while (bonusNumber == 0) {
            try {
                bonusNumber = getBonusNumber();
            } catch (RuntimeException e) {
                handleException(e);
            }
        }
        return bonusNumber;
    }

    private static Lotto getWinningLotto() {
        isExistNumber = new boolean[47];
        List<Integer> winningNumbers = new ArrayList<>();
        String[] input = Console.readLine().split(",");
        if (input.length != 6)
            throw new IllegalArgumentException(LOTTERY_SIZE_ERROR.getMessage());
        for (String s : input) {
            int number = Integer.parseInt(s);
            validateNumber(number);
            winningNumbers.add(number);
            isExistNumber[number] = true;
        }
        return new Lotto(winningNumbers);
    }

    private static void validateNumber(int number) {
        if (number < 1 || number > 45)
            throw new IllegalArgumentException(LOTTERY_NUMBER_RANGE_ERROR.getMessage());
        if (isExistNumber[number])
            throw new IllegalArgumentException(LOTTERY_NUMBER_DUPLICATED_ERROR.getMessage());
    }

    private static int getBonusNumber() {
        int number = Integer.parseInt(Console.readLine());
        validateNumber(number);
        isExistNumber[number] = true;
        return number;
    }

    private static List<Lotto> issueLotto(int number) {
        List<Lotto> lottoList = new ArrayList<>();
        while (lottoList.size() < number) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoList.add(lotto);
            lotto.printNumbers();
        }
        return lottoList;
    }

    private static void handleException(RuntimeException e) {
        System.out.println("[ERROR] " + e.getMessage());
    }
}
