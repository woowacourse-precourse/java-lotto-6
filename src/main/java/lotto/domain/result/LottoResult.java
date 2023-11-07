package lotto.domain.result;

import lotto.domain.lotto.Lotto;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class LottoResult {

    public List<Integer> announceLottoResult(List<Lotto> lottoTicketList, List<Integer> userLottoNumbers, Integer userBonusNumber) {
        System.out.println("당첨 통계");
        System.out.println("---");

        List<Integer> prizeCounts = repeatCheckingLotto(lottoTicketList, userLottoNumbers, userBonusNumber);

        compareToPrize(prizeCounts);

        return prizeCounts;
    }

    private void compareToPrize(List<Integer> prizeCounts) {
        for (int i = 0; i < prizeCounts.size(); i++) {
            Prize prize = Prize.values()[i];
            System.out.print(prize.getMatchedNumbers() + "개 일치");
            if (prize.checkBonus()) {
                System.out.print(", 보너스 볼 일치");
            }
            System.out.print(" " + prize.getFormattedPrizeMoney());
            System.out.printf(" - %d개%n", prizeCounts.get(i));
        }
    }

    public List<Integer> repeatCheckingLotto(List<Lotto> lottoTicketList, List<Integer> userLottoNumbers, Integer userBonusNumber) {
        List<Integer> prizeCounts = initiatePrizeCounts();
        for (Lotto lotto : lottoTicketList) {
            int matchedNumbers = countMatchedNumbers(lotto.getNumbers(), userLottoNumbers);
            if (matchedNumbers == 5) {
                checkBonus(lotto, userBonusNumber, prizeCounts);
            }
            else if (matchedNumbers != 5) {
                checkLotto(prizeCounts, matchedNumbers);
            }
        }
        return prizeCounts;
    }

    public List<Integer> initiatePrizeCounts() {
        List<Integer> prizeCounts = new ArrayList<>(Prize.values().length);
        for (int i = 0; i < Prize.values().length; i++) {
            prizeCounts.add(0);
        }
        return prizeCounts;
    }

    private void checkBonus(Lotto lotto, Integer userBonusNumber, List<Integer> prizeCounts) {
        if (lotto.contains(userBonusNumber)) {
            prizeCounts.set(Prize.SECOND_PRIZE.ordinal(), prizeCounts.get(Prize.SECOND_PRIZE.ordinal()) + 1);
        }
        if (!lotto.contains(userBonusNumber)) {
            prizeCounts.set(Prize.THIRD_PRIZE.ordinal(), prizeCounts.get(Prize.THIRD_PRIZE.ordinal()) + 1);
        }
    }

    private void checkLotto(List<Integer> prizeCounts, int matchedNumbers) {
        for (Prize prize : Prize.values()) {
            if (matchedNumbers == prize.getMatchedNumbers()) {
                int count = prizeCounts.get(prize.ordinal()) + 1;
                prizeCounts.set(prize.ordinal(), count);
            }
        }
    }

    public int countMatchedNumbers(List<Integer> lottoNumbers, List<Integer> userLottoNumbers) {
        int count = 0;
        for (Integer userLottoNumber : userLottoNumbers) {
            if (lottoNumbers.contains(userLottoNumber)) {
                count++;
            }
        }
        return count;
    }
}

enum Prize {
    FIFTH_PRIZE(3, 5000, false),
    FOURTH_PRIZE(4, 50000, false),
    THIRD_PRIZE(5, 1500000, false),
    SECOND_PRIZE(5, 30000000, true),
    FIRST_PRIZE(6, 2000000000, false);

    private final int matchedNumbers;
    private final int prizeMoney;
    private final boolean bonus;

    Prize(int matchedNumbers, int prizeMoney, boolean bonus) {
        this.matchedNumbers = matchedNumbers;
        this.prizeMoney = prizeMoney;
        this.bonus = bonus;
    }

    public int getMatchedNumbers() {
        return this.matchedNumbers;
    }

    public String getFormattedPrizeMoney() {
        DecimalFormat formatter = new DecimalFormat("(###,###원)");
        return formatter.format(this.prizeMoney);
    }

    public boolean checkBonus() {
        return this.bonus;
    }

    public int getPrizeMoney() {
        return this.prizeMoney;
    }
}