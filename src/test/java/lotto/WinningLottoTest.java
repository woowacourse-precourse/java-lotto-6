package lotto;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import lotto.domain.LottoNumber;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {
    private static final String NUMBERS_DUPLICATE_ERROR = "[ERROR] 로또 번호와 보너스 번호는 중복 없이 입력해야 합니다.";

    private List<Integer> nonDuplicateNumbers;
    private List<Integer> duplicateNumbers;
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        this.duplicateNumbers = List.of(1, 1, 3, 4, 5, 6);
        this.nonDuplicateNumbers = List.of(1, 2, 3, 4, 5, 6);

        this.winningLotto = createWinningLotto(this.nonDuplicateNumbers);
        winningLotto.setBonusNumber(createBonusNumber(45));
    }

    @DisplayName("중복된 로또 번호는 예외를 반환한다.")
    @Test
    void createDuplicateLottoNumber() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> createWinningLotto(duplicateNumbers));
        assertTrue(thrown.getMessage().equals(NUMBERS_DUPLICATE_ERROR));
    }

    @DisplayName("보너스 번호와 동일한 로또 번호가 존재하면 예외를 반환한다.")
    @Test
    void createDuplicateBonusNumber() {
        WinningLotto winningLotto = createWinningLotto(nonDuplicateNumbers);
        LottoNumber bonusNumber = createBonusNumber(nonDuplicateNumbers.get(0));

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> winningLotto.setBonusNumber(bonusNumber));
        assertTrue(thrown.getMessage().equals(NUMBERS_DUPLICATE_ERROR));
    }

    private WinningLotto createWinningLotto(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream().map(LottoNumber::new).toList();
        return new WinningLotto(lottoNumbers);
    }

    private LottoNumber createBonusNumber(int number) {
        return new LottoNumber(number);
    }
}