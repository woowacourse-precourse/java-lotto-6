package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import lotto.view.exception.InputException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
class InputViewTest {

    InputView inputView;

    public InputViewTest() {
        this.inputView = InputView.getInstance();
        System.setIn(createInputStream());
    }

    private InputStream createInputStream() {
        // 왜 순서가 반대로 들어가는 것인지..?
        List<InputStream> inputStreams = Arrays.asList(
                createUserInput("8888\n"),
                createUserInput("8880\n"),
                createUserInput("8800\n"), //3
                createUserInput("asdf\n"), //2
                createUserInput("8000\n") //1
        );

        return new SequenceInputStream(Collections.enumeration(inputStreams));
    }

    @Nested
    @DisplayName("로또 구입 금액 입력")
    class inputPurchaseAmount {
        @Test
        @Order(1)
        @DisplayName("성공")
        void inputPurchaseAmount_success() {
//            InputStream inputStream = createUserInput("8000\n");
//            System.setIn(inputStream);
            int purchaseAmount = inputView.inputPurchaseAmount();
            assertThat(purchaseAmount).isEqualTo(8000);
        }

        @Test
        @Order(2)
        @DisplayName("실패_문자 입력")
        void inputStringPurchaseAmount_fail() {
//            InputStream inputStream = createUserInput("asdf\n");
//            System.setIn(inputStream);
            assertThatThrownBy(() -> inputView.inputPurchaseAmount())
                    .isInstanceOf(InputException.class);
        }

        @Test
        @Order(3)
        @DisplayName("실패_1000원 단위가 아닌 숫자 입력")
        void inputNotDivide1000Number_fail() {
//            InputStream inputStream = createUserInput("8800\n");
//            System.setIn(inputStream);
            assertThatThrownBy(() -> inputView.inputPurchaseAmount())
                    .isInstanceOf(InputException.class);
            assertThatThrownBy(() -> inputView.inputPurchaseAmount())
                    .isInstanceOf(InputException.class);
            assertThatThrownBy(() -> inputView.inputPurchaseAmount())
                    .isInstanceOf(InputException.class);
        }
    }


    public static InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}