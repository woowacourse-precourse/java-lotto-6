package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RunApplicationTest {

    private final RunApplication runApplication = new RunApplication();

    @DisplayName("로또 구매비용을 입력할 때는 천원단위로 입력해야한다.")
    @Test
    void getCostOfLottoWhen천원으로안나누어짐() throws Exception {
        //given
        String cost = "1200";

        //when //then
        assertThatThrownBy(() -> {
            command(cost);
            runApplication.getCostOfLottoWithChainedException();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또를 구매한 수량만큼 로또가 생성되고 각 로또는 6개의 숫자를 가진다.")
    @Test
    void getMyLottoNumbers() throws Exception {
        //given
        int numberOfLotto = 10;

        //when
        List<List<Integer>> myLottoNumbers = runApplication.getMyLottoNumbers(numberOfLotto);

        //then
        assertThat(myLottoNumbers).hasSize(10);
        assertThat(myLottoNumbers.stream().allMatch(numbers -> numbers.stream().distinct().toList().size() == 6)).isTrue();
    }

    @DisplayName("당첨 번호를 입력할 떄는 1~45 사이의 정수만을 입력해야한다.")
    @Test
    void getLottoNumbersWhen1과45사이의정수입력() throws Exception {
        //given
        Lotto lotto = new Lotto(List.of(0, 1, 2, 3, 4, 5));

        //when
        boolean notNumberIn1And45 = runApplication.isNotNumberIn1And45(lotto);

        // then
        assertThat(notNumberIn1And45).isTrue();
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}