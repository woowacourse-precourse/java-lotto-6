package lotto.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputTest {
    private final InputStream originalIn = System.in;
    private Input input;

    @BeforeEach
    void setUp() {
        input = new Input();
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalIn);
    }

    @DisplayName("유효한 로또 구매 금액 입력을 받아 그에 따른 로또 수를 반환한다.")
    @Test
    void inputValidateNumberOfLotto() {
        String data = "1000\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        int lottoCount = input.inputValidateNumberOfLotto(1000);
        assertEquals(1, lottoCount);
    }

    /*
        Lotto를 제외한 사용자 입력이 들어가는 클래스에 대한 예외 처리를 domain 생성 시에 진행하지 않고,
        Input 작성 시 바로 검증하도록 진행하였더니 막혀버렸습니다.
        domain 생성자에 예외 처리를 중복 적용하면 쉽게 작성할 수 있지만,
        Input을 통해 적용해보고 싶어 우선 과제는 아쉽지만 여기서 마무리하고
        Input 테스트문 작성에 대해 공부하여 테스트를 성공시켜보도록 하겠습니다!
     */
}
