package lotto;

import lotto.dao.LottoRepository;
import lotto.dto.LottoDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

class LottoServiceTest {

    private LottoService lottoService;

    private final LottoRepository lottoRepository = mock(LottoRepository.class);


    @BeforeEach
    void setup() {
        lottoService = new LottoService(lottoRepository);
    }


    @Test
    void buyLotto() {
        doNothing().when(lottoRepository).save(anyString(), anyList());

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    String key = lottoService.buyLotto(8000);
                    assertThat(key).isNotBlank();
                },
//                flattenList(expected)
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
    void getLottos() {
        List<List<Integer>> expected = List.of(
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );

        List<Lotto> expectedLottos = expected.stream()
                .map(Lotto::new)
                .toList();

        doNothing().when(lottoRepository).save(eq(anyString()), expectedLottos);
        given(lottoRepository.findByKey(anyString())).willReturn(Optional.of(expectedLottos));

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    String key = lottoService.buyLotto(8000);

                    List<LottoDto> lottos = lottoService.getLottos(key);

                    List<List<Integer>> lottoNumbers = lottos.stream()
                            .map(LottoDto::numbers).toList();
                    assertThat(lottoNumbers).isEqualTo(expected);
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


}
