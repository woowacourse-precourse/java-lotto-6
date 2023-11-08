package lotto.view.output;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;
import lotto.domain.lotto.LottoGroup;
import lotto.fixture.Fixture;
import lotto.view.output.writer.ConsoleWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 발행 출력 뷰")
class LottoIssueOutputViewTest {
    private LottoIssueOutputView lottoIssueOutputView;
    private ConsoleWriter mockConsoleWriter;

    @BeforeEach
    void setUp() {
        mockConsoleWriter = mock(ConsoleWriter.class);
        lottoIssueOutputView = new LottoIssueOutputView(mockConsoleWriter);
    }

    @Test
    @DisplayName("구매한 로또 개수를 출력합니다.")
    void Should_Print_Purchased_Lotto_Count_Message_When_Print_LottoGroup() {
        //when
        final LottoGroup lottoGroup = new LottoGroup(
                List.of(
                        Fixture.createContinuousLotto(1, 6),
                        Fixture.createContinuousLotto(7, 12),
                        Fixture.createContinuousLotto(13, 18)
                )
        );
        lottoIssueOutputView.printPurchasedLottos(lottoGroup);

        //then
        verify(mockConsoleWriter).println("3개를 구매했습니다.");
    }

    @Test
    @DisplayName("구매한 로또 내역을 출력합니다.")
    void Should_Print_Purchased_Lottos_When_Print_LottoGroup() {
        //when
        final LottoGroup lottoGroup = new LottoGroup(
                List.of(
                        Fixture.createContinuousLotto(1, 6),
                        Fixture.createContinuousLotto(7, 12),
                        Fixture.createContinuousLotto(13, 18)
                )
        );
        lottoIssueOutputView.printPurchasedLottos(lottoGroup);

        //then
        verify(mockConsoleWriter).println("[1, 2, 3, 4, 5, 6]\n[7, 8, 9, 10, 11, 12]\n[13, 14, 15, 16, 17, 18]");
    }
}
