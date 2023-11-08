package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.constant.MagicNumber;
import org.junit.jupiter.api.Test;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class LottoGameControllerTest extends NsTest {
    @Test
    void 모든_입력_예외_재입력_후_올바른_결과() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("-1000", "", "8000", "1", null, "ㅇㄴㄹ", "1,2,3,4,5,6", null, "ㄴㅇㄹ", "3", "7");
                    assertThat(output()).contains(
                            "[ERROR] " + MagicNumber.PRICE_UNIT.getNumber() + "이상의 금액을 입력해 주세요.",
                            "[ERROR] 입력이 존재하지 않습니다.",

                            "[ERROR] 숫자를 여섯개 입력해 주세요.",
                            "[ERROR] 입력이 존재하지 않습니다.",
                            "[ERROR] 숫자를 입력해 주세요.",

                            "[ERROR] 입력이 존재하지 않습니다.",
                            "[ERROR] 숫자를 입력해 주세요.",
                            "[ERROR] 로또 번호와 보너스 번호가 중복되었습니다.",

                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "당첨 통계",
                            "---",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 62.5%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
