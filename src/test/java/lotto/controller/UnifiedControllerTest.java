package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UnifiedControllerTest {
    private UnifiedController unifiedController;

    @BeforeEach
    public void createUnifiedController() {
        unifiedController = new UnifiedController();
    }

    @DisplayName("로또 장수 잘 구하는 지 확인")
    @Test
    void 테스트_calcNumOfTickets() {
        //given
        int expect = 2012341;
        String input = "2012341000";

        //when
        int result = unifiedController.calcNumOfTickets(input);

        //then
        assertThat(result).isEqualTo(expect);
    }

}
