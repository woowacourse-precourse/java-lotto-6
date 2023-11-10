package lotto.model;

import lotto.util.LottoRules;
import lotto.util.MapMaker;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfirmationWinning {
    int bonusNumber;
    int tempWinningCount;
    boolean tempBounsNumberContains;

    int FIRST_PRIZE = LottoRules.FIRST_PRIZE.getValue();
    int SECOND_PRIZE = LottoRules.SECOND_PRIZE.getValue();
    int FORTH_PRIZE = LottoRules.FORTH_PRIZE.getValue();

    List<EachLottoResult> lottoResult = new ArrayList<>();
    Map<Integer, Integer> lottoResultCount = new HashMap<>();

    public ConfirmationWinning(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public Map<Integer, Integer> getLottoResultCount() {
        return this.lottoResultCount;
    }

    public void checkWinnings(List<Integer> winningNumbres, List<Lotto> lottos) {
        for (Lotto eachLotto : lottos) {
            calculateWinningCountAboutEachLotto(winningNumbres, eachLotto);
        }
        this.lottoResultCount = countAllLottosResult(lottoResult);
    }

    public void calculateWinningCountAboutEachLotto(List<Integer> winningNumbres, Lotto eachLotto) {
        List<Integer> lottoNumbers = eachLotto.getNumbers();
        this.tempWinningCount = 0;
        this.tempBounsNumberContains = false;

        for (int lottoNumber : lottoNumbers) {
            countUpWinningCount(winningNumbres, lottoNumber);
        }
        lottoResult.add(new EachLottoResult(tempWinningCount, tempBounsNumberContains));
    }

    public void countUpWinningCount(List<Integer> winningNumbres, int lottoNumber) {
        for (int winningNumber : winningNumbres) {
            if (lottoNumber == winningNumber) {
                this.tempWinningCount += 1;
            }

            if (lottoNumber == bonusNumber) {
                this.tempBounsNumberContains = true;
            }
        }
    }

    public Map<Integer, Integer> countAllLottosResult(List<EachLottoResult> lottoResult) {
        Map<Integer, Integer> lottoResultCount = MapMaker.makeEmptyLottoResultCount();

        for (EachLottoResult eachLotto : lottoResult) {
            if (eachLotto.winningCount >= FORTH_PRIZE && eachLotto.winningCount < FIRST_PRIZE) {
                lottoResultCount = countUpLottoResult(eachLotto.winningCount, lottoResultCount);
            } else if (eachLotto.winningCount == FIRST_PRIZE) {
                lottoResultCount = splitBonusNumberCase(eachLotto, lottoResultCount);
            }
        }
        return lottoResultCount;
    }

    public Map<Integer, Integer> splitBonusNumberCase(EachLottoResult eachLotto, Map<Integer, Integer> lottoResultCount) {
        if (eachLotto.bounsNumberContains) {
            lottoResultCount = countUpLottoResult(FIRST_PRIZE, lottoResultCount);

        } else if (!eachLotto.bounsNumberContains) {
            lottoResultCount = countUpLottoResult(FIRST_PRIZE + 1, lottoResultCount);
        }
        return lottoResultCount;
    }
    public Map<Integer, Integer> countUpLottoResult(int winningNumberCount, Map<Integer, Integer> lottoResultCount) {
        int previousCount = lottoResultCount.get(winningNumberCount);
        lottoResultCount.replace(winningNumberCount, previousCount + 1);
        return lottoResultCount;
    }

    public void showLottoGameResult(Map<Integer, Integer> lottoResultCount) {
        Map<Integer, String> winningAmount = MapMaker.makeWinningAmount();

        for (Integer key : lottoResultCount.keySet()) {
            int value = lottoResultCount.get(key);
            if (key > SECOND_PRIZE) {
                System.out.println(key - 1 + "개 일치" + winningAmount.get(key) + " - " + value + "개");
            } else if (key <= SECOND_PRIZE) {
                System.out.println(key + "개 일치" + winningAmount.get(key) + " - " + value + "개");
            }
        }
    }
    public void calculateRate(int purchaseAmount) {
        double totalIncome = calculateTotalIncome(lottoResultCount);
        double rate = (totalIncome / purchaseAmount) * 100;
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }

    public int calculateTotalIncome(Map<Integer, Integer> lottoResultCount) {
        Map<Integer, Integer> winningAmountForCalculation = MapMaker.makeWinningAmountForCalculation();
        int totalIncome = 0;
        for (int key : lottoResultCount.keySet()) {
            totalIncome += (lottoResultCount.get(key) * winningAmountForCalculation.get(key));
        }
        return totalIncome;
    }
}
