package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TODO : 클래스 작성 컨벤션 확인하기
class DrawLotto {
    public static WinnigNumber draw() {
        List<Integer> winningNumber = provideWinningNumber();
        return WinnigNumber.is(Lotto.of(winningNumber), provideBonusNumber());
    }

    private static List<Integer> provideWinningNumber() {
        String WinningNumberString = InputHandler.inputWinningNumber();
        List<Integer> inputNumber = Stream.of(WinningNumberString.split(",\\s*"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return inputNumber;
    }

    private static int provideBonusNumber() {
        int bonus = InputHandler.inputBonusNumber();
        return bonus;
    }
}
