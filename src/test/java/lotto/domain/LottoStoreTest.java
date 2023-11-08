package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("LottoStore 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LottoStoreTest {

    @Test
    void getInstance_정적_팩토리_메소드는_같은_인스턴스를_반환한다() {
        LottoStore firstInstance = LottoStore.getInstance();
        LottoStore secondInstance = LottoStore.getInstance();

        Assertions.assertEquals(firstInstance, secondInstance);
    }

}
