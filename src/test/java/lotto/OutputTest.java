//package lotto;
//
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//
//import java.util.List;
//import lotto.model.Lotto;
//import lotto.model.Payment;
//import lotto.view.Output;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//class OutputTest {
//    @DisplayName("랜덤 생성된 로또 번호들 출력")
//    @Test
//    void createLottoNumbers() {
//        Payment payment = new Payment(5000);
//        assertThatThrownBy(() -> new Output().printPurchasedLottoNumbers(payment.getPurchasedLottoNumbers()))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//}
