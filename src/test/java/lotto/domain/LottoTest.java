package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import domain.LottoNumber;
import java.util.List;
import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {
    @Test
    @DisplayName("중복된 로또 번호로 인한 실패 테스트")
    void createLottoDuplicateLottoNumbersFailTest() {
        var lottoNumbers = List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(5)
        );

        assertThrows(IllegalArgumentException.class, new Lotto(lottoNumbers));
    }


    @DisplayName("로또 번호 개수 미만 테스트")
    void createLottoLessSizeFailTest() {
        var lottoNumbers = List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5)
        );

        assertThrows(IllegalArgumentException.class, new Lotto(lottoNumbers));
    }

    @Test
    @DisplayName("로또 번호 개수 초과 테스트")
    void createLottoOverSizeFailTest() {
        var lottoNumbers = List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6),
                new LottoNumber(7)
        );

        assertThrows(IllegalArgumentException.class, new Lotto(lottoNumbers));
    }
}
