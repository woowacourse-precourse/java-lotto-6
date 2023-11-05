package lotto.domain;

import static lotto.service.Validator.*;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class IssuedLotto {

    private final List<Lotto> lottos;
    private final int amount;

    public IssuedLotto(String amountInput) {
        validate(amountInput);
        this.lottos = createLottos(amountInput);
        this.amount = lottos.size();
    }

    private void validate(String amountInput) {
        validateNullOrBlank(amountInput);
        checkAndThrowIfNotNumeric(amountInput);
        validateFallingApart(Integer.parseInt(amountInput));
    }

    private List<Lotto> createLottos(String amountInput) {
        int convertedAmount = Integer.parseInt(amountInput) % LottoConstants.THOUSAND.getValue();
        return getLottos(convertedAmount);
    }

    private List<Lotto> getLottos(int convertedAmount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = LottoConstants.ZERO.getValue(); i < convertedAmount; i++) {
            lottoList.add(new Lotto(crateRandomUniqueList()));
        }
        return lottoList;
    }

    private List<Integer> crateRandomUniqueList() {
        return Randoms.pickUniqueNumbersInRange(LottoConstants.NUMBER_MIN.getValue(),
                LottoConstants.NUMBER_MAX.getValue(),
                LottoConstants.NUMBERS_MAX_SIZE.getValue());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getAmount() {
        return amount;
    }
}
