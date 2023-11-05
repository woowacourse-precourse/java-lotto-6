package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameControllerTest {

    LottoGameController controller = new LottoGameController();


    @Test
    void 금액_입력_1000단위_확인() throws IOException {

        String wrongInputMoney = "1230030";

        InputStream in = new ByteArrayInputStream(wrongInputMoney.getBytes());
        System.setIn(in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        assertThatThrownBy(() -> controller.validateMoneyInput(tk.nextToken()))
                .isInstanceOf(IllegalArgumentException.class);
    }

}