package lotto.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.factory.LottoControllerFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LottoControllerFactoryTest {

    @DisplayName("LottoControllerFactory가 LottoController를 올바르게 생성하는지 확인한다.")
    @Test
    void LottoControllerFactory가_LottoController를_올바르게_생성() {
        LottoController controller = LottoControllerFactory.create();

        assertNotNull(controller);
    }
}
