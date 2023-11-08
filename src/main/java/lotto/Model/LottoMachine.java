package lotto.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LottoMachine {
    private LottoVendingMachine lottoVendingMachine;
    private LottoResultGenerator lottoResultGenerator;

    public LottoMachine(LottoVendingMachine lottoVendingMachine, LottoResultGenerator lottoResultGenerator) {
        this.lottoVendingMachine = lottoVendingMachine;
        this.lottoResultGenerator = lottoResultGenerator;
    }

    private String sellLotto() {
        Lotto lotto = lottoVendingMachine.createValidLotto();
        lottoResultGenerator.getSelledLotto(lotto);
        return lotto.getLottoCreatedResult();
    }

    public List<String> purchaseLottos(int amount) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            result.add(sellLotto());
        }
        return result;
    }

    public void setWinningNumberInformation(Lotto winningLotto, int bonusNumber) {
        lottoResultGenerator.putWinningLottoNumber(winningLotto, bonusNumber);
    }

    public HashMap<String, Integer> getLottoWinningResult() {
        return lottoResultGenerator.getLottosResult();
    }

    public float getRateOfResult(HashMap<String, Integer> result) {
        return lottoResultGenerator.getLottoRateOfResult(result);
    }

}
