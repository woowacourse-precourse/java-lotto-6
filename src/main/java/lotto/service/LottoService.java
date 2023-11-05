package lotto.service;

import lotto.model.Lotto;
import lotto.model.LottoGame;
import lotto.model.Ranking;

import java.util.*;

import static lotto.util.CalculateUtil.divideByThousands;
import static lotto.util.GenerateLottoNumbersUtil.generateLottoNumber;
import static lotto.util.TypeConversionUtil.StringToInt;
import static lotto.util.TypeConversionUtil.StringToIntegerList;

public class LottoService {

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
        for (int i = 0; i < lottoCount; i ++) {
            List<Integer> lottoNumber = generateLottoNumber();
            sortLottoNumber(lottoNumber);
            purchaseLottoNumbers.add(lottoNumber);
        }
        return purchaseLottoNumbers;
    }

    private static void sortLottoNumber(List<Integer> lottoNumber) {
        Collections.sort(lottoNumber);
    }

    private Map<Ranking, Integer> setResult() {
        Map<Ranking, Integer> result = new LinkedHashMap<>();

        for (Ranking rank : Ranking.values()) {
            result.put(rank, 0);
        }
        return result;
    }
}
