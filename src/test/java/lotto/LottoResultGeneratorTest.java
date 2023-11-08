package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultGeneratorTest {

    private LottoResultGenerator instance;
    private LottoTickets lottoTickets;
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        instance = LottoResultGenerator.getInstance();

        lottoTickets = LottoTickets.of(List.of(Lotto.of(List.of(1, 2, 3, 4, 5, 6))));
        winningLotto = WinningLotto.of(Lotto.of(List.of(1, 2, 3, 4, 5, 6)), BonusNumber.from(7));
    }

    @DisplayName("인스턴스 변수가 하나만 생성되는지 확인한다.")
    @Test
    void checkGenerateOnlyOneInstance() {
        // given
        LottoResultGenerator anotherInstance = LottoResultGenerator.getInstance();

        // when
        // then
        assertEquals(instance, anotherInstance);
    }

    @DisplayName("인스턴스로 LottoResultBoard 를 만들 수 있어야 한다.")
    @Test
    void generateLottoResultBoardByInstance() {
        // given
        LottoResultBoard lottoResultBoard = instance.generateLottoResultBoard(lottoTickets, winningLotto);

        // when
        long firstMatchCount = lottoResultBoard.findMatchCount(LottoRank.FIRST);
        long secondMatchCount = lottoResultBoard.findMatchCount(LottoRank.SECOND);
        long thirdMatchCount = lottoResultBoard.findMatchCount(LottoRank.THIRD);
        long fourthMatchCount = lottoResultBoard.findMatchCount(LottoRank.FOURTH);
        long fifthMatchCount = lottoResultBoard.findMatchCount(LottoRank.FIFTH);

        // then
        assertEquals(1, firstMatchCount);
        assertEquals(0, secondMatchCount);
        assertEquals(0, thirdMatchCount);
        assertEquals(0, fourthMatchCount);
        assertEquals(0, fifthMatchCount);
    }

}