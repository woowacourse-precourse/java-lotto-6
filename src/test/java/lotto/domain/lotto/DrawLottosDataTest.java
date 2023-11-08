package lotto.domain.lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.EnumMap;
import lotto.controller.dto.output.DrawLottosOutput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

final class DrawLottosDataTest {
    @DisplayName("로또 추첨 결과를 save하면 총 비용과 수익금이 증가하며, EnumMap의 count가 증가한다.")
    @ParameterizedTest
    @EnumSource(LottoPrize.class)
    void save_withLottoPrize_shouldAddTotalCostAndTotalEarning(final LottoPrize lottoPrize) {
        // given
        final DrawLottosData data = new DrawLottosData();

        // when
        data.save(lottoPrize);

        // then
        assertThat(data)
                .extracting("totalCost")
                .isEqualTo(LottoSeller.LOTTO_PRICE);

        assertThat(data)
                .extracting("totalEarning")
                .isEqualTo(lottoPrize.getPrize());

        assertThat(data)
                .extracting("data")
                .isInstanceOf(EnumMap.class);
    }

    @DisplayName("수익률이 소수점 둘째 자리에서 정상적으로 반올림 되는지 확인")
    @Test
    void returnOnRate_mustRound_() {
        // given
        final LottoPrize lottoPrize = LottoPrize.X;
        final DrawLottosData data = new DrawLottosData();
        data.save(lottoPrize);

        // when
        final DrawLottosOutput result = data.toDrawLottosOutput();

        // then
        assertThat(result.firstCount()).isEqualTo(0);
        assertThat(result.secondCount()).isEqualTo(0);
        assertThat(result.thirdCount()).isEqualTo(0);
        assertThat(result.fourthCount()).isEqualTo(0);
        assertThat(result.fifthCount()).isEqualTo(0);
        assertThat(result.returnOfRate()).isEqualTo(0.0);
    }

    @DisplayName("1등인 경우 수익률 및 결과 Dto 데이터 검증")
    @Test
    void verifyingData_whenFirst() {
        // given
        final LottoPrize lottoPrize = LottoPrize.FIRST;
        final DrawLottosData data = new DrawLottosData();
        data.save(lottoPrize);

        // when
        final DrawLottosOutput result = data.toDrawLottosOutput();

        // then
        assertThat(result.firstCount()).isEqualTo(1);
        assertThat(result.secondCount()).isEqualTo(0);
        assertThat(result.thirdCount()).isEqualTo(0);
        assertThat(result.fourthCount()).isEqualTo(0);
        assertThat(result.fifthCount()).isEqualTo(0);
        assertThat(result.returnOfRate()).isEqualTo(200_000_000.0);
    }

    @DisplayName("2등인 경우 수익률 및 결과 Dto 데이터 검증")
    @Test
    void verifyingData_whenSecond() {
        // given
        final LottoPrize lottoPrize = LottoPrize.SECOND;
        final DrawLottosData data = new DrawLottosData();
        data.save(lottoPrize);

        // when
        final DrawLottosOutput result = data.toDrawLottosOutput();

        // then
        assertThat(result.firstCount()).isEqualTo(0);
        assertThat(result.secondCount()).isEqualTo(1);
        assertThat(result.thirdCount()).isEqualTo(0);
        assertThat(result.fourthCount()).isEqualTo(0);
        assertThat(result.fifthCount()).isEqualTo(0);
        assertThat(result.returnOfRate()).isEqualTo(3_000_000.0);
    }

    @DisplayName("3등인 경우 수익률 및 결과 Dto 데이터 검증")
    @Test
    void verifyingData_whenThird() {
        // given
        final LottoPrize lottoPrize = LottoPrize.THIRD;
        final DrawLottosData data = new DrawLottosData();
        data.save(lottoPrize);

        // when
        final DrawLottosOutput result = data.toDrawLottosOutput();

        // then
        assertThat(result.firstCount()).isEqualTo(0);
        assertThat(result.secondCount()).isEqualTo(0);
        assertThat(result.thirdCount()).isEqualTo(1);
        assertThat(result.fourthCount()).isEqualTo(0);
        assertThat(result.fifthCount()).isEqualTo(0);
        assertThat(result.returnOfRate()).isEqualTo(150_000.0);
    }

    @DisplayName("4등인 경우 수익률 및 결과 Dto 데이터 검증")
    @Test
    void verifyingData_whenFourth() {
        // given
        final LottoPrize lottoPrize = LottoPrize.FOURTH;
        final DrawLottosData data = new DrawLottosData();
        data.save(lottoPrize);

        // when
        final DrawLottosOutput result = data.toDrawLottosOutput();

        // then
        assertThat(result.firstCount()).isEqualTo(0);
        assertThat(result.secondCount()).isEqualTo(0);
        assertThat(result.thirdCount()).isEqualTo(0);
        assertThat(result.fourthCount()).isEqualTo(1);
        assertThat(result.fifthCount()).isEqualTo(0);
        assertThat(result.returnOfRate()).isEqualTo(5_000.0);
    }

    @DisplayName("5등인 경우 수익률 및 결과 Dto 데이터 검증")
    @Test
    void verifyingData_whenFifth() {
        // given
        final LottoPrize lottoPrize = LottoPrize.FIFTH;
        final DrawLottosData data = new DrawLottosData();
        data.save(lottoPrize);

        // when
        final DrawLottosOutput result = data.toDrawLottosOutput();

        // then
        assertThat(result.firstCount()).isEqualTo(0);
        assertThat(result.secondCount()).isEqualTo(0);
        assertThat(result.thirdCount()).isEqualTo(0);
        assertThat(result.fourthCount()).isEqualTo(0);
        assertThat(result.fifthCount()).isEqualTo(1);
        assertThat(result.returnOfRate()).isEqualTo(500.0);
    }

    @DisplayName("미당첨인 경우 수익률 및 결과 Dto 데이터 검증")
    @Test
    void verifyingData_whenNone() {
        // given
        final LottoPrize lottoPrize = LottoPrize.X;
        final DrawLottosData data = new DrawLottosData();
        data.save(lottoPrize);

        // when
        final DrawLottosOutput result = data.toDrawLottosOutput();

        // then
        assertThat(result.firstCount()).isEqualTo(0);
        assertThat(result.secondCount()).isEqualTo(0);
        assertThat(result.thirdCount()).isEqualTo(0);
        assertThat(result.fourthCount()).isEqualTo(0);
        assertThat(result.fifthCount()).isEqualTo(0);
        assertThat(result.returnOfRate()).isEqualTo(0.0);
    }
}