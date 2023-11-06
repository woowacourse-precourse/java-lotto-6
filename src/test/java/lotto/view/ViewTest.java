package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.IssuedLottoDto;
import lotto.dto.WinningStatisticsDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ViewTest {

    View view = new View();
    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void 구매한_로또_번호_출력() {
        //given
        IssuedLottoDto lotto1 = new IssuedLottoDto(Arrays.stream(new int[]{1, 3, 5, 7, 9, 11})
                .boxed()
                .collect(Collectors.toList()));
        IssuedLottoDto lotto2 = new IssuedLottoDto(Arrays.stream(new int[]{2, 4, 6, 8, 10, 12})
                .boxed()
                .collect(Collectors.toList()));
        List<IssuedLottoDto> lottos = new ArrayList<>();
        lottos.add(lotto1);
        lottos.add(lotto2);
        //when
        view.printIssuedLottoNumbers(lottos);
        //then
        assertThat(outputStreamCaptor.toString()).contains("[2, 4, 6, 8, 10, 12]", "[1, 3, 5, 7, 9, 11]");
    }

    @Test
    public void 구매한_로또_통계_출력() {
        //given
        WinningStatisticsDto winningDto = new WinningStatisticsDto(1, 1, 0,
                1, 2, 67.86);
        //when
        view.printWinningStatistics(winningDto);
        //then
        assertThat(outputStreamCaptor.toString()).contains("3개 일치 (5,000원) - 1개", "4개 일치 (50,000원) - 1개",
                "5개 일치 (1,500,000원) - 0개", "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개", "6개 일치 (2,000,000,000원) - 2개",
                "총 수익률은 67.9%입니다.", "당첨 통계");
    }
}
