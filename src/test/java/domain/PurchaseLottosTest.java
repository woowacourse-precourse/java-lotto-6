package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName    : domain
 * fileName       : PurchaseLottosTest
 * author         : qkrtn_ulqpbq2
 * date           : 2023-11-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-06        qkrtn_ulqpbq2       최초 생성
 */
public class PurchaseLottosTest {
    @DisplayName("구매한 만큼 로또 번호 생성 - 3개의 로또가 모두 서로 다른 숫자로 이루어졌는지 확인")
    @Test
    void createRandomLottoNumbers() {
        PurchaseLottos purchaseLottos = new PurchaseLottos(3);

        for (int index = 0; index < purchaseLottos.getPurchaseLottos().size(); index++) {
            List<Integer> lotto = purchaseLottos.getPurchaseLottos().get(index).getNumbers();

            assertThat(lotto.size()).isEqualTo(6);
            assertThat(lotto.stream().distinct().count() == lotto.size()).isTrue();
            assertThat(lotto.stream().allMatch(number -> number >= 1 && number <= 45)).isTrue();
        }
    }
}
