package lotto.domain;

import lotto.enums.Ranking;
import lotto.utils.RandomGenerator;

import java.math.BigDecimal;
import java.util.*;

public class Player {
    private int money;
    private long totalPrize;
    private List<Lotto> lottos;
    private Map<Ranking, Integer> results = new EnumMap<>(Ranking.class);

    public Player(int money) {
        validate(money);
        this.money = money;
        initResults();
    }

    private void validate(int money) {
        if (money % 1_000 != 0 || money < 0) {
            throw new IllegalArgumentException();
        }
    }

    private void initResults() {
        for(Ranking ranking : Ranking.values()) {
            results.put(ranking, 0);
        }
    }

    public void issueLotto() {
        lottos = new ArrayList<>();
        int lottoSize = money / 1_000;
        // TODO : lottos 사이즈와 lottoSize 비교
        for (int i = 0; i < lottoSize; i++) {
            lottos.add(new Lotto(RandomGenerator.generate()));
        }
    }

    public void findResults(WinningLotto winningLotto) {
        List<Integer> winningNumbers = winningLotto.getNumbers();
        int bonusNumber = winningLotto.getBonusNumber();

        for (Lotto lotto : lottos) {
            int count = lotto.findCount(winningNumbers);
            boolean bonus = lotto.contains(bonusNumber);
            Ranking ranking = rank(count, bonus);
            updateResults(ranking);
        }
    }

    private Ranking rank(int count, boolean bonus) {
        if (count == 6) {
            return Ranking.FIRST;
        }
        if (bonus && count == 5) {
            return Ranking.SECOND;
        }
        if (!bonus && count == 5) {
            return Ranking.THIRD;
        }
        if (count == 4) {
            return Ranking.FORTH;
        }
        if (count == 3) {
            return Ranking.FIFTH;
        }
        return Ranking.BLANK;
    }

    private void updateResults(Ranking ranking) {
        if (ranking.equals(Ranking.BLANK)) {
            return;
        }
        results.put(ranking, results.get(ranking) + 1);
    }

    public void findTotalPrize() {
        for (Ranking ranking : results.keySet()) {
            totalPrize += (long) ranking.getPrize() * results.get(ranking);
        }
    }

    public String issuedLottos() {
        StringBuilder result = new StringBuilder(String.valueOf(lottos.size()))
                .append("개를 구매했습니다.")
                .append(System.lineSeparator());

        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            Collections.sort(lottoNumbers);
            result.append(lottoNumbers).append(System.lineSeparator());
        }

        return result.toString();
    }

    public String lottoResults() {
        double prizeRate = (long) (1000. * totalPrize / money + 0.5) / 10.;

        StringBuilder result = new StringBuilder("당첨 통계").append(System.lineSeparator())
                .append("---").append(System.lineSeparator())
                .append("3개 일치 (5,000원) - ").append(results.get(Ranking.FIFTH)).append("개").append(System.lineSeparator())
                .append("4개 일치 (50,000원) - ").append(results.get(Ranking.FORTH)).append("개").append(System.lineSeparator())
                .append("5개 일치 (1,500,000원) - ").append(results.get(Ranking.THIRD)).append("개").append(System.lineSeparator())
                .append("5개 일치, 보너스 볼 일치 (30,000,000원) - ").append(results.get(Ranking.SECOND)).append("개").append(System.lineSeparator())
                .append("6개 일치 (2,000,000,000원) - ").append(results.get(Ranking.FIRST)).append("개").append(System.lineSeparator())
                .append("총 수익률은 ").append(new BigDecimal(prizeRate).toPlainString()).append("%입니다.");

        return result.toString();
    }
}
