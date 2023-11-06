package lotto;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserIOTest {
    private UserIO userIO;

    @BeforeEach
    void setUP() {
        userIO = new UserIO();
        Console.close();
    }

    @DisplayName("getAmount에 대한 올바른 입력값")
    @Test
    void getAmountTest1() {
        ByteArrayInputStream in = new ByteArrayInputStream("34000".getBytes());
        System.setIn(in);
        assertEquals(34, userIO.getAmount());
    }

    @DisplayName("getAmount에 대해 1000으로 나누어 떨어지지 않는 입력값")
    @Test
    void getAmountTest2() {
        ByteArrayInputStream in = new ByteArrayInputStream("34001\n34000".getBytes());
        System.setIn(in);
        assertEquals(34, userIO.getAmount());
    }

    @DisplayName("getAmount에 대해 숫자가 아닌 입력값")
    @Test
    void getAmountTest3() {
        ByteArrayInputStream in = new ByteArrayInputStream("34001qw\n34000".getBytes());
        System.setIn(in);
        assertEquals(34, userIO.getAmount());
    }

    @DisplayName("getNumbersTest에 대한 올바른 입력값")
    @Test
    void getNumbersTest1() {
        ByteArrayInputStream in = new ByteArrayInputStream("1,3,5,7,9,11".getBytes());
        System.setIn(in);
        assertEquals(userIO.getNumbers(), List.of(1, 3, 5, 7, 9, 11));
    }

    @DisplayName("getNumbersTest에 대해 더 많은 입력값")
    @Test
    void getNumbersTest2() {
        ByteArrayInputStream in = new ByteArrayInputStream("1,3,5,7,9,11,13\n1,3,5,7,9,11".getBytes());
        System.setIn(in);
        assertEquals(userIO.getNumbers(), List.of(1, 3, 5, 7, 9, 11));
    }

    @DisplayName("getNumbersTest에 대해 숫자가 아닌 입력값")
    @Test
    void getNumbersTest3() {
        ByteArrayInputStream in = new ByteArrayInputStream("1,3,5,7,9,11,13\n1,3,5,7,9,11".getBytes());
        System.setIn(in);
        assertEquals(userIO.getNumbers(), List.of(1, 3, 5, 7, 9, 11));
    }

    @DisplayName("getNumbersTest에 대해 로또번호가 아닌 숫자 입력값")
    @Test
    void getNumbersTest4() {
        ByteArrayInputStream in = new ByteArrayInputStream("1,3,5,7,9,51\n1,3,5,7,9,11".getBytes());
        System.setIn(in);
        assertEquals(userIO.getNumbers(), List.of(1, 3, 5, 7, 9, 11));
    }

    @DisplayName("getBonusNumber에 대한 올바른 입력값")
    @Test
    void getBonusNumberTest1() {
        ByteArrayInputStream in = new ByteArrayInputStream("34".getBytes());
        System.setIn(in);
        assertEquals(34, userIO.getBonusNumber());
    }

    @DisplayName("getBonusNumber에 대해 숫자가 아닌 입력값")
    @Test
    void getBonusNumberTest2() {
        ByteArrayInputStream in = new ByteArrayInputStream("3fe\n34".getBytes());
        System.setIn(in);
        assertEquals(34, userIO.getBonusNumber());
    }

    @DisplayName("getBonusNumber에 대해 로또번호가 아닌 입력값")
    @Test
    void getBonusNumberTest3() {
        ByteArrayInputStream in = new ByteArrayInputStream("334\n34".getBytes());
        System.setIn(in);
        assertEquals(34, userIO.getBonusNumber());
    }
}
