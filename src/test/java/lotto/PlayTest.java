package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayTest {
    private Validate validate;
    private LottoChecker lottoChecker;
    private LottoResultPrinter lottoResultPrinter;

    @BeforeEach
    void setValidate() {
        validate = new Validate();
    }
    @BeforeEach
    void setLottoResult() {
        lottoChecker = new LottoChecker();
    }
    @BeforeEach
    void setLottoResultPrinter() {
        lottoResultPrinter = new LottoResultPrinter();
    }

    @DisplayName("1000원 단위가 아니면 예외 발생.")
    @Test
    void 천원_단위_테스트() {
        assertThatThrownBy(() -> validate.handleNonThousandUnit("10100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아니면 예외 발생.")
    @Test
    void 금액이_숫자가_아니면_예외_발생() {
        assertThatThrownBy(() -> validate.handleNonThousandUnit("1000ㄹ"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아니면 예외 발생.")
    @Test
    void 당첨_번호가_숫자가_아니면_예외_발생() {
        assertThatThrownBy(() -> validate.handleInvalidNumberCount("1000ㄹ"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 번호가 6개가 아니면 예외 발생.")
    @Test
    void 당첨_번호가_6개가_아니면_예외_발생() {
        assertThatThrownBy(() -> validate.handleInvalidNumberCount("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 번호가 1~45의 범위를 벗어나면 예외 발생.")
    @Test
    void 당첨_번호의_숫자_범위를_넘으면_예외_발생() {
        assertThatThrownBy(() -> validate.handleInvalidNumberCount("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아니면 예외 발생.")
    @Test
    void 보너스_번호가_숫자가_아니면_예외_발생() {
        assertThatThrownBy(() -> validate.handleInvalidNumberCount("1,2,3,4,5,ㅋ"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 보너스번호가 1~45의 범위를 벗어나면 예외 발생.")
    @Test
    void 보너스_번호가_숫자_범위를_넘으면_예외_발생() {
        assertThatThrownBy(() -> validate.handleInvalidNumberInput("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 당첨 번호가 중복이면 예외 발생.")
    @Test
    void 당첨_번호가_중복이면_예외_발생() {
        assertThatThrownBy(() -> validate.handleDuplicateNumbers(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 검증 테스트")
    @Test
    void 당첨_번호_검증_테스트() {
        List<Lotto> lottos = new ArrayList<>(); //구입한 로또
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottos.add(new Lotto(List.of(1,2,9,10,15,30)));
        lottos.add(new Lotto(List.of(7,8,11,17,40,43)));
        lottos.add(new Lotto(List.of(8,9,10,16,14,20)));
        lottos.add(new Lotto(List.of(13,15,17,19,28,44)));

        List<Integer> winnerNumbers = List.of(1,2,3,4,5,7); //당첨 번호
        int bonusNumber = 6; //보너스 번호
        List<LottoResult> lottoResults = lottoChecker.checkLottoNumbers(lottos, winnerNumbers,bonusNumber);
        long winningAmount = lottoResultPrinter.lottoResultPrinter(lottoResults);
        String result = lottoResultPrinter.calculateLottoProfitRate(winningAmount, lottos.size());

        assertThat(result).isEqualTo("총 수익률은 600000.0%입니다.");
    }

}
