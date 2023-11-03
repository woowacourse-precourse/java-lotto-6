package lotto.domain;

import lotto.utils.RandomGenerator;

import java.util.*;

public class Player {
    private final int FIRST = 2_000_000_000,
            SECOND = 30_000_000,
            THIRD = 1_500_000,
            FORTH = 50_000,
            FIFTH = 5_000;
    private int money, prize;
    private List<Lotto> lottos = new ArrayList<>();
    private Map<Integer, Integer> results = new HashMap<>();

    public Player(int money) {
        this.money = money;
        for (int i = 1; i < 6; i++) {
            results.put(i, 0);
        }
    }

    public void issueLotto() {
        int lottoSize = money / 1_000;
        // TODO : lottos 사이즈와 lottoSize 비교
        for (int i = 0; i < lottoSize; i++) {
            lottos.add(new Lotto(RandomGenerator.generate()));
        }
    }

    public void sortLottos() {
        for (Lotto lotto : lottos) {
            lotto.sort();
        }
    }

    public void findResults(WinningLotto winningLotto) {
        List<Integer> winningNumbers = winningLotto.getNumbers();
        int bonusNumber = winningLotto.getBonusNumber();

        for (Lotto lotto : lottos) {
            int count = findCount(lotto, winningNumbers);
            boolean bonus = findBonus(lotto, bonusNumber);
            int rank = findRank(count, bonus);
            updateResults(rank);
        }
    }

    private int findCount(Lotto lotto, List<Integer> winningNumbers) {
        int count = 0;

        for (Integer winningNumber : winningNumbers) {
            if (lotto.contains(winningNumber)) {
                count++;
            }
        }

        return count;
    }

    private boolean findBonus(Lotto lotto, int bonusNumber) {
        return lotto.contains(bonusNumber);
    }

    private int findRank(int count, boolean bonus) {
        if (count == 6) {
            return 1;
        }
        if (bonus && count == 5) {
            return 2;
        }
        if (!bonus && count == 5) {
            return 3;
        }
        if (count == 4) {
            return 4;
        }
        if (count == 3) {
            return 5;
        }
        return -1;
    }

    private void updateResults(int rank) {
        if (rank == -1) {
            return;
        }
        results.put(rank, results.get(rank) + 1);
    }

    public void findPrize() {
        for (Integer rank : results.keySet()) {
            if (rank == 1) {
                prize += FIRST * results.get(rank);
            }
            if (rank == 2) {
                prize += SECOND * results.get(rank);
            }
            if (rank == 3) {
                prize += THIRD * results.get(rank);
            }
            if (rank == 4) {
                prize += FORTH * results.get(rank);
            }
            if (rank == 5) {
                prize += FIFTH * results.get(rank);
            }
        }
    }

    public String issuedLottos() {
        StringBuilder result = new StringBuilder(String.valueOf(lottos.size())).append("개를 구매했습니다.\n");
        for (Lotto lotto : lottos) {
            result.append(lotto.toString()).append('\n');
        }
        return result.toString();
    }

    public String lottoResults() {
        double prizeRate = (int) (prize / money * 10. + 0.5) / 10.;
        System.out.println(prize);

        StringBuilder result = new StringBuilder("당첨 통계\n")
                .append("---\n")
                .append("3개 일치 (5,000원) - ").append(results.get(5)).append("개\n")
                .append("4개 일치 (50,000원 - ").append(results.get(4)).append("개\n")
                .append("5개 일치 (1,500,000원) - ").append(results.get(3)).append("개\n")
                .append("5개 일치, 보너스 볼 일치 (30,000,000원) - ").append(results.get(2)).append("개\n")
                .append("6개 일치 (2,000,000,000원) - ").append(results.get(1)).append("개\n")
                .append("총 수익률은 ").append(prizeRate).append("%입니다.");
        return result.toString();
    }
}
