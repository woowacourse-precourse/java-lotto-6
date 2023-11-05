package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest {

    private LottoMachine lottoMachine;

    @BeforeEach
    public void setUp() {
        lottoMachine = LottoMachine.getInstance();
    }

    @DisplayName("당첨 번호를 세팅하고 가져오는 기능 테스트")
    @Test
    public void given_SetWinningNumbers_when_GetWinningNumbers_then_ReturnsSetNumbers() {
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        lottoMachine.setWinningNumbers(winningNumbers);

        assertEquals(winningNumbers, lottoMachine.getWinningNumbers());
    }

    @DisplayName("보너스 번호를 세팅하고 가져오는 기능 테스트")
    @Test
    public void given_setBonusNum_when_GetBonusNum_then_returnSetBonusNum() {
        int bonusNum = 25;
        lottoMachine.setBonusNum(bonusNum);

        assertEquals(bonusNum, lottoMachine.getBonusNum());
    }

    @DisplayName("당첨 번호 세팅 시 유효성 검사 실패 테스트")
    @Test
    public void given_winningNumbers_when_SetWinningNumbers_then_ThrowsIllegalArgumentException() {
        List<Integer> invalidNumbers = List.of(1, 2, 3, 4, 5);

        assertThrows(IllegalArgumentException.class, () -> lottoMachine.setWinningNumbers(invalidNumbers));
    }

    @DisplayName("보너스 번호 세팅 시 유효성 검사 실패 테스트")
    @Test
    public void given_InvalidBonusNum_when_SetBonusNum_then_ThrowsIllegalArgumentException() {
        int bonusNum = 0;

        assertThrows(IllegalArgumentException.class, () -> lottoMachine.setBonusNum(bonusNum));
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복될 때 유효성 검사 실패 테스트")
    @Test
    public void given_DuplicateBonusNum_when_SetBonusNum_then_ThrowsIllegalArgumentException() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        lottoMachine.setWinningNumbers(winningNumbers);

        int duplicateBonusNum = 6;
        assertThrows(IllegalArgumentException.class, () -> lottoMachine.setBonusNum(duplicateBonusNum));
    }

    @DisplayName("5000원이 주어질 때, 5장의 로또를 계산한다.")
    @Test
    public void given_5000Won_when_CalculateNumberOfTickets_then_Returns5Tickets() {
        assertEquals(5, lottoMachine.calculateNumberOfTickets(5000));
    }

    @DisplayName("800원이 주어질 때, 예외가 발생한다.")
    @Test
    public void given_800Won_when_CalculateNumberOfTickets_then_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            lottoMachine.calculateNumberOfTickets(800);
        });
    }

    @Test
    @DisplayName("5000원이 주어질 때, 5장의 로또가 생성된다.")
    public void given_5000Won_when_PurchaseLottos_then_Returns5Lottos() {
        List<Lotto> lottos = lottoMachine.purchaseLottos(5000);

        assertEquals(5, lottos.size());
    }

    @Test
    @DisplayName("4500원이 주어질 때, 에러가 발생한다.")
    public void given_4500Won_when_Purchase_Lottos_then_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, ()->{
            lottoMachine.purchaseLottos(4500);
        });
    }
}