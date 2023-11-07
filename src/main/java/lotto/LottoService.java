package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.ErrorCode.*;

public class LottoService {

    public void award(Lotto winningLotto, int bonusNumber, List<Lotto> lottoList) {
        int[] countOfPrize = new int[7];
        float returnRatio = calculateResult(winningLotto, bonusNumber, lottoList, countOfPrize);

        LottoRank[] ranks = LottoRank.values();
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = 4; i >= 0; i--) {
            LottoRank rank = ranks[i];
            System.out.println(rank.description + " - " + countOfPrize[rank.prize] + "개");
        }
        System.out.printf("총 수익률은 %.1f%%입니다.\n", 100.0 * returnRatio);
    }

    public float calculateResult(Lotto winningLotto, int bonusNumber, List<Lotto> lottoList, int[] countOfPrize) {
        int totalReward = 0;
        for (Lotto lotto : lottoList) {
            LottoRank rank = lotto.getRank(winningLotto, bonusNumber);
            countOfPrize[rank.prize]++;
            totalReward += rank.reward;
        }
        return (float) totalReward / (lottoList.size() * 1000);
    }

    public int purchaseLotto() {
        System.out.println("구입 금액을 입력해 주세요.");
        int number = 0;
        while (number == 0) {
            try {
                number = purchase(Console.readLine());
            } catch (IllegalArgumentException e) {
                handleIllegalArgumentException(e);
            }
        }
        System.out.println(number + "개를 구매했습니다.");
        return number;
    }

    public int purchase(String input) {
        int number = Integer.parseInt(input);
        if (number % 1000 != 0)
            throw new IllegalArgumentException(PURCHASE_AMOUNT_ERROR.getMessage());
        return number / 1000;
    }

    public Lotto drawLotto() {
        System.out.println("당첨 번호를 입력해주세요.");
        Lotto winningLotto = null;
        while (winningLotto == null) {
            try {
                winningLotto = getWinningLotto(Console.readLine());
            } catch (IllegalArgumentException e) {
                handleIllegalArgumentException(e);
            }
        }
        return winningLotto;
    }

    public int drawBonus(Lotto winningLotto) {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = 0;
        while (bonusNumber == 0) {
            try {
                bonusNumber = getBonusNumber(Console.readLine(), winningLotto);
            } catch (IllegalArgumentException e) {
                handleIllegalArgumentException(e);
            }
        }
        return bonusNumber;
    }

    public Lotto getWinningLotto(String input) {
        List<Integer> winningNumbers = new ArrayList<>();
        String[] strings = input.split(",");

        for (String s : strings) {
            int number = Integer.parseInt(s);
            validateNumber(number);
            winningNumbers.add(number);
        }
        return new Lotto(winningNumbers);
    }

    private void validateNumber(int number) {
        if (number < 1 || number > 45)
            throw new IllegalArgumentException(LOTTERY_NUMBER_RANGE_ERROR.getMessage());
    }

    public int getBonusNumber(String input, Lotto lotto) {
        int number = Integer.parseInt(input);
        validateNumber(number, lotto);
        return number;
    }

    private void validateNumber(int number, Lotto lotto) {
        if (number < 1 || number > 45)
            throw new IllegalArgumentException(LOTTERY_NUMBER_RANGE_ERROR.getMessage());
        if (lotto.isNumberExisted(number))
            throw new IllegalArgumentException(LOTTERY_NUMBER_DUPLICATED_ERROR.getMessage());
    }

    public List<Lotto> issueLotto(int number) {
        List<Lotto> lottoList = new ArrayList<>();
        while (lottoList.size() < number) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoList.add(lotto);
            lotto.printNumbers();
        }
        return lottoList;
    }

    private void handleIllegalArgumentException(IllegalArgumentException e) {
        System.out.println("[ERROR] " + e.getMessage());
    }
}
