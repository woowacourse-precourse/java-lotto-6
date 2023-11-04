package study;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MockitoTest {

    @Test
    void Mockito_테스트() {
        List<String> list = Mockito.mock(ArrayList.class);

        Mockito.when(list.get(0)).thenReturn("123");

        Assertions.assertThat(list.get(0)).isEqualTo("123");
    }
}
