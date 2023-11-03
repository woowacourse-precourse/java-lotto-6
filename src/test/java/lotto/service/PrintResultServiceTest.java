package lotto.service;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PrintResultServiceTest extends NsTest {



    private final PrintResultService printResultService = new PrintResultService();

    @DisplayName("로또 당첨 확인")
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
                new HashSet<>(List.of(1,2,3,4,5,6)),
                8,
                7
                );
        assertThat(output()).contains("총 수익률은 62.5%입니다.");
    }



    @Override
    protected void runMain() {

    }
}
