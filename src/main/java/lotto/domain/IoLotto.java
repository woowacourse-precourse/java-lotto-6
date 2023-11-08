package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IoLotto {

    public int inputMoney() {
        int money = 0;
        boolean validInput = false;
        System.out.println("구입금액을 입력해 주세요.");
        while (!validInput) {
            try {
                String input = Console.readLine();
                validateMoney(input);
                validInput = true;
                money = Integer.parseInt(input);

            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 구입 금액은 1000원 단위로 입력해주세요.");
                System.out.println("구입금액을 입력해 주세요.");
            }
        }
        return money;
    }

    public void validateMoney(String input) {
        int money = Integer.parseInt(input);
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public List<Lotto> purchaseLotto(int money) {
        int numberOfTickets = money / 1000;
        System.out.println(numberOfTickets + "개를 구매했습니다.");
        List<Lotto> purchasedLottos = new ArrayList<>();

        for (int i = 0; i < numberOfTickets; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lottoNumbers);
            purchasedLottos.add(new Lotto(lottoNumbers));
            System.out.println(lottoNumbers);
        }
        return purchasedLottos;
    }

    public int inputBonusNumber() {
        int bonusNumber = 0;
        boolean validInput = false;
        System.out.println("보너스 번호를 입력해 주세요.");
        while (!validInput) {
            try {
                String input = Console.readLine();
                bonusNumber = Integer.parseInt(input);
                validateBonusNumber(bonusNumber);
                validInput = true;

            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
                System.out.println("보너스 번호를 입력해 주세요.");
            }
        }
        return bonusNumber;
    }

    public void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException();
        }
    }

    public void checkResult(Lotto purchasedLotto, int bonusNumber) {
        List<Integer> winningNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        int matchCount = purchasedLotto.countMatchingNumbers(winningNumbers);
        boolean hasBonusNumber = purchasedLotto.getNumbers().contains(bonusNumber);

        System.out.println("\n당첨 통계");
        System.out.println("---");

        int[] prizeMoney = {5000, 50000, 1500000, 30000000, 2000000000};
        String[] prizeNames = {"3개 일치 (5,000원)", "4개 일치 (50,000원)", "5개 일치 (1,500,000원)",
                "5개 일치, 보너스 볼 일치 (30,000,000원)", "6개 일치 (2,000,000,000원)"};

        for (int i = 0; i < prizeMoney.length; i++) {
            if (matchCount == i) {
                System.out.println(prizeNames[i] + " - " + matchCount + "개");
            }
        }

        int totalPrize = prizeMoney[matchCount];

        int totalSpent = purchasedLotto.getNumbers().size() * 1000;
        double profitRate = ((double) totalPrize / totalSpent) * 100;
        profitRate = Math.round(profitRate * 100.0) / 100.0;

        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
