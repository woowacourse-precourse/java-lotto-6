package lotto.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoBonusPair;
import lotto.model.PublishedLotto;
import lotto.view.LottoOutputView;
import lotto.view.View;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConfirmWinningServiceTest extends OutputChecker {
    private final Lotto WINNER_NUMBER = new Lotto(List.of(3, 4, 5, 6, 7, 8));
    private final Integer BONUS_NUMBER = 13;
    private final LottoOutputView OUTPUT_VIEW = (LottoOutputView) View.generateLottoOutputView();

    @DisplayName("confirmWinning 메서드 작동 확인 테스트")
    @Test
    void confirmWinningTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    PublishedLotto publishedLotto = PublishedLotto.getInstance(3000);
                    LottoBonusPair lottoBonusPair = LottoBonusPair.getInstance(WINNER_NUMBER, BONUS_NUMBER);
                    ConfirmWinningService testInstance = (ConfirmWinningService) Service.generateConfirmWinningService();

                    testInstance.confirmWinning(publishedLotto, lottoBonusPair, OUTPUT_VIEW);

                    assertThat(output()).contains(
                            "4개 일치 (50,000원) - 1개"
                    );
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(7, 8, 9, 10, 11, 12),
                List.of(13, 14, 15, 16, 17, 18)
        );
    }

    @Test
    void getTotalReward() {
    }
}