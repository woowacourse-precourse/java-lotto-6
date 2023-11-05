package lotto.service;

import lotto.model.LottoGame;

import static lotto.util.CalculateUtil.divideByThousands;
import static lotto.util.TypeConversionUtil.StringToInt;

public class LottoService {

    private final LottoGame lottoGame = new LottoGame();

    public int getLottoCount(String inputPurchaseMoney) {
        int purchaseMoney = StringToInt(inputPurchaseMoney);
        int lottoCount = divideByThousands(purchaseMoney);
        lottoGame.setLottoCount(lottoCount);
        return lottoCount;
    }
}
