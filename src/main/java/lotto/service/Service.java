package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.Rank;
import lotto.data.*;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Service {
    public static LottoRepository creatLottoRepository(PurchaseAmount purchaseAmount) {
        int lottoCount = purchaseAmount.getPurchasedLottoCount();

        LottoRepository lottoRepository = new LottoRepository();
        for (int i = 0; i < lottoCount; i++) {
            lottoRepository.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        return lottoRepository;
    }

    public static LottoResult createLottoResult(LottoRepository lottoRepository,
                                                WinningNumbers winningNumbers,
                                                BonusNumber bonusNumber) {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);
        initResult(result);

        for(Lotto lotto : lottoRepository.getLottos()){
            int winningCount = lotto.countMatchNumbers(winningNumbers);
            boolean hasBonusNumber = lotto.isMatchBonusNumber(bonusNumber);
            updateLottoResult(result, winningCount, hasBonusNumber);
        }
        return new LottoResult(result);
    }

    private static void updateLottoResult(Map<Rank, Integer> result, int winningCount, boolean hasBonusNumber) {

        if (winningCount == Rank.FIRST.getNumberOfMatch()) {result.put(Rank.FIRST, result.get(Rank.FIRST) + 1);}

        if (winningCount == Rank.SECOND.getNumberOfMatch() && hasBonusNumber) {
            result.put(Rank.SECOND, result.get(Rank.SECOND) + 1);
        }

        if (winningCount == Rank.THIRD.getNumberOfMatch()) {result.put(Rank.THIRD, result.get(Rank.THIRD) + 1);}

        if (winningCount == Rank.FOURTH.getNumberOfMatch()) {result.put(Rank.FOURTH, result.get(Rank.FOURTH) + 1);}

        if (winningCount == Rank.FIFTH.getNumberOfMatch()) {result.put(Rank.FIFTH, result.get(Rank.FIFTH) + 1);}
    }




    private static void initResult(Map<Rank, Integer> result) {
        result.put(Rank.FIRST, 0);
        result.put(Rank.SECOND, 0);
        result.put(Rank.THIRD, 0);
        result.put(Rank.FOURTH, 0);
        result.put(Rank.FIFTH, 0);
    }

    public static double calculateRateOfReturn(LottoResult lottoResult, PurchaseAmount purchaseAmount) {

        int returnAmount = calculateReturnAmount(lottoResult);

        double rateOfReturn = ((double) returnAmount - purchaseAmount.getAmount()) / purchaseAmount.getAmount() * 100;

        return rateOfReturn;
    }

    private static int calculateReturnAmount(LottoResult lottoResult) {
        int amount=0;
        Map<Rank, Integer> result = lottoResult.get();
        if(result.get(Rank.FIRST)!=0){amount+=Rank.FIRST.getAmount()*result.get(Rank.FIRST);}
        if(result.get(Rank.SECOND)!=0){amount+=Rank.SECOND.getAmount()*result.get(Rank.SECOND);}
        if(result.get(Rank.THIRD)!=0){amount+=Rank.THIRD.getAmount()*result.get(Rank.THIRD);}
        if(result.get(Rank.FOURTH)!=0){amount+=Rank.FOURTH.getAmount()*result.get(Rank.FOURTH);}
        if(result.get(Rank.FIFTH)!=0){amount+=Rank.FIFTH.getAmount()*result.get(Rank.FIFTH);}

        return amount;

    }
}
