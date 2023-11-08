package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoGameMachineTest {

    private LottoGameMachine lottoGameMachine;
    @BeforeEach
    void setUp() {
        lottoGameMachine = new LottoGameMachine();
    }
    @Test
    void validateLottoPayment() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            lottoGameMachine.validateLottoPayment(1200);
        });
    }


    @Test
    void insertLottoPayment() {
        assertEquals(2, lottoGameMachine.insertLottoPayment());
    }

    @Test
    void insertLottoPayment2() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            lottoGameMachine.insertLottoPayment();
        });
    }

    /*
    차후 확인 필요
    @Test
    void arrangeAscendingOrderTest1(){
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        Lotto lotto = new Lotto(numbers);
        List<Lotto> issuedLottoNumbers = new ArrayList<>();
        assertEquals("[1,2,3,4,5]",issuedLottoNumbers );

    }

     */
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }



}