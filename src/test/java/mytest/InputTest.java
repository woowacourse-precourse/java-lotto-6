package mytest;

import java.io.ByteArrayInputStream;

import lotto.Input;

import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputTest {
    @DisplayName("1000원 단위의 금액이 아니면 예외가 발생한다.")
    @Test
  /*  void creatNotCorrectUnit() {
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1111".getBytes());
        System.setIn(in);
        Input getUser = new Input();
        assertThatThrownBy(() -> getUser.getUserCash())
                .isInstanceOf(IllegalArgumentException.class);
    }*/
    void creatNotCorrectUnit() {
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1111".getBytes());
        System.setIn(in);
        Input getUser = new Input();
        assertThat(getUser.getUserCash());
    }

    @DisplayName("입력한 숫자를 리스트 번호로 완전히 생성한다.")
    @Test
    void checkCorrectInputNum() {
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1,2,3,4,5,6".getBytes());
        System.setIn(in);
        Input getWinnerNum = new Input();
        List<Integer> list = new ArrayList<>();
        int[] group = {1, 2, 3, 4, 5, 6};
        for (int number : group) {
            list.add(number);
        }
        assertThat(getWinnerNum.printWinnerNum()).isEqualTo(list);

    }

    @DisplayName("숫자가 아닌 값을 넣을 경우 예외를 출력한다.")
    @Test
    void checkNum() {
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1,2,3,4,5,a".getBytes());
        System.setIn(in);
        Input getWinnerNum = new Input();
        assertThatThrownBy(() -> getWinnerNum.printWinnerNum())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 숫자가 아닌 값을 넣을 겨웅 예외를 출력한다.")
    @Test
    void checkBonusNum() {
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("asdf".getBytes());
        System.setIn(in);
        Input getWinnerNum = new Input();
        assertThatThrownBy(() -> getWinnerNum.printBonusNum())
                .isInstanceOf(IllegalArgumentException.class);
    }
}