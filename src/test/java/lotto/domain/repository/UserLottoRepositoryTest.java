package lotto.domain.repository;

import java.util.List;
import java.util.NoSuchElementException;
import lotto.domain.Lotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserLottoRepositoryTest {
    private UserLottoRepository userLottoRepository;

    @BeforeEach
    void setUp() {
        userLottoRepository = new UserLottoRepository();
    }

    @Test
    @DisplayName("로또 목록을 저장 후 반환")
    void save() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        userLottoRepository.save(List.of(lotto));
        List<Lotto> userLotto = userLottoRepository.getUserLotto();
        assertThat(userLotto).isEqualTo(List.of(lotto));
    }

    @Test
    @DisplayName("로또 목록이 없을 경우 에러가 발생한다.")
    void error() {
        assertThatThrownBy(userLottoRepository::getUserLotto).isInstanceOf(NoSuchElementException.class);
    }

    @AfterEach
    public void afterEach(){
        userLottoRepository.clear();
    }

}