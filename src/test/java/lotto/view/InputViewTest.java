package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    @AfterEach
    void afterEach() {
        Console.close();
    }

    @Test
    void 구입금액_입력_테스트() {
        String inputPurchaseAmount = "1000";
        InputStream inputStream = new ByteArrayInputStream(inputPurchaseAmount.getBytes());
        System.setIn(inputStream);

        assertThat(InputView.readPurchaseAmount()).isEqualTo(Integer.parseInt(inputPurchaseAmount));
    }

    @Test
    void 구입금액_문자입력_예외테스트() {
        String inputPurchaseAmount = "abcd";
        InputStream inputStream = new ByteArrayInputStream(inputPurchaseAmount.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(InputView::readPurchaseAmount).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입금액_1000단위입력_예외테스트() {
        String inputPurchaseAmount = "1222";
        InputStream inputStream = new ByteArrayInputStream(inputPurchaseAmount.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(InputView::readPurchaseAmount).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입금액_최대금액_테스트() {
        String inputPurchaseAmount = "100000";
        InputStream inputStream = new ByteArrayInputStream(inputPurchaseAmount.getBytes());
        System.setIn(inputStream);

        assertThat(InputView.readPurchaseAmount()).isEqualTo(Integer.parseInt(inputPurchaseAmount));
    }

    @Test
    void 구입금액_최대금액_예외테스트() {
        String inputPurchaseAmount = "100001";
        InputStream inputStream = new ByteArrayInputStream(inputPurchaseAmount.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(InputView::readPurchaseAmount).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호_입력_테스트() {
        String inputWinningNumbers = "1,2,3,4,5,6";
        InputStream inputStream = new ByteArrayInputStream(inputWinningNumbers.getBytes());
        System.setIn(inputStream);

        String[] split = inputWinningNumbers.split(",");
        List<Integer> inputDataNumbers = Arrays.stream(split).map(Integer::parseInt).toList();
        List<Integer> testWinningNumbers = InputView.readWinningNumbers();

        assertThat(testWinningNumbers.get(0)).isEqualTo(inputDataNumbers.get(0));
        assertThat(testWinningNumbers.get(1)).isEqualTo(inputDataNumbers.get(1));
        assertThat(testWinningNumbers.get(2)).isEqualTo(inputDataNumbers.get(2));
        assertThat(testWinningNumbers.get(3)).isEqualTo(inputDataNumbers.get(3));
        assertThat(testWinningNumbers.get(4)).isEqualTo(inputDataNumbers.get(4));
        assertThat(testWinningNumbers.get(5)).isEqualTo(inputDataNumbers.get(5));
    }

    @Test
    void 당첨번호_6자리입력_예외테스트1() {
        String inputWinningNumbers = "1,2,3,4,5";
        InputStream inputStream = new ByteArrayInputStream(inputWinningNumbers.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(InputView::readWinningNumbers).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호_6자리입력_예외테스트2() {
        String inputWinningNumbers = "1,2,3,4,5,7,300";
        InputStream inputStream = new ByteArrayInputStream(inputWinningNumbers.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(InputView::readWinningNumbers).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호_문자입력_예외테스트() {
        String inputWinningNumbers = "1,2,3,4,5,a";
        InputStream inputStream = new ByteArrayInputStream(inputWinningNumbers.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(InputView::readWinningNumbers).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호_공백입력_예외테스트() {
        String inputWinningNumbers = "1,,3,4,5,6";
        InputStream inputStream = new ByteArrayInputStream(inputWinningNumbers.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(InputView::readWinningNumbers).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호_공백입력_예외테스트2() {
        String inputWinningNumbers = "1,3,4,5,6,";
        InputStream inputStream = new ByteArrayInputStream(inputWinningNumbers.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(InputView::readWinningNumbers).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호_범위_예외테스트1() {
        String inputWinningNumbers = "1,46,3,4,5,6";
        InputStream inputStream = new ByteArrayInputStream(inputWinningNumbers.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(InputView::readWinningNumbers).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호_범위_예외테스트2() {
        String inputWinningNumbers = "-1,2,3,4,5,6";
        InputStream inputStream = new ByteArrayInputStream(inputWinningNumbers.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(InputView::readWinningNumbers).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호_범위_예외테스트3() {
        String inputWinningNumbers = "0,2,3,4,5,6";
        InputStream inputStream = new ByteArrayInputStream(inputWinningNumbers.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(InputView::readWinningNumbers).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호_중복_예외테스트() {
        String inputWinningNumbers = "1,1,3,4,5,6";
        InputStream inputStream = new ByteArrayInputStream(inputWinningNumbers.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(InputView::readWinningNumbers).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호_입력_테스트() {
        String inputBonusNumber = "7";
        InputStream inputStream = new ByteArrayInputStream(inputBonusNumber.getBytes());
        System.setIn(inputStream);

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThat(InputView.readBonusNumber(winningNumbers)).isEqualTo(Integer.parseInt(inputBonusNumber));
    }

    @Test
    void 보너스번호_문자입력_예외테스트() {
        String inputBonusNumber = "a";
        InputStream inputStream = new ByteArrayInputStream(inputBonusNumber.getBytes());
        System.setIn(inputStream);

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> InputView.readBonusNumber(winningNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호_범위_테스트1() {
        String inputBonusNumber = "1";
        InputStream inputStream = new ByteArrayInputStream(inputBonusNumber.getBytes());
        System.setIn(inputStream);

        List<Integer> winningNumbers = Arrays.asList(2, 3, 4, 5, 6, 7);

        assertThat(InputView.readBonusNumber(winningNumbers)).isEqualTo(Integer.parseInt(inputBonusNumber));
    }

    @Test
    void 보너스번호_범위_테스트2() {
        String inputBonusNumber = "45";
        InputStream inputStream = new ByteArrayInputStream(inputBonusNumber.getBytes());
        System.setIn(inputStream);

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThat(InputView.readBonusNumber(winningNumbers)).isEqualTo(Integer.parseInt(inputBonusNumber));
    }

    @Test
    void 보너스번호_범위_예외테스트1() {
        String inputBonusNumber = "0";
        InputStream inputStream = new ByteArrayInputStream(inputBonusNumber.getBytes());
        System.setIn(inputStream);

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> InputView.readBonusNumber(winningNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호_범위_예외테스트2() {
        String inputBonusNumber = "-1";
        InputStream inputStream = new ByteArrayInputStream(inputBonusNumber.getBytes());
        System.setIn(inputStream);

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> InputView.readBonusNumber(winningNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호_범위_예외테스트3() {
        String inputBonusNumber = "46";
        InputStream inputStream = new ByteArrayInputStream(inputBonusNumber.getBytes());
        System.setIn(inputStream);

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> InputView.readBonusNumber(winningNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호_중복_예외테스트1() {
        String inputBonusNumber = "1";
        InputStream inputStream = new ByteArrayInputStream(inputBonusNumber.getBytes());
        System.setIn(inputStream);

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> InputView.readBonusNumber(winningNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호_중복_예외테스트2() {
        String inputBonusNumber = "14";
        InputStream inputStream = new ByteArrayInputStream(inputBonusNumber.getBytes());
        System.setIn(inputStream);

        List<Integer> winningNumbers = Arrays.asList(11,12,13,14,15,16);

        assertThatThrownBy(() -> InputView.readBonusNumber(winningNumbers)).isInstanceOf(IllegalArgumentException.class);
    }
}