package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinLottoTest {
    @DisplayName(",로 구분되어 있는지 확인한다.")
    @Test
    void checkSortWithComma(){
        InputStream in = new ByteArrayInputStream("1.2.3.4.5.6.".getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> new WinLotto())
                .isInstanceOf(IllegalArgumentException.class);
    }


}
