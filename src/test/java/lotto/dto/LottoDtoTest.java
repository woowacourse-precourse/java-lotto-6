package lotto.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import lotto.model.Lotteries;
import lotto.model.Lotto;
import lotto.model.LottoNumberGenerator;
import lotto.vo.TicketCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoDtoTest {

    @DisplayName("로또 여러 개에 대한 리스트를 dto 리스트 형태로 변환한다.")
    @Test
    void toDto_test() {
        // given
        List<Lotto> lotteries = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
        );

        // when
        List<LottoDto> lotteriesDto = LottoDto.toDto(lotteries);

        // then
        assertEquals(lotteries.size(), lotteriesDto.size());
        lotteries.forEach(lotto -> {
            List<Integer> expectedNumbers = lotto.getNumbers();
            List<Integer> actualNumbers = lotto.getNumbers();
            assertEquals(expectedNumbers, actualNumbers);
        });
    }

    @DisplayName("단일 로또의 DTO에 대해 새로운 숫자를 추가하려고 시도할 경우 예외가 발생한다.")
    @Test
    void unmodifiable_list_test() {
        // given
        Lotteries lotteries = Lotteries.createLotteries(new TicketCount(1), new LottoNumberGenerator() {
            @Override
            public List<Integer> pickNumbers() {
                return List.of(1, 2, 3, 4, 5, 6);
            }
        });

        // when
        List<LottoDto> lotteriesDto = LottoDto.toDto(lotteries.getLotteries());

        // then
        assertThrows(UnsupportedOperationException.class, () -> lotteriesDto.get(0).getNumbers().add(7));
    }
}
