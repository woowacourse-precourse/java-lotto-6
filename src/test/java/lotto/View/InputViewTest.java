package lotto.View;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class InputViewTest {
    static InputView inputView = new InputView();

    @AfterEach
    void cleanUp() {
        Console.close();
    }

    @Test
    void numberListSplitInput() {
        System.setIn(new ByteArrayInputStream("1,2,3,4,5,6".getBytes()));
        assertThat(inputView.numberListSplitInput(6).containsAll(List.of(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void singleNumberInput() {
        System.setIn(new ByteArrayInputStream("5".getBytes()));
        assertThat(inputView.singleNumberInput() == 5);
    }

}