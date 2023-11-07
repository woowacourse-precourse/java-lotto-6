package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import lotto.Service.LottoService;
import lotto.domain.Lotto;
import lotto.dto.CountScoreResponseDTO;
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
        ArrayList<Integer> user = new ArrayList<>(Arrays.asList(21, 8, 23, 41, 42, 43));
        ArrayList<Integer> ticket = new ArrayList<>(Arrays.asList(21, 8, 23, 31, 32, 33));
        Lotto userLotto = new Lotto(user);
        Lotto lottoTicket = new Lotto(ticket);

        Method method = LottoService.class.getDeclaredMethod("calculateOverlappingNumber", Lotto.class, Lotto.class);
        method.setAccessible(true);
        int overlappingNumber = (int) method.invoke(lottoService, userLotto, lottoTicket);

        assertEquals(3, overlappingNumber);
    }

    @Test
    public void 스코어_체크() throws Exception {
        ArrayList<Integer> user = new ArrayList<>(Arrays.asList(21, 8, 23, 41, 42, 43));
        Lotto userLotto = new Lotto(user);
        CountScoreResponseDTO countScoreResponseDTO = new CountScoreResponseDTO();
        int overlappingNumber = 3;
        int bonus = 41;

        Method method = LottoService
                .class
                .getDeclaredMethod("calculateScore",
                        Lotto.class,
                        int.class,
                        CountScoreResponseDTO.class,
                        int.class);
        method.setAccessible(true);

        method.invoke(lottoService, userLotto, bonus, countScoreResponseDTO, overlappingNumber);

        assertEquals(1, countScoreResponseDTO.getFifthPlace());
    }

    @Test
    public void 수익률_정산() throws Exception {
        int lottoLength = 1;
        CountScoreResponseDTO countScoreResponseDTO = new CountScoreResponseDTO();
        countScoreResponseDTO.plusFifthPlace();

        Method method = LottoService
                .class
                .getDeclaredMethod("calculateRateOfReturn",
                        int.class,
                        CountScoreResponseDTO.class);
        method.setAccessible(true);

        double rateOfReturn = (double) method.invoke(lottoService, lottoLength, countScoreResponseDTO);

        assertEquals(500.0, rateOfReturn);
    }
}
