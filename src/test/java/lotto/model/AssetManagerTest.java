package lotto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssetManagerTest {

    @Test
    public void validateBudget_구입금액이_1000원_단위가_아닌_경우_예외_발생() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new AssetManager(1500));
    }

    @Test
    public void validateBudget_구입금액이_1000원_이하인_경우_예외_발생() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new AssetManager(0));
    }
}
