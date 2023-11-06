package lotto.domain;

import lotto.Lotto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import main.java.lotto.domain.WinningLottos;

class CalculatorTest {

//    @Test
//    void checkmakeWinningLottoToList() {
//        WinningLottos winningLottos = new WinningLottos(Arrays.asList(
//                new Lotto(List.of(1, 2, 8, 9, 42, 45)),
//                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
//                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
//                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
//                new Lotto(List.of(13, 14, 16, 38, 42, 45))
//        ));
//
//        Calculator calculator = new Calculator();
//        System.out.println(calculator.makeWinningLottoToList(winningLottos));
//    }

    @Test
    void checkcalculateMatchLottoNumber() {
        Calculator calculator = new Calculator();
//        WinningLottos winningLottos = new WinningLottos(Arrays.asList(
//                new Lotto(List.of(1, 2, 8, 9, 42, 45)),
//                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
//                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
//                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
//                new Lotto(List.of(13, 14, 16, 38, 42, 45))
//        ));
        Lotto winningLotto = new Lotto(List.of(1,2,8,10,11,12));
        UserLotto userLotto = new UserLotto( List.of(1,2,8,9,42,45), 47);

        calculator.calculateMatchLottoNumber(userLotto, winningLotto);
    }

}