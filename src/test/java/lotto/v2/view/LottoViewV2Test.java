package lotto.v2.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class LottoViewV2Test {

    @Mock
    private Console console;

    private LottoViewV2 lottoViewV2;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        lottoViewV2 = new LottoViewV2(console);
    }

}