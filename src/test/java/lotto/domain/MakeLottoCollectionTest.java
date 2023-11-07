package lotto.domain;

import lotto.domain.db.PurchaseAmount;
import lotto.domain.db.PurchaseLotto;
import lotto.domain.db.PurchaseLottoCollection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MakeLottoCollectionTest {
    @DisplayName("Collection이 올바른 사이즈로 반환 되는지 확인")
    @Test
    void collectionByCorrectSize() {
        PurchaseLottoCollection testCollection = MakeLottoCollection.getCollection(6);
        int testListSize = testCollection.getPurchaseLottos().size();

        assertThat(testListSize).isEqualTo(6);
    }
}