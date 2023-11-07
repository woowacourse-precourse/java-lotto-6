package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class VendorTest {
    @Test
    @DisplayName("로또 구매 가격 입력 시 로또 개수 반환")
    void buyLottoThroughVendor(){
        Vendor vendor = new Vendor();

        String input = "8000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int numOfLotto = vendor.setMoney();

        assertThat(numOfLotto).isEqualTo(8);
    }
}
