package lotto.domain;

import lotto.enums.Ranking;

import java.math.BigDecimal;
import java.util.*;

public class Player {
    private int money;
    private List<Lotto> lottos;
    private Map<Ranking, Integer> rankingCounts;

    public Player(int money) {
        validate(money);
        this.money = money;

        lottos = new ArrayList<>();

        rankingCounts = new EnumMap<>(Ranking.class);
        Arrays.stream(Ranking.values()).forEach(key -> rankingCounts.put(key, 0));
    }

    private void validate(int money) {
        if (money % LottoMachine.getLottoPrice() != 0 || money < 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getMoney() {
        return money;
    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottos);
    }

    public void addLottos(List<Lotto> issuedLottos) {
        lottos.addAll(issuedLottos);
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
        StringBuilder result = new StringBuilder("당첨 통계").append(System.lineSeparator())
                .append("---").append(System.lineSeparator())
                .append("3개 일치 (5,000원) - ").append(rankingCounts.get(Ranking.FIFTH)).append("개").append(System.lineSeparator())
                .append("4개 일치 (50,000원) - ").append(rankingCounts.get(Ranking.FORTH)).append("개").append(System.lineSeparator())
                .append("5개 일치 (1,500,000원) - ").append(rankingCounts.get(Ranking.THIRD)).append("개").append(System.lineSeparator())
                .append("5개 일치, 보너스 볼 일치 (30,000,000원) - ").append(rankingCounts.get(Ranking.SECOND)).append("개").append(System.lineSeparator())
                .append("6개 일치 (2,000,000,000원) - ").append(rankingCounts.get(Ranking.FIRST)).append("개").append(System.lineSeparator())
                .append("총 수익률은 ").append(new BigDecimal(prizeRate).toPlainString()).append("%입니다.");

        return result.toString();
    }
}
