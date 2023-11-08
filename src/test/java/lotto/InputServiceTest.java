package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;


class InputServiceTest {
    InputService inputService = new InputService();

    @Test
    void IterWhenExceptionTest(){
        ByteArrayInputStream in = new ByteArrayInputStream("1,2,3,4,5\n1,2,3,4,5,6".getBytes());
        System.setIn(in);
        List<Integer> lottoNums = inputService.iterWhenException(inputService::winningNumbers);
        Assertions.assertThat(lottoNums).contains(1,2,3,4,5,6);
    }

}