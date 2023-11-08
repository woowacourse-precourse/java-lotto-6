package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Award;
import lotto.domain.BonusNumber;
import lotto.domain.ClientLotto;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.system.Constant;
import lotto.system.Util;

public class AwardService {

    public static List<Award> makeAwards(WinningLotto winningLotto, ClientLotto clientLotto, BonusNumber bonusNumber) {
        List<Award> awards = new ArrayList<>();
        for (int i = 0; i < clientLotto.size(); i++) {
            Lotto eachLotto = clientLotto.getLottoAt(i);
            int score = winningLotto.grade(eachLotto);
            awards.add(Award.getByOrdinal(score));
        }
        applyBonusNumber(awards, clientLotto, bonusNumber);
        return awards;

    }

    private static void applyBonusNumber(List<Award> awards, ClientLotto userLotto, BonusNumber bonusNumber) {
        Stream.iterate(0, i -> i + 1)
                .limit(awards.size())
                .filter(i -> awards.get(i).equals(Award.FIVE))
                .filter(i -> userLotto.getLottoAt(i).contains(bonusNumber.getBonusNumber()))
                .forEach(i -> awards.set(i, Award.FIVE_BONUS));
    }

    public static float makeYield(List<Award> prize) {
        float beforeMoney = prize.size() * Constant.MONEY_UNIT;
        float totalMoney = beforeMoney;
        for (Award award : prize) {
            totalMoney += award.getReward();
        }
        return Util.calculateYield(totalMoney, beforeMoney);
    }
}
