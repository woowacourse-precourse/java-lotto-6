package lotto.service;

import static lotto.domain.constant.ErrorMessages.NOT_INTEGER;
import static lotto.domain.constant.ErrorMessages.PURCHASE_RANGE;
import static lotto.domain.constant.ErrorMessages.PURCHASE_UNIT;
import static lotto.domain.constant.Range.PURCHASE_COST_LOWER_LIMIT;
import static lotto.domain.constant.Range.PURCHASE_COST_UNIT;
import static lotto.domain.constant.Range.PURCHASE_COST_UPPER_LIMIT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class PurchaseLotto {
    public List<Lotto> purchase(String cost) {
        int numberOfLotto = validateNumberOfLotto(cost);
        return getLottos(numberOfLotto);
    }

    private int validateNumberOfLotto(String cost) {
        int numberCost = toNumber(cost);
        if (!checkRange(numberCost)) {
            throw new IllegalArgumentException(PURCHASE_RANGE.getMessage());
        }
        if (!checkUnit(numberCost)) {
            throw new IllegalArgumentException(PURCHASE_UNIT.getMessage());
        }
        return numberCost / PURCHASE_COST_UNIT.getLimit();
    }

    private boolean checkRange(int cost) {
        return cost >= PURCHASE_COST_LOWER_LIMIT.getLimit()
                && cost <= PURCHASE_COST_UPPER_LIMIT.getLimit();
    }

    private boolean checkUnit(int cost) {
        return cost % PURCHASE_COST_UNIT.getLimit() == 0;
    }

    private int toNumber(String cost) {
        try {
            return Integer.parseInt(cost);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER.getMessage());
        }
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
