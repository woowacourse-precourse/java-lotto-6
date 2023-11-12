package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class PlayerLotto {
    private final List<Lotto> lottos;

    public PlayerLotto() {
        this.lottos = new ArrayList<>();
    }

    public void publish(int quantity) {
        while (lottos.size() < quantity) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(LottoConfig.MIN_LOTTO_NUMBER.getValue(),
                    LottoConfig.MAX_LOTTO_NUMBER.getValue(), LottoConfig.TOTAL_LOTTO_NUMBER.getValue());
            lottos.add(new Lotto(lottoNumber));
        }
    }

    public int getQuantity() {
        return lottos.size();
    }

    public String getAllLottoInfo() {
        StringBuilder info = new StringBuilder();

        for (Lotto lotto : lottos) {
            info.append(lotto.toString()).append("\n");
        }

        return info.toString();
    }

    public List<Integer> calculateResult(WinningNumber winningNumber) {
        List<Integer> result = new ArrayList<>();

        for (Lotto lotto : lottos) {
            result.add(lotto.getCalculateResult(winningNumber));
        }

        return result;
    }

    public List<Boolean> bonusResult(WinningNumber winningNumber) {
        List<Boolean> result = new ArrayList<>();

        for (Lotto lotto : lottos) {
            result.add(lotto.isBonusNumberIn(winningNumber));
        }

        return result;
    }
}
