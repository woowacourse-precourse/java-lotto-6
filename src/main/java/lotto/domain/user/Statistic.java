package lotto.domain.user;

import lotto.config.Config;
import lotto.constant.LottoRank;
import lotto.constant.MyConstant;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoEnvelop;
import lotto.domain.number.LottoTargetNumResults;
import lotto.utill.Utii;

import java.util.LinkedList;
import java.util.List;

public class Statistic {
    private static final Integer TARGET_COUNT_SIX = 6;
    private static final Integer TARGET_COUNT_FIVE = 5;
    private static final Integer TARGET_COUNT_FOUR = 4;
    private static final Integer TARGET_COUNT_THREE = 3;
    private static final Integer LOTTO_FIRST = LottoRank.MONEY_FIRST_PLACE.getIndex();
    private static final Integer LOTTO_SECOND = LottoRank.MONEY_SECOND_PLACE.getIndex();
    private static final Integer LOTTO_THIRD = LottoRank.MONEY_THIRD_PLACE.getIndex();
    private static final Integer LOTTO_FOURTH = LottoRank.MONEY_FOURTH_PLACE.getIndex();
    private static final Integer LOTTO_FIFTH = LottoRank.MONEY_FIFTH_PLACE.getIndex();
    private static final Integer ADD_COUNT = 1;
    private final List<LottoRank> lottoRanks = List.of(LottoRank.MONEY_FIRST_PLACE, LottoRank.MONEY_SECOND_PLACE,
            LottoRank.MONEY_THIRD_PLACE, LottoRank.MONEY_FOURTH_PLACE, LottoRank.MONEY_FIFTH_PLACE);
    List<Integer> countLottoPlaces;
    private LottoEnvelop lottoEnvelop;
    private Judgment judgment;
    private Integer totalWinMoney;

    public Statistic(LottoEnvelop lottoEnvelop, LottoTargetNumResults lottoTargetNumResults) {
        this.lottoEnvelop = lottoEnvelop;
        this.judgment = Config.judgment(lottoTargetNumResults);
        this.totalWinMoney = 0;
        this.countLottoPlaces = new LinkedList<>(List.of(0, 0, 0, 0, 0));
    }

    public StringBuilder show() {
        StringBuilder resultString = new StringBuilder();

        execution();

        resultString.append(MyConstant.MSG_STATISTIC_FIFTH_PLACE_RESULT(getCount(LOTTO_FIFTH)));
        resultString.append(MyConstant.MSG_STATISTIC_FOURTH_PLACE_RESULT(getCount(LOTTO_FOURTH)));
        resultString.append(MyConstant.MSG_STATISTIC_THIRD_PLACE_RESULT(getCount(LOTTO_THIRD)));
        resultString.append(MyConstant.MSG_STATISTIC_SECOND_PLACE_RESULT(getCount(LOTTO_SECOND)));
        resultString.append(MyConstant.MSG_STATISTIC_FIRST_PLACE_RESULT(getCount(LOTTO_FIRST)));

        return resultString;
    }

    private void execution() {

        for (int i = 0; i < lottoEnvelop.size(); i++) {
            Lotto lotto = lottoEnvelop.takeLotto(i);
            Integer countSame = judgment.countSameWinNumbers(lotto);
            Boolean isSameBonus = judgment.isSameBonusNum(lotto);

            isFirstPlace(countSame);
            isSecondPlace(countSame, isSameBonus);
            isThirdPlace(countSame, isSameBonus);
            isFourthPlace(countSame);
            isFifthPlace(countSame);
        }
    }

    private void calculateTotalWinMoney() {

        for (LottoRank lottoRank : lottoRanks) {
            totalWinMoney = totalWinMoney + getWinMoneyPlace(lottoRank);
        }
    }

    public Integer getTotalWinMoney() {
        calculateTotalWinMoney();

        return totalWinMoney;
    }

    private Integer getWinMoneyPlace(LottoRank lottoRank) {
        Integer moneyPlace = lottoRank.getMoney();
        Integer indexPlace = lottoRank.getIndex();

        return moneyPlace * getCount(indexPlace);
    }

    private void isFirstPlace(Integer countSame) {
        if (isSameCount(countSame, TARGET_COUNT_SIX)) {
            increaseCount(LOTTO_FIRST);
        }
    }

    private void isSecondPlace(Integer countSame, Boolean isSameBonus) {
        if (isSameCount(countSame, TARGET_COUNT_FIVE) && isSameBonus) {
            increaseCount(LOTTO_SECOND);
        }
    }

    private void isThirdPlace(Integer countSame, Boolean isSameBonus) {
        if (isSameCount(countSame, TARGET_COUNT_FIVE) && !isSameBonus) {
            increaseCount(LOTTO_THIRD);
        }
    }

    private void isFourthPlace(Integer countSame) {
        if (isSameCount(countSame, TARGET_COUNT_FOUR)) {
            increaseCount(LOTTO_FOURTH);
        }
    }

    private void isFifthPlace(Integer countSame) {
        if (isSameCount(countSame, TARGET_COUNT_THREE)) {
            increaseCount(LOTTO_FIFTH);
        }
    }

    private void increaseCount(Integer index) {
        Integer count = countLottoPlaces.get(index);
        countLottoPlaces.set(index, count + ADD_COUNT);
    }

    private Integer getCount(Integer index) {
        return countLottoPlaces.get(index);
    }


    private boolean isSameCount(Integer countSame, Integer targetCount) {
        return Utii.isSameInt(countSame, targetCount);
    }
}
