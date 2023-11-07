package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BundleGeneratorTest {
    PurchaseAmount purchaseAmount;

    @BeforeEach
    void setUp() {
        this.purchaseAmount = new PurchaseAmount("10000");
    }

    @DisplayName("입력된 purchaseAmount 개 수 만큼 로또를 생성한다.")
    @Test
    void 로또_묶음_생성() {
        BundleGenerator bundleGenerator = new BundleGenerator(this.purchaseAmount);
        Map<Lotto, Integer> result = bundleGenerator.generateLotto();
        assertEquals(10, result.size());
    }
}