package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Service.LottoService;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.dto.LottoResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserCreateLottoTest {

    private LottoService lottoService;

    @BeforeEach
    void beforeEach() {
        lottoService = LottoService.getInstance();
    }

    @Test
    public void 당첨숫자_갯수출력() throws Exception {
        Lottos lottos = new Lottos(); // 8, 21, 23, 41, 42, 43
        int[] intArray = {8, 21, 23, 35, 36, 37};
        List<Integer> intList = Arrays.stream(intArray)
                .boxed()
                .collect(Collectors.toList());
        Lotto lotto = new Lotto(intList);
        int index = 0;

        Method method = LottoService.class.getDeclaredMethod("getOverlappingNumber", Lotto.class, Lottos.class, int.class);
        method.setAccessible(true);
        int overlappingNumber = (int) method.invoke(lottoService, lotto, lottos, index);

        assertEquals(3, overlappingNumber);
    }

    @Test
    public void 스코어_체크() throws Exception {
        Lottos lottos = new Lottos(); // 8, 21, 23, 41, 42, 43
        int index = 0;
        LottoResponseDTO lottoResponseDTO = new LottoResponseDTO();
        int overlappingNumber = 3;
        int bonus = 41;

        Method method = LottoService
                .class
                .getDeclaredMethod("checkScore",
                        Lottos.class,
                        int.class,
                        LottoResponseDTO.class,
                        int.class,
                        int.class);
        method.setAccessible(true);

        method.invoke(lottoService, lottos, bonus, lottoResponseDTO, index, overlappingNumber);

        assertEquals(1, lottoResponseDTO.getFifthPlace());
    }

    @Test
    public void 수익률_정산() throws Exception {
        int lottoLength = 1;
        LottoResponseDTO lottoResponseDTO = new LottoResponseDTO();
        lottoResponseDTO.plusFifthPlace();

        Method method = LottoService
                .class
                .getDeclaredMethod("calculateRateOfReturn",
                        int.class,
                        LottoResponseDTO.class);
        method.setAccessible(true);

        double rateOfReturn = (double) method.invoke(lottoService, lottoLength, lottoResponseDTO);

        assertEquals(500.0, rateOfReturn);
    }
}
