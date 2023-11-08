package lotto.model;

import lotto.util.MapMaker;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfirmationWinning {
    int bonusNumber;
    int tempWinningCount;
    boolean tempBounsNumberContains;
    List<EachLottoResult> lottoResult = new ArrayList<>();
    Map<Integer, Integer> lottoResultCount = new HashMap<>();

    public ConfirmationWinning(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public Map<Integer, Integer> getLottoResultCount(){
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
            for (int winningNumber : winningNumbres) {
                if (lottoNumber == winningNumber) {
                    this.tempWinningCount += 1;
                }

                if (lottoNumber == bonusNumber) {
                    this.tempBounsNumberContains = true;
                }
            }
        }
        lottoResult.add(new EachLottoResult(tempWinningCount, tempBounsNumberContains));
    }


    public Map<Integer, Integer> countAllLottosResult(List<EachLottoResult> lottoResult) {
        Map<Integer, Integer> lottoResultCount = MapMaker.makeEmptyLottoResultCount();

        for (EachLottoResult eachLotto : lottoResult) {
            if (eachLotto.winningCount == 3) {
                lottoResultCount = countUpLottoResult(3, lottoResultCount);
            } else if (eachLotto.winningCount == 4) {
                lottoResultCount = countUpLottoResult(4, lottoResultCount);
            } else if (eachLotto.winningCount == 5) {
                lottoResultCount = countUpLottoResult(5, lottoResultCount);
            } else if (eachLotto.winningCount == 6) {
                lottoResultCount = splitBonusNumberCase(eachLotto, lottoResultCount);
            }
        }
        return lottoResultCount;
    }


    public Map<Integer, Integer> splitBonusNumberCase(EachLottoResult eachLotto, Map<Integer, Integer> lottoResultCount) {
        if (eachLotto.bounsNumberContains) {
            countUpLottoResult(6, lottoResultCount);

        } else if (!eachLotto.bounsNumberContains) {
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
        Map<Integer, String> winningAmount = MapMaker.makeWinningAmount();

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
        System.out.println("총 수익률은 " + temp + "%입니다.");
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
