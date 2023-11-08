package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {

    private LottoGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new LottoGenerator();
    }

    @DisplayName("Lotto 클래스의 객체를 생성한다.")
    @Test
    void createInstanceOfLottoClass() {
        assertThat(generator.createSingleLotto())
                .isInstanceOf(Lotto.class);
    }

    @DisplayName("6개의 숫자를 가진 로또 번호를 생성한다.")
    @Test
    void createLottoWithSixNumbers() {
        assertThat(generator.createSingleLotto()
                .getNumbers()
                .size())
                .isEqualTo(6);
    }

    @DisplayName("1~45 사이의 숫자만 가진 로또 번호를 생성한다.")
    @Test
    void createNumberRangeFrom1to45Lotto() {
        Lotto lotto = generator.createSingleLotto();

        assertThat(lotto.getNumbers()
                .stream()
                .max(Integer::compareTo)
                .orElseThrow())
                .isLessThanOrEqualTo(45);

        assertThat(lotto.getNumbers()
                .stream()
                .min(Integer::compareTo)
                .orElseThrow())
                .isGreaterThanOrEqualTo(1);
    }

    @DisplayName("중복이 없는 숫자를 가진 로또 번호를 생성한다.")
    @Test
    void createNotDuplicatedLottoNumbers() {
        assertThat(generator.createSingleLotto()
                .getNumbers()
                .stream()
                .distinct()
                .toList()
                .size())
                .isEqualTo(6);
    }

}