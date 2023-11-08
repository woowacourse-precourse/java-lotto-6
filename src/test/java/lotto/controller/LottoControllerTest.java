package lotto.controller;


import lotto.domain.Lotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoControllerTest {

    LottoController lottoController = new LottoController();
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restore() {
        System.setOut(System.out);
        output.reset();
    }

    @Test
    void 당첨_통계_계산_후_출력() {
        // given
        List<Lotto> lottos = new ArrayList<>();
        List<Integer> num1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> num2 = Arrays.asList(1, 2, 3, 4, 5, 7);
        List<Integer> num3 = Arrays.asList(1, 2, 3, 4, 5, 10);
        List<Integer> num4 = Arrays.asList(1, 2, 3, 4, 12, 13);
        List<Integer> num5 = Arrays.asList(1, 2, 3, 11, 12, 13);
        lottos.add(new Lotto(num1));
        lottos.add(new Lotto(num2));
        lottos.add(new Lotto(num3));
        lottos.add(new Lotto(num4));
        lottos.add(new Lotto(num5));

        List<Integer> winningNum = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer bonusNum = 7;

        // when
        lottoController.winningStats(lottos, winningNum, bonusNum);

        // then
        assertThat(output.toString()).contains(
                "\n당첨 통계 \n---",
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 1개",
                "5개 일치 (1,500,000원) - 1개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                "6개 일치 (2,000,000,000원) - 1개",
                "총 수익률은 40631100.0%입니다."
        );
    }
}