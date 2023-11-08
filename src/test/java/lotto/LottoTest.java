package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class LottoTest {
    private static final String NUMBERS_SIZE_ERROR = "[ERROR] 로또 번호는 6개를 입력해야 합니다.";

    private List<LottoNumber> lottoNumbers;

    @BeforeEach
    void setUpLottoNumbers() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<LottoNumber> lottoNumbers = numbers.stream().map(LottoNumber::new).toList();
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    @AfterEach
    void removeLottoNumbers() {
        lottoNumbers.clear();
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        addLottoNumber(7);

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> createLotto(lottoNumbers));
        assertTrue(thrown.getMessage().equals(NUMBERS_SIZE_ERROR));
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        addLottoNumber(this.lottoNumbers.get(0).getNumber());

        assertThatThrownBy(() -> createLotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또에 해당 로또 번호가 있으면 true를 반환한다.")
    @Test
    void checkLottoByDuplicateLottoNumber() {
        LottoNumber lottoNumber = lottoNumbers.get(0);
        LottoNumber duplicateLottoNumber = createLottoNumber(lottoNumber.getNumber());

        assertThat(this.lottoNumbers.contains(createLottoNumber(duplicateLottoNumber.getNumber()))).isTrue();
    }

    @DisplayName("로또에 해당 로또 번호가 없으면 false를 반환한다.")
    @Test
    void checkLottoByNonDuplicateLottoNumber() {
        LottoNumber NonduplicateLottoNumber = new LottoNumber(45);

        assertThat(this.lottoNumbers.contains(NonduplicateLottoNumber)).isFalse();
    }

    private Lotto createLotto(List<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    private LottoNumber createLottoNumber(int number) {
        return new LottoNumber(number);
    }

    private void addLottoNumber(int number) {
        this.lottoNumbers.add(new LottoNumber(number));
    }
}