package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
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

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 로또_구입금액_검증_테스트() {
        String purchaseAmount = "300000";

        boolean validate = Application.validateInputPurchaseAmount(purchaseAmount);

        assertThat(validate).isTrue();
    }

    @Test
    void 로또_구입금액_천원단위_미만_예외_테스트() {
        String purchaseAmount = "300011";

        boolean validate = Application.validateInputPurchaseAmount(purchaseAmount);

        assertThat(validate).isFalse();
    }

    @Test
    void 로또_구입금액_문자_예외_테스트() {
        String purchaseAmount = "300aa";

        boolean validate = Application.validateInputPurchaseAmount(purchaseAmount);

        assertThat(validate).isFalse();
    }

    @Test
    void 사용자_입력_숫자_검증_테스트() {
        List<String> lottoNumbers = List.of("1,2,3,4,5,6".split(","));

        boolean validate = Application.validateInputLottoNumbers(lottoNumbers);

        assertThat(validate).isTrue();
    }

    @Test
    void 사용자_입력_숫자_길이_예외_테스트() {
        List<String> lottoNumbers = List.of("1,2,3,4,5,6,7".split(","));

        boolean validate = Application.validateInputLottoNumbers(lottoNumbers);

        assertThat(validate).isFalse();
    }

    @Test
    void 사용자_입력_문자열_예외_테스트() {
        List<String> lottoNumbers = List.of("1,c,3,a,5,6".split(","));

        boolean validate = Application.validateInputLottoNumbers(lottoNumbers);

        assertThat(validate).isFalse();
    }

    @Test
    void 사용자_입력_숫자_범위_예외_테스트() {
        List<String> lottoNumbers = List.of("1,2,3,4,46,6".split(","));

        boolean validate = Application.validateInputLottoNumbers(lottoNumbers);

        assertThat(validate).isFalse();
    }

    @Test
    void 사용자_입력_숫자_중복_예외_테스트() {
        List<String> lottoNumbers = List.of("1,2,3,4,4,6".split(","));

        boolean validate = Application.validateInputLottoNumbers(lottoNumbers);

        assertThat(validate).isFalse();
    }

    @Test
    void 사용자_입력_보너스_테스트() {
        List<Integer> lottoNumbers = List.of(1,2,3,4,5,6);
        String bonusNumbers = "7";

        boolean validate = Application.validateBonusNumber(lottoNumbers, bonusNumbers);

        assertThat(validate).isTrue();
    }

    @Test
    void 사용자_입력_보너스_문자_예외_테스트() {
        List<Integer> lottoNumbers = List.of(1,2,3,4,5,6);
        String bonusNumbers = "a";

        boolean validate = Application.validateBonusNumber(lottoNumbers, bonusNumbers);

        assertThat(validate).isFalse();
    }

    @Test
    void 사용자_입력_보너스_로또와_중복_예외_테스트() {
        List<Integer> lottoNumbers = List.of(1,2,3,4,5,6);
        String bonusNumbers = "1";

        boolean validate = Application.validateBonusNumber(lottoNumbers, bonusNumbers);

        assertThat(validate).isFalse();
    }

    @Test
    void 사용자_입력_보너스_범위_예외_테스트() {
        List<Integer> lottoNumbers = List.of(1,2,3,4,5,6);
        String bonusNumbers = "47";

        boolean validate = Application.validateBonusNumber(lottoNumbers, bonusNumbers);

        assertThat(validate).isFalse();
    }

    @Test
    void 로또들_생성_테스트() {
        int purchaseAmount = 25000;

        List<Lotto> lotties = Application.createLotties(purchaseAmount);

        assertThat(lotties.size()).isEqualTo(25);
    }

    @Test
    void 로또와_사용자_숫자_일치_개수_구하는_테스트() {
        List<Lotto> lotties = new ArrayList<>();
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        lotties.add(lotto);
        List<Integer> userLottoNumbers = List.of(1,2,3,4,10,11);
        int bonusNumber = 15;

        List<Integer> lottoMatchCounts = Application.getLottoMatchCounts(
                lotties,
                userLottoNumbers,
                bonusNumber
        );

        assertThat(lottoMatchCounts).isEqualTo(List.of(4));
    }

    @Test
    void 일치_개수를_등수로_변환_테스트() {
        List<Integer> lottoMatchCounts = new ArrayList<>(List.of(3,5,15,3));

        List<Integer> numOfRankings = Application.getNumOfRankings(lottoMatchCounts);

        assertThat(numOfRankings).isEqualTo(Arrays.asList(0, 1, 1, 0, 2));
    }

    @Test
    void 상금_계산_테스트() {
        List<Integer> lottoMatchCounts = new ArrayList<>(List.of(0,0,1,1,1));

        int totalPrize = Application.getTotalPrize(lottoMatchCounts);

        assertThat(totalPrize).isEqualTo(1555000);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
