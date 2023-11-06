package lotto.domain.repository;

import java.util.LinkedList;
import java.util.List;
import lotto.domain.BonusNumber;

public class BonusNumberRepository {
    private static final int DEFAULT = 0;

    private static List<BonusNumber> bonusNumbers = new LinkedList<>();

    public static void add(BonusNumber bonusNumber) {
        bonusNumbers.add(bonusNumber);
    }

    public static void clear() {
        bonusNumbers.clear();
    }

    public static int findBonusNumber() {
        return findByIndex(DEFAULT).getNumber();
    }

    private static BonusNumber findByIndex(int index) {
        return bonusNumbers.get(index);
    }
}
