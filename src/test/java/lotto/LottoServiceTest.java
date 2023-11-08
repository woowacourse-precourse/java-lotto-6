package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.service.LottoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    private LottoService lottoService;
    @BeforeEach
    public void setup() {
        lottoService = new LottoService();
    }

    @DisplayName("입력받은 금액이 횟수로 정상적으로 변경되는가?")
    @Test
    void testInitMoneyToCount() {
        int count = lottoService.initMoneyToCount("14000");

        assertEquals(14, count);
    }


    @DisplayName("User객체와 로또번호가 정상적으로 생성되는가")
    @Test
    void testInitUser() {
        lottoService.initUser(5);
        User user = lottoService.user;

        assertNotNull(user);
        assertEquals(5, user.getCount());
        List<Lotto> lottos = user.getLottos();
        assertEquals(5, lottos.size());

        for(Lotto lotto: lottos) {
            List<Integer> numbers = lotto.getNumbers();
            assertNotNull(numbers);
            assertEquals(6, numbers.size());
        }
    }


    @DisplayName("당첨번호가 정상적으로 생성되는가?")
    @Test
    void testInitWinningNumbers() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);


        lottoService.initWinningNumbers(numbers);
        Lotto winningLotto = lottoService.winningLotto;
        List<Integer> winningNumbers = winningLotto.getNumbers();

        assertNotNull(winningNumbers);
        assertEquals(6, winningNumbers.size());
        assertEquals(1, winningNumbers.get(0));
        assertEquals(2, winningNumbers.get(1));
        assertEquals(3, winningNumbers.get(2));
        assertEquals(4, winningNumbers.get(3));
        assertEquals(5, winningNumbers.get(4));
        assertEquals(6, winningNumbers.get(5));

    }

    @DisplayName("문자열에서 숫자로 변환이 되는가?")
    @Test
    void testParseAndValidateWinningNumbers() {
        String input = "1,2,3,4,5,6";
        List<Integer> winningNumbers = lottoService.parseAndValidateWinningNumbers(input);

        assertNotNull(winningNumbers);
        assertEquals(6, winningNumbers.size());
        assertEquals(1, winningNumbers.get(0));
        assertEquals(2, winningNumbers.get(1));
        assertEquals(3, winningNumbers.get(2));
        assertEquals(4, winningNumbers.get(3));
        assertEquals(5, winningNumbers.get(4));
        assertEquals(6, winningNumbers.get(5));
    }

    @DisplayName("보너스번호가 정상적으로 생성되는가?")
    @Test
    void testInitBonusNumber() {
        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,6);

        lottoService.initWinningNumbers(winningNumbers);
        lottoService.initBonusNumber(7);

        assertEquals(7, lottoService.bonusNumber);

    }


}
