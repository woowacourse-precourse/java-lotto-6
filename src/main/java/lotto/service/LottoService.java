package lotto.service;

import lotto.model.LottoGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.util.CalculateUtil.divideByThousands;
import static lotto.util.GenerateLottoNumbersUtil.generateLottoNumber;
import static lotto.util.TypeConversionUtil.StringToInt;

public class LottoService {

    private final LottoGame lottoGame = new LottoGame();

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
}
