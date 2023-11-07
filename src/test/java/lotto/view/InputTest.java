package lotto.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class InputTest {

    private Input input;
    private InputStream in;

    public InputTest() {
        this.input = Input.getInstance();
    }

    @Test
    public void inputPurchaseAmount_정상작동() throws Exception {
        //Given
        String amount = "1000";
        in = new ByteArrayInputStream(amount.getBytes());
        System.setIn(in);

        //When
        int purchaseAmount = input.inputPurchaseAmount();

        //Then
        assertThat(purchaseAmount).isEqualTo(1000);
    }

    @Test
    public void inputNumbers_정상작동() throws Exception {
        //Given
        String numbers = "1,2,3,4,5,6";
        in = new ByteArrayInputStream(numbers.getBytes());
        System.setIn(in);

        //When
        List<Integer> inputNumbers = input.inputNumbers();

        //Then
        assertThat(inputNumbers).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }


    @Test
    public void inputBonusNumber_정상작동() throws Exception {
        //Given
        String number = "7";
        in = new ByteArrayInputStream(number.getBytes());
        System.setIn(in);

        //When
        int bonusNumber = input.inputBonusNumber();

        //Then
        assertThat(bonusNumber).isEqualTo(7);
    }


}