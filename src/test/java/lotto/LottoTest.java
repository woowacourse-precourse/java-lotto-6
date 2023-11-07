package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.controller.LottoController;
import lotto.model.Amount;
import lotto.model.Lotto;
import lotto.record.LottoNumberRecord;
import lotto.record.LottoNumbers;
import lotto.view.InputViewImplementation;
import lotto.view.OutputViewImplementation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    private final LottoController lottoController;

    LottoTest() {
        this.lottoController = new LottoController(new InputViewImplementation(), new OutputViewImplementation());
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6, 7))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(new LottoNumbers(List.of(1, 2, 3, 4, 5, 5))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1 ~ 45 바깥의 값이 있으면 예외가 발생한다.")
    @Test
    void createLottoByUnderOrOverNumber() {
        assertThatThrownBy(() -> new Lotto(new LottoNumbers(List.of(0, 2, 3, 4, 5, 46))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("toRecord를 통하여 출력하는 값은 LottoRecord형태여야 한다.")
    void toRecord() {
        assertSimpleTest(
                () -> assertThat(new Lotto(new LottoNumbers(List.of(2, 3, 44, 32, 11, 20))).toRecord()).isInstanceOf(
                        LottoNumberRecord.class));
    }

    @Test
    @DisplayName("로또 번호는 정렬된 문자열로 반환되어야 한다.")
    void makeLottoNumberString() {
        assertSimpleTest(
                () -> assertThat(
                        new Lotto(new LottoNumbers(List.of(2, 3, 44, 32, 11, 20))).makeLottoNumberString()).contains(
                        "[2, 3, 11, 20, 32, 44]")
        );
    }

    @Test
    @DisplayName("로또는 1000원에 1장씩 발행되어야 한다.")
    void buyLottoTest() {
        assertSimpleTest(
                () -> assertThat(
                        lottoController.buyLotto(new Amount("3000").getAmountCash()).lottoList().size())
                        .isEqualTo(3)
        );
    }
}