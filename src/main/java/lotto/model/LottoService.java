package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.configurations.LottoConstants;

public class LottoService {

    public List<Lotto> purchaseLotto(Integer money) {
        int lottoCount = money / LottoConstants.LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(generateLotto());
        }

        return lottos;
    }

    private Lotto generateLotto() {
        List<Integer> lottoNumbers = getUniqueLottoNumber();

        sortNumbers(lottoNumbers);

        return new Lotto(lottoNumbers);
    }

    private List<Integer> getUniqueLottoNumber() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(LottoConstants.MIN_LOTTO_NUM,
                LottoConstants.MAX_LOTTO_NUM,
                LottoConstants.LOTTO_NUMBER_LENGTH);

        return new ArrayList<>(lottoNumber);
    }

    private void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    public LottoResult findWinningLottos(List<Lotto> lottos, WinningNumber winningNumber) {
        LottoResult lottoResult = new LottoResult();

        for (Lotto lotto : lottos) {
            lottoResult.addResult(checkLotto(lotto, winningNumber));
        }

        return lottoResult;
    }

    private LottoRank checkLotto(Lotto lotto, WinningNumber winningNumber) {
        int correct = 0;
        boolean hasBonus = false;

        for (Integer number : winningNumber.getNumbers()) {
            if (lotto.containsNumber(number)) {
                correct++;
            }
        }

        if (lotto.containsNumber(winningNumber.getBonusNumber())) {
            hasBonus = true;
        }

        return LottoRank.findRank(correct, hasBonus);
    }

}
