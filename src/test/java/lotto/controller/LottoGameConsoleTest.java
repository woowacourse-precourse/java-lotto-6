package lotto.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameConsoleTest {
    @Test
    @DisplayName("로또 게임 콘솔 객체 생성 테스트")
    void createLottoGameConsole() {
        LottoGameConsole lottoGameConsole = new LottoGameConsole();
        assertThat(lottoGameConsole).isNotNull();
    }
}