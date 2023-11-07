package lotto.domain;

import lotto.exception.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PurchaseAmountTest {

    @DisplayName("구입 금액 입력 값이 빈 값 또는 숫자가 아닌 경우에 대한 예외 검증")
    @ValueSource(strings = {"", "hi", "10k"})
    @ParameterizedTest
    void notNumber(String input){
        //given, when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class
                                                                , ()-> new PurchaseAmount(input));

        //then
        assertThat(exception.getMessage()).isEqualTo(ExceptionMessage.NOT_NUMBER.get());
    }

    @DisplayName("구입 금액이 1보다 작을 경우에 대한 예외 검증")
    @ValueSource(strings = {"-1", "0", "-1000"})
    @ParameterizedTest
    void lessThanOneAmount(String input){
        //given, when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class
                                                                , ()-> new PurchaseAmount(input));

        //then
        assertThat(exception.getMessage()).isEqualTo(ExceptionMessage.NOT_NATURAL_NUMBER.get());
    }

    @DisplayName("구입 금액이 1000 단위가 아닌 경우에 대한 예외 검증")
    @ValueSource(strings = {"1500", "500"})
    @ParameterizedTest
    void notDivideUnit(String input){
        //given, when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class
                                                            , ()-> new PurchaseAmount(input));

        //then
        assertThat(exception.getMessage()).isEqualTo(ExceptionMessage.NOT_DIVIDE_UNIT.get(1000));
    }

    @DisplayName("수익률 계산")
    @Test
    void calculateProfit(){
        //given
        LuckyNumbers luckyNumbers = new LuckyNumbers(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new LottoNumber(7));

        PurchaseAmount purchaseAmount = new PurchaseAmount("2000");
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));    //1등
        Lotto lotto2 = new Lotto(List.of(7, 8, 3, 4, 5, 6));    //4등
        LottoTicket lottoTicket = new LottoTicket(List.of(lotto1,lotto2));

        //when
        WinningResults winningResult = new WinningResults(lottoTicket,luckyNumbers);
        double result = purchaseAmount.calculateProfit(winningResult.calculatePrizeSum());

        //then
        double expect = (Rank.FIRST.getAmount() + Rank.FOURTH.getAmount()) / 2000;
        assertThat(result).isEqualTo(expect);
    }

}