package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

    @DisplayName("User객체와 로또번호가 정상적으로 생성되는가")
    @Test
    void testInitUser() {
        User user = lottoService.initUser(5);

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


}
