//package lotto;
//
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//import java.util.ArrayList;
//import java.util.List;
//import lotto.model.Lotto;
//import lotto.model.User;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//class UserTest {
//    @DisplayName("입력한 비용이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
//    @Test
//    void createPaymentByIndivisibleByThousand() {
//        assertThatThrownBy(() -> new User(1004))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @DisplayName("금액을 입력 시, 사용자의 금액, 구매한 로또 개수, 구매한 로또 번호들이 올바르게 초기화되었는지 확인.")
//    @Test
//    void testUserInit() {
//        int payment = 3000;
//        User user = new User(3000);
//        assertEquals(payment, user.payment());
//        assertEquals(payment / 1000, user.numberOfPurchase());
//        assertNotNull(user.purchasedLottoNumbers());
//        assertEquals(payment / 1000, user.purchasedLottoNumbers().size());
//        assertEquals(List.of(0,0,0,0,0,0), user.rankCount());
//    }
//
//    @DisplayName("당첨된 등수를 입력받으면 해당하는 등수 횟수 증가 확인")
//    @Test
//    void testIncreaseRankCount() {
//        User user = new User(1000);
//        for (int i=1;i<6;i++) {
//            user.increaseRankCount(i);
//            assertEquals(1, user.rankCount().get(i));
//        }
//    }
//}
