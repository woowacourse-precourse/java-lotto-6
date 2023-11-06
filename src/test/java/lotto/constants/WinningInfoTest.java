package lotto.constants;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Optional;
import java.util.stream.Stream;

import static lotto.constants.WinningInfo.*;
import static org.assertj.core.api.Assertions.*;

class WinningInfoTest {

    @DisplayName("매칭한 숫자 개수와 보너스 당첨 여부를 전달하면")
    @Nested
    class createWinningInfo {
        private static Stream<Arguments> successCreateWinningInfoScenarios() {
            return Stream.of(
                    Arguments.of(6, false, FIRST_RANK),
                    Arguments.of(5, true, SECOND_RANK),
                    Arguments.of(5, false, THIRD_RANK),
                    Arguments.of(4, false, FOURTH_RANK),
                    Arguments.of(3, false, FIFTH_RANK)
            );
        }

        @DisplayName("일치하는 당첨 정보를 생성")
        @ParameterizedTest
        @MethodSource("successCreateWinningInfoScenarios")
        void success(int numberOfMatch, boolean isBonusWinning, WinningInfo winningInfo) {

            Optional<WinningInfo> result = WinningInfo.of(numberOfMatch, isBonusWinning);

            assertThat(result).isNotEmpty();

            WinningInfo createdWinningInfo = result.get();

            assertThat(createdWinningInfo).isEqualTo(winningInfo);
        }

        private static Stream<Arguments> failCreateWinningInfoScenarios() {
            return Stream.of(
                    Arguments.of(7, false),
                    Arguments.of(6, true),
                    Arguments.of(4, true),
                    Arguments.of(3, true),
                    Arguments.of(2, false),
                    Arguments.of(1, false)
            );
        }

        @DisplayName("일치하는 당첨 정보가 존재하지 않는 경우 생성하지 않는다.")
        @ParameterizedTest
        @MethodSource("failCreateWinningInfoScenarios")
        void fail(int numberOfMatch, boolean isBonusWinning) {

            Optional<WinningInfo> result = WinningInfo.of(numberOfMatch, isBonusWinning);

            assertThat(result).isEmpty();

        }

    }

}