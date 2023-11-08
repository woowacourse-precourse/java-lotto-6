package lotto.model;

import lotto.util.LottoRules;
import lotto.util.utils;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfirmationWinning {
    int bonusNumber;
    Map<Integer, Integer> lottoResultCount;
    int PRINT_RESULT_COUNT = LottoRules.PRINT_RESULT_COUNT.getValue();

    public ConfirmationWinning(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public Map<Integer, Integer> checkWinnings(List<Integer> winningNumbres, List<Lotto> lottos) {
        for (Lotto eachLotto : lottos) {
            calculateWinningCountAboutEachLotto(winningNumbres, eachLotto, bonusNumber);
        }
        this.lottoResultCount = countAllLottosResult(lottos);

        return lottoResultCount;
    }

    public void calculateWinningCountAboutEachLotto(List<Integer> winningNumbres, Lotto eachLotto, int bonusNumber) {
        List<Integer> lottoNumbers = eachLotto.getNumbers();
//        System.out.println("eachLotto: " + lottoNumbers);

        for (int winningNumbre : winningNumbres) {
            for (int lottoNumber : lottoNumbers) {
                countUpWinningCount(winningNumbre, lottoNumber, eachLotto);
            }
        }
//        System.out.println("이 로또에서 당첨 번호 개수는: " + eachLotto.getWinningCount());
    }

    public void countUpWinningCount(int winningNumbre, int lottoNumber, Lotto eachLotto) {
        if (winningNumbre == lottoNumber) {
            eachLotto.winningCount++;
            isBounusNumber(winningNumbre, eachLotto);
        }
    }

    public void isBounusNumber(int winningNumbre, Lotto eachLotto) {
        if (winningNumbre == bonusNumber) {
            eachLotto.winningBounsNumber = true;
        }
    }

    public Map<Integer, Integer> makeEmptyResult() {
        Map<Integer, Integer> lottoResultCount = new HashMap<>();
        for (int i = 0; i < PRINT_RESULT_COUNT; i++) {
            lottoResultCount.put(i + 3, 0);
        }
        return lottoResultCount;
    }


    // 모든 로또의 당첨 개수 구해서 저장하기
    public Map<Integer, Integer> countAllLottosResult(List<Lotto> lottos) {
        Map<Integer, Integer> lottoResultCount = makeEmptyResult();

        for (Lotto eachLotto : lottos) {
            if (eachLotto.getWinningCount() == 3) {
                lottoResultCount = countUpLottoResult(3, lottoResultCount);

            } else if (eachLotto.getWinningCount() == 4) {
                lottoResultCount = countUpLottoResult(4, lottoResultCount);

            } else if (eachLotto.getWinningCount() == 5) {
                lottoResultCount = countUpLottoResult(5, lottoResultCount);

            } else if (eachLotto.getWinningCount() == 6) {
                lottoResultCount = splitBonusNumberCase(eachLotto, lottoResultCount);
            }
        }
        return lottoResultCount;
    }


    public Map<Integer, Integer> splitBonusNumberCase(Lotto eachLotto, Map<Integer, Integer> lottoResultCount) {
        if (eachLotto.getWinningBounsNumber()) {
            countUpLottoResult(6, lottoResultCount);

        } else if (!eachLotto.getWinningBounsNumber()) {
            countUpLottoResult(7, lottoResultCount);
        }
        return lottoResultCount;
    }

    public Map<Integer, Integer> countUpLottoResult(int winningNumberCount, Map<Integer, Integer> lottoResultCount) {
        int previousCount = lottoResultCount.get(winningNumberCount);
        lottoResultCount.replace(winningNumberCount, previousCount + 1);
        return lottoResultCount;
    }


    public void showLottoGameResult(Map<Integer, Integer> lottoResultCount) {
        Map<Integer, String> winningAmount = utils.makeWinningAmount();

        for (Integer key : lottoResultCount.keySet()) {
            int value = lottoResultCount.get(key);
            if (key > 5) {
                System.out.println(key - 1 + "개 일치" + winningAmount.get(key) + " - " + value + "개");
            } else if (key <= 5) {
                System.out.println(key + "개 일치" + winningAmount.get(key) + " - " + value + "개");
            }
        }
    }

    public void calculateRate(int purchaseAmount) {
        double totalIncome = calculateTotalIncome(lottoResultCount);
        double temp = (totalIncome / purchaseAmount) * 100;
        System.out.println("총 수익률은 " + temp + "% 입니다.");
    }

    public int calculateTotalIncome(Map<Integer, Integer> lottoResultCount) {
        Map<Integer, Integer> winningAmountForCalculation = utils.makeWinningAmountForCalculation();
        int totalIncome = 0;
        for (int key : lottoResultCount.keySet()) {
            totalIncome += (lottoResultCount.get(key) * winningAmountForCalculation.get(key));
        }
        return totalIncome;
    }
}
