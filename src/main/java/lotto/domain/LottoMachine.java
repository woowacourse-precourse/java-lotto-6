package lotto.domain;

import static lotto.util.RandomNumberGenerator.generateUniqueNumbers;

import java.util.ArrayList;
import java.util.List;
import lotto.util.LottoConstants;

public class LottoMachine {

    public static final String NOT_ENOUGH_MONEY = "구입 금액이 로또 가격보다 적습니다.";
    public static final String INVALID_UNIT_OF_MONEY = "로또 구입 금액은 1000원 단위여야 합니다.";

    public LottoTickets purchaseLotto(int purchaseAmount) {
        int numberOfLotto = calculateNumberOfLotto(purchaseAmount);
        return new LottoTickets(generateLottos(numberOfLotto));
    }

    private int calculateNumberOfLotto(int purchaseAmount) {
        if (purchaseAmount < LottoConstants.LOTTO_PRICE) {
            throw new IllegalArgumentException(NOT_ENOUGH_MONEY);
        }
        if (purchaseAmount % LottoConstants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_UNIT_OF_MONEY);
        }
        return purchaseAmount / LottoConstants.LOTTO_PRICE;
    }

    private List<Lotto> generateLottos(int numberOfLotto) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            lottos.add(generateSingleLotto());
        }
        return lottos;
    }

    private Lotto generateSingleLotto() {
        List<Integer> lottoNumbers = generateUniqueNumbers();
        return new Lotto(lottoNumbers);
    }
}
