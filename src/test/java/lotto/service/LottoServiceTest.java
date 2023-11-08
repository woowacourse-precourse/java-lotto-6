package lotto.service;

import static lotto.configurations.SettingValues.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import lotto.repository.LottoRepository;

import org.junit.jupiter.api.*;
import org.mockito.*;


class LottoServiceTest {

    @Mock
    private LottoRepository lottoRepository;

    @InjectMocks
    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("generateLotto() 테스트")
    void testGenerateLotto() {
        List<Integer> lottoNumbers = lottoService.generateLotto();
        List<Integer> confirmedNumbers = new ArrayList<>();

        for (Integer number : lottoNumbers) {
            assertTrue(number <= MAX_OF_RANGE.get());
            assertTrue(number >= MIN_OF_RANGE.get());
            assertFalse(confirmedNumbers.contains(number));
            confirmedNumbers.add(number);
        }

    }

}
