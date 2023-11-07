package lotto.view;

import static org.junit.jupiter.api.Assertions.*;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @Test
    @DisplayName("정상가격_정상개수_출력")
    void getBuyAmount() {
        InputView.getBuyAmount();

    }

    @Test
    void validateAmount() {
    }
}