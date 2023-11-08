package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottosListTest {

    private LottosList lottosList;

    @BeforeEach
    public void setUp() {
        lottosList = new LottosList();

    }

    @DisplayName("로또 번호 중복되지 않는 6개 번호 만들기")
    @Test
    void generateUniqueNumbers() {
        LottosList lottosList = new LottosList();
        List<Integer> list = lottosList.generateUniqueNumbers();
        HashSet<Integer> set = new HashSet<>(list);
        assertThat(list.size()).isEqualTo(set.size());
    }

    @DisplayName("입력 받은 구입 금액에 해당하는 로또 개수 생성")
    @Test
    public void createLottos() {
        lottosList.createLottos(5);
        assertThat(lottosList.getLottosList().size()).isEqualTo(5);

    }

    @DisplayName("금액 입력 시 양의 정수가 아니거나 1000단위로 입력 안할시 예외발생 ")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "01", "qwe", "!2", "R2", "%$", "1778", "2500"})
    void validatePrice(String price) {
        assertThatThrownBy(() -> new LottosList(price))
                .isInstanceOf(IllegalArgumentException.class);
    }

}