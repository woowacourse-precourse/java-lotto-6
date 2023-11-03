package lotto.service;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PrintResultServiceTest extends NsTest {
    private static final String FIFTH_PLACE = "3개 일치 (5,000원) - %d개";
    private static final String FOURTH_PLACE = "4개 일치 (50,000원) - %d개";
    private static final String THIRD_PLACE =" 5개 일치 (1,500,000원) - %d개";
    private static final String SECOND_PLACE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개";
    private static final String FIRST_PLACE = "6개 일치 (2,000,000,000원) - %d개";

    private final PrintResultService printResultService = new PrintResultService();


    @DisplayName("5등 하나일시 수익률 62.5% 출력")
    @Test
    void 로또_당첨_확인하기() {
        printResultService.printResult(List.of(
                new HashSet<>(List.of(8, 21, 23, 41, 42, 43)),
                new HashSet<>(List.of(3, 5, 11, 16, 32, 38)),
                new HashSet<>(List.of(7, 11, 16, 35, 36, 44)),
                new HashSet<>(List.of(1, 8, 11, 31, 41, 42)),
                new HashSet<>(List.of(13, 14, 16, 38, 42, 45)),
                new HashSet<>(List.of(7, 11, 30, 40, 42, 43)),
                new HashSet<>(List.of(2, 13, 22, 32, 38, 45)),
                new HashSet<>(List.of(1, 3, 5, 14, 22, 45))),
                new HashSet<>(List.of(1, 2, 3, 4, 5, 6)),
                7
                );
        assertThat(output()).contains("총 수익률은 62.5%입니다.");
    }

    @DisplayName("로또 결과 정상 출력 확인")
    @Test
    void 로또_당첨_개수_확인하기() {
        printResultService.printResult(List.of(
                        new HashSet<>(List.of(8, 21, 23, 41, 42, 43)),
                        new HashSet<>(List.of(3, 5, 11, 16, 32, 38)),
                        new HashSet<>(List.of(7, 11, 16, 35, 36, 44)),
                        new HashSet<>(List.of(1, 8, 11, 31, 41, 42)),
                        new HashSet<>(List.of(13, 14, 16, 38, 42, 45)),
                        new HashSet<>(List.of(7, 11, 30, 40, 42, 43)),
                        new HashSet<>(List.of(2, 13, 22, 32, 38, 45)),
                        new HashSet<>(List.of(1, 3, 5, 14, 22, 45))),
                new HashSet<>(List.of(1, 2, 3, 4, 5, 6)),
                7
        );
        assertThat(output()).contains("3개 일치 (5,000원) - 1개");
    }

    @DisplayName("로또 5등 당첨 횟수 1개 확인")
    @Test
    void 로또_당첨_횟수_등록() {
        printResultService.setLottoWinningCount(
                List.of(
                        new HashSet<>(List.of(8, 21, 23, 41, 42, 43)),
                        new HashSet<>(List.of(3, 5, 11, 16, 32, 38)),
                        new HashSet<>(List.of(7, 11, 16, 35, 36, 44)),
                        new HashSet<>(List.of(1, 8, 11, 31, 41, 42)),
                        new HashSet<>(List.of(13, 14, 16, 38, 42, 45)),
                        new HashSet<>(List.of(7, 11, 30, 40, 42, 43)),
                        new HashSet<>(List.of(2, 13, 22, 32, 38, 45)),
                        new HashSet<>(List.of(1, 3, 5, 14, 22, 45))),
                        new HashSet<>(List.of(1, 2, 3, 4, 5, 6)),
                7
        );
        assertThat(printResultService.getWinningCount().get(FIFTH_PLACE)).isEqualTo(1);
    }

    @DisplayName("2등 당첨시 winningCount에 추가되는지 확인")
    @Test
    void 로또_2등_당첨_횟수_확인() {
        printResultService.setLottoWinningCount(
                List.of(new HashSet<>(List.of(1, 2, 3, 4, 5, 7))),
                new HashSet<>(List.of(1, 2, 3, 4, 5, 6)),
                7
        );
        assertThat(printResultService.getWinningCount().get(SECOND_PLACE)).isEqualTo(1);
    }

    @DisplayName("3등 당첨시 winningCount에 추가되는지 확인")
    @Test
    void 로또_3등_당첨_횟수_확인() {
        printResultService.setLottoWinningCount(
                List.of(new HashSet<>(List.of(1, 2, 3, 4, 5, 8))),
                new HashSet<>(List.of(1, 2, 3, 4, 5, 6)),
                7
        );
        assertThat(printResultService.getWinningCount().get(THIRD_PLACE)).isEqualTo(1);
    }

    @DisplayName("4등 당첨시 winningCount에 추가되는지 확인")
    @Test
    void 로또_4등_당첨_횟수_확인() {
        printResultService.setLottoWinningCount(
                List.of(new HashSet<>(List.of(1, 2, 3, 4, 8, 9))),
                new HashSet<>(List.of(1, 2, 3, 4, 5, 6)),
                7
        );
        assertThat(printResultService.getWinningCount().get(FOURTH_PLACE)).isEqualTo(1);
    }

    @DisplayName("5등 당첨시 winningCount에 추가되는지 확인")
    @Test
    void 로또_5등_당첨_횟수_확인() {
        printResultService.setLottoWinningCount(
                List.of(new HashSet<>(List.of(1, 2, 3, 8, 9, 10))),
                new HashSet<>(List.of(1, 2, 3, 4, 5, 6)),
                7
        );
        assertThat(printResultService.getWinningCount().get(FIFTH_PLACE)).isEqualTo(1);
    }

    @DisplayName("5등 한장 구매시 500.0% 리턴")
    @Test
    void 수익률_정상출력_확인() {
        printResultService.printResult(List.of(
                new HashSet<>(List.of(1, 2, 3, 14, 22, 45))),
                new HashSet<>(List.of(1, 2, 3, 4, 5, 6)),
                7
        );
        assertThat(output()).contains("총 수익률은 500.0%입니다.");
    }

    @DisplayName("5등 한장, 깡 2장 구매시 166.7% 리턴")
    @Test
    void 수익률_정상출력_확인2() {
        printResultService.printResult(List.of(
                new HashSet<>(List.of(1, 2, 3, 14, 22, 45)),
                new HashSet<>(List.of(0, 0, 0, 0, 0, 0)),
                new HashSet<>(List.of(0, 0, 0, 0, 0, 0))),
                new HashSet<>(List.of(1, 2, 3, 4, 5, 6)),
                7
        );
        assertThat(output()).contains("총 수익률은 166.7%입니다.");
    }


    @DisplayName("5등 2번 totalWinnings 1000원 확인")
    @Test
    void totalWinnings_확인() {
        printResultService.checkKeyAndMoneyAppend(FIFTH_PLACE, 2);
        assertThat(printResultService.getTotalWinning()).isEqualTo(10000);
    }


    @Override
    protected void runMain() {

    }
}
