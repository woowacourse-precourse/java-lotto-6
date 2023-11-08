package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Application;
import lotto.LottoRank;

public class LottoController {

    public static List<Lotto> generateLottos(int price) {
        ArrayList<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < getPurchasedLottoAmount(price); i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);
        }
        return lottos;
    }

    private static int getPurchasedLottoAmount(int price) {
        int purchasedLottoAmount = price / 1000;
        return purchasedLottoAmount;
    }

    public static List<Integer> makeLottoResult(List<Integer> winningNumbers, int bonusNumber,
            List<Lotto> lottos) {
        List<Integer> winningCounts = new ArrayList<>(Collections.nCopies(5, 0));
        for (Lotto lotto : lottos) {
            Result result = getResult(winningNumbers, bonusNumber, lotto);
            LottoRank lottoRank = getLottoRank(LottoRank.values(), result.matchingNumber(),
                    result.bonusFlag());
            updateWinningCounts(lottoRank, winningCounts);
        }
        return winningCounts;
    }

    private static void updateWinningCounts(LottoRank lottoRank, List<Integer> winningCounts) {
        if (lottoRank != null) {
            winningCounts.set(lottoRank.ordinal(), winningCounts.get(lottoRank.ordinal()) + 1);
        }
    }

    private static Result getResult(List<Integer> winningNumbers, int bonusNumber, Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        int matchingNumber = 0;
        boolean bonusFlag = false;
        for (Integer lottoNumber : lottoNumbers) {
            matchingNumber = getMatchingNumber(winningNumbers, lottoNumber, matchingNumber);
            bonusFlag = isBonusFlag(bonusNumber, lottoNumber, bonusFlag);
        }
        return new Result(matchingNumber, bonusFlag);
    }

    private static boolean isBonusFlag(int bonusNumber, Integer lottoNumber, boolean bonusFlag) {
        if (lottoNumber == bonusNumber) {
            bonusFlag = true;
        }
        return bonusFlag;
    }

    private static int getMatchingNumber(List<Integer> winningNumbers, Integer lottoNumber,
            int matchingNumber) {
        if (winningNumbers.contains(lottoNumber)) {
            matchingNumber++;
        }
        return matchingNumber;
    }

    private record Result(int matchingNumber, boolean bonusFlag) {

    }

    private static LottoRank getLottoRank(LottoRank[] lottoRanks, int matchingNumber, boolean bonusFlag) {
        for (int i = 0; i < lottoRanks.length; i++) {
            if (matchingNumber == lottoRanks[i].getMatchCount() && (i != 1 || bonusFlag)) {
                return lottoRanks[i];
            }
        }
        return null;
    }

    public static double calculateEarningRate(int purchaseAmount,
            List<Integer> counts) {
        int iterTotalNumber = counts.size();
        int totalEarning = 0;
        for (int i = 0; i < iterTotalNumber; i++) {
            totalEarning += LottoRank.values()[i].getReward() * counts.get(i);
        }
        return (double) Math.round((double) totalEarning * 1000 / purchaseAmount) / 10;
    }

}
