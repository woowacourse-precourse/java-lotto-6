package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.repository.LottoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DrawingHostTest {
    final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void init() {
        LottoRepository.resetInstanceAndFields();
    }

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(System.out);
    }

    @DisplayName("총 결과 생성 테스트")
    @Test
    void produceResults() {
        LottoRepository lottoRepository = LottoRepository.getInstance();
        LottoRepository.setBudget(2000);
        lottoRepository.save(new Lotto(List.of(1, 2, 8, 9, 10, 11)));
        lottoRepository.save(new Lotto(List.of(1, 2, 3, 8, 9, 10)));

        LottoChecker lottoChecker = new LottoChecker(List.of(1, 2, 3, 4, 5, 6), 7);
        DrawingHost drawingHost = new DrawingHost(lottoChecker);

        drawingHost.produceResults();

        String expected = "3개 일치 (5,000원) - 1개\n"
                + "4개 일치 (50,000원) - 0개\n"
                + "5개 일치 (1,500,000원) - 0개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n"
                + "6개 일치 (2,000,000,000원) - 0개\n"
                + "총 수익률은 250.0%입니다.";

        assertThat(outputStream.toString()).contains(expected);
    }
}
