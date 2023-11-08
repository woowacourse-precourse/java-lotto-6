package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PublishLottoUtilTest extends IOTest {

    private final PublishLottoUtil publishLottoUtil;

    public PublishLottoUtilTest() {
        this.publishLottoUtil = new PublishLottoUtil();
    }

    @Test
    void IoTest() {
        systemIn("1000");
        Scanner sc = new Scanner(System.in);
        String io = sc.nextLine();
        assertThat(io).isEqualTo("1000");
    }

    @Test
    @DisplayName("1000의 배수를 입력하면 1000으로 나눈 값만큼 로토를 구매한다.")
    void buyLottoTest() {
        systemIn("5000");
        int lottoCnt = publishLottoUtil.buyLotto();
        assertThat(lottoCnt).isEqualTo(5);
        assertThat(lottoCnt).isNotEqualTo(6);
    }

    @Test
    void publishLotto() {
    }

    @Test
    void showPublishedLotto() {
    }
}