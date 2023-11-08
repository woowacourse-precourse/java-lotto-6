package lotto;

import static lotto.ErrorMessage.DUPLICATE_WIN_BONUS;
import static lotto.ErrorMessage.OVER_BONUS_NUMBER_BOUNDARY;
import static lotto.configuration.LottoConfiguration.LOTTO_BOUNDARY_END_NUMBER;
import static lotto.configuration.LottoConfiguration.LOTTO_BOUNDARY_START_NUMBER;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Ranking;
import lotto.model.WinLotto;
import lotto.model.WinNumbers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class WinLottoTest {

    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
        Console.close();
    }

    @Nested
    @DisplayName("당첨번호와 보너스번호 유효 테스트")
    class NumberTest {
        @DisplayName("당첨번호와 보너스번호를 가진 객체를 생성합니다.")
        @Test
        void issueWinLotto() {
            // given
            WinNumbers winNumbers = WinNumbers.createWinNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
            BonusNumber bonusNumber = BonusNumber.createBonusNumber(7);
            // when
            // then
            assertDoesNotThrow(() -> WinLotto.issueWinLotto(winNumbers, bonusNumber));
        }

        @DisplayName("[Error] 당첨번호와 보너스번호가 중복되면 에러 메세지를 출력합니다.")
        @ValueSource(ints = {1, 6})
        @ParameterizedTest
        void validateDuplicateBetweenWinAndBonus(int number) {
            // given
            WinNumbers winNumber = WinNumbers.createWinNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
            BonusNumber bonusNumber = BonusNumber.createBonusNumber(number);
            // when
            WinLotto.issueWinLotto(winNumber, bonusNumber);

            // then
            assertThat(outputMessage.toString()).contains(DUPLICATE_WIN_BONUS.getMessage());
        }

        @DisplayName("[Error] 보너스 번호가 로또 범위를 벗어나면(start-1) 에러 메세지를 출력합니다.")
        @Test
        void validateBonusNumberBelowBoundary() {
            // given

            // when
            BonusNumber invalidBonusNumber = BonusNumber.createBonusNumber(LOTTO_BOUNDARY_START_NUMBER.get() - 1);

            // then
            assertThat(outputMessage.toString()).contains(OVER_BONUS_NUMBER_BOUNDARY.getMessage());
        }

        @DisplayName("[Error] 보너스 번호가 로또 범위를 벗어나면(END+1) 에러 메세지를 출력합니다.")
        @Test
        void validateBonusNumberOverBoundary() {
            // given

            // when
            BonusNumber invalidBonusNumber = BonusNumber.createBonusNumber(LOTTO_BOUNDARY_END_NUMBER.get() + 1);

            // then
            assertThat(outputMessage.toString()).contains(OVER_BONUS_NUMBER_BOUNDARY.getMessage());
//        }
        }
    }

    @Nested
    @DisplayName("당첨 테스트")
    class WiningTest {
        @DisplayName("등수를 정확하게 찾습니다.")
        @ParameterizedTest
        @CsvSource({
                "1,2,3,4,5,6,1",
                "1,2,3,4,5,7,2",
                "1,2,3,4,5,8,3",
                "1,2,3,4,8,9,4",
                "1,2,3,8,9,10,5"
        })
        void findOutLottoRank(int ball1, int ball2, int ball3, int ball4, int ball5, int ball6, int expectedRanking) {
            // given
            Lotto lotto = new Lotto(Arrays.asList(ball1, ball2, ball3, ball4, ball5, ball6));
            WinLotto winLotto = WinLotto.issueWinLotto(WinNumbers.createWinNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)),
                    BonusNumber.createBonusNumber(7));
            // when
            int actualRanking = winLotto.findOutLottoRanking(lotto).getRank();
            // then
            assertThat(actualRanking).isEqualTo(expectedRanking);
        }
    }

    public static InputStream setReadLine(String readLine) {
        return new ByteArrayInputStream(readLine.getBytes());
    }

}
