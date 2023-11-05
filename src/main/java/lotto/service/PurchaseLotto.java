package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class PurchaseLotto {
    public static final String PURCHASE_COST_NAN_MSG = "[ERROR] 구입 금액은 정수이어야 합니다.";
    public static final String PURCHASE_COST_RANGE_MSG = "[ERROR] 로또는 최소 한 개 최대 천 개까지 구입 가능합니다.";
    public static final String PURCHASE_COST_UNIT_MSG = "[ERROR] 구입 금액은 1000단위 숫자이어야 합니다.";

    public List<Lotto> purchase(String cost) {
        int numberOfLotto = validateNumberOfLotto(cost);
        return getLottos(numberOfLotto);
    }

    private int validateNumberOfLotto(String cost) {
        int numberCost = toNumber(cost);
        if (!checkRange(numberCost)) {
            throw new IllegalArgumentException(PURCHASE_COST_RANGE_MSG);
        }
        if (!checkUnit(numberCost)) {
            throw new IllegalArgumentException(PURCHASE_COST_UNIT_MSG);
        }
        return numberCost / 1000;
    }

    private boolean checkRange(int number) {
        return number >= 1000 && number <= 1_000_000;
    }

    private boolean checkUnit(int number) {
        return number % 1000 == 0;
    }

    private int toNumber(String cost) {
        int result;
        try {
            result = Integer.parseInt(cost);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PURCHASE_COST_NAN_MSG);
        }
        return result;
    }

    private List<Lotto> getLottos(int numberOfLottos) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(getLotto());
        }
        return lottos;
    }

    private Lotto getLotto() {
        return new Lotto(getRandomNumbers());
    }

    private List<Integer> getRandomNumbers() {
        return new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
