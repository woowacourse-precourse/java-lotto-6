package lotto.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.Global.Exception;

public class LottoMachine {
    private LottoVendingMachine lottoVendingMachine;
    private LottoResultGenerator lottoResultGenerator;
    public static int LOTTO_NUMBER_MIN_RANGE = 1;
    public static int LOTTO_NUMBER_MAX_RANGE = 45;

    public LottoMachine(LottoVendingMachine lottoVendingMachine, LottoResultGenerator lottoResultGenerator) {
        this.lottoVendingMachine = lottoVendingMachine;
        this.lottoResultGenerator = lottoResultGenerator;
    }

    public List<String> buyLottos(int amount) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Lotto lotto = lottoVendingMachine.createValidLotto();
            lottoResultGenerator.getSelledLotto(lotto);
            result.add(lotto.getLottoCreatedResult());
        }
        return result;
    }

    public void setWinningNumberInformation(List<Integer> winningNumber, int bonusNumber) {
        isValidLottoNumber(winningNumber);
        isValidBonusNumber(bonusNumber);
        lottoResultGenerator.putWinningLottoNumber(winningNumber, bonusNumber);
    }

    public HashMap<String, Integer> getResult() {
        return lottoResultGenerator.getLottosResult();
    }

    public float getRateOfResult(HashMap<String, Integer> result) {
        return lottoResultGenerator.getLottoRateOfResult(result);
    }


    private void isValidLottoNumber(List<Integer> lottoNumber) {
        for (int number : lottoNumber) {
            if (number < LOTTO_NUMBER_MIN_RANGE || number > LOTTO_NUMBER_MAX_RANGE) {
                throw new IllegalArgumentException(Exception.LOTTO_WRONG_AMOUNT_INPUT.getErrorPhrase());
            }
        }
    }

    private void isValidBonusNumber(int number) {
        if (number < LOTTO_NUMBER_MIN_RANGE || number > LOTTO_NUMBER_MAX_RANGE) {
            throw new IllegalArgumentException(Exception.LOTTO_WRONG_AMOUNT_INPUT.getErrorPhrase());
        }
    }

}
