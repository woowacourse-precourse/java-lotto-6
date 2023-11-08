package lotto.service;

import lotto.model.Lotto;
import lotto.model.LottoGame;
import lotto.model.Ranking;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static lotto.util.CalculateUtil.divideByThousands;
import static lotto.util.GenerateLottoNumbersUtil.generateLottoNumber;
import static lotto.util.TypeConversionUtil.StringToInt;
import static lotto.util.TypeConversionUtil.StringToIntegerList;

public class LottoService {

    private static final int THOUSAND_VALUE = 1000;
    private static final int HUNDRED_VALUE = 100;
    private static final int ZERO_VALUE = 0;

    private final LottoGame lottoGame = new LottoGame();

    private List<Integer> winnerLottoNumber = new ArrayList<>();
    private int bonusNumber;

    public int getLottoCount(String inputPurchaseMoney) {
        int purchaseMoney = StringToInt(inputPurchaseMoney);
        int lottoCount = divideByThousands(purchaseMoney);
        lottoGame.setLottoCount(lottoCount);
        return lottoCount;
    }

    public List<List<Integer>> purchaseLottoNumberProcess() {
        List<List<Integer>> purchaseLottoNumbers = generateLottoNumbers();
        setPurchaseLottoNumbers(purchaseLottoNumbers);
        return purchaseLottoNumbers;
    }

    public Map<Ranking, Integer> calculatePrizeMoney() {
        Map<Ranking, Integer> result = setResult();

        List<List<Integer>> purchaseLottoNumbers = lottoGame.getPurchaseLottoNumbers();
        for (List<Integer> purchaseLottoNumber : purchaseLottoNumbers) {
            long count = purchaseLottoNumber.stream().filter(number -> winnerLottoNumber.contains(number))
                    .count();
            boolean contains = purchaseLottoNumber.contains(bonusNumber);
            Ranking ranking = Ranking.valueOf((int) count, contains);
            result.put(ranking, result.get(ranking) + 1);
        }

        return result;
    }

    public void setWinnerLottoNumbers(String inputWinnerNumber) {
        List<Integer> winnerNumber = StringToIntegerList(inputWinnerNumber);
        Lotto lotto = new Lotto(winnerNumber);
        winnerLottoNumber = lotto.getNumbers();
    }

    public void setBonusNumber(String inputBonusNumber) {
        this.bonusNumber = StringToInt(inputBonusNumber);
    }

    private void setPurchaseLottoNumbers(List<List<Integer>> purchaseLottoNumbers) {
        lottoGame.setPurchaseLottoNumbers(purchaseLottoNumbers);
    }

    private List<List<Integer>> generateLottoNumbers() {
        List<List<Integer>> purchaseLottoNumbers = new ArrayList<>();
        int lottoCount = lottoGame.getLottoCount();
        for (int i = ZERO_VALUE; i < lottoCount; i++) {
            List<Integer> lottoNumber = generateLottoNumber();

            purchaseLottoNumbers.add(lottoNumber);
        }
        return purchaseLottoNumbers;
    }

    private Map<Ranking, Integer> setResult() {
        Map<Ranking, Integer> result = new LinkedHashMap<>();

        for (Ranking rank : Ranking.values()) {
            result.put(rank, ZERO_VALUE);
        }
        return result;
    }

    public double getRevenueRate(Map<Ranking, Integer> result) {
        int totalMoney = lottoGame.getLottoCount() * THOUSAND_VALUE;

        double earningRate = ZERO_VALUE;
        for (Ranking rank : result.keySet()) {
            earningRate =
                    earningRate + ((double) (rank.getWinningAmount()) / totalMoney * (result.get(
                            rank)) * (HUNDRED_VALUE));
        }
        lottoGame.setProfitRate(earningRate);
        return earningRate;
    }
}
