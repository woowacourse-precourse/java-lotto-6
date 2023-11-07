package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TODO : 클래스 작성 컨벤션 확인하기
class DrawingLotto {


    public void getResult() {
        //TODO : client의 속성에 접근하기 위해 당첨번호와 로또번호를 나타내기 위한 클래스를 만든다 -> 로또 시스템을 나타내는 도메인을 따로 뺀다
        //TODO : setwinningNumber메서드에 파라메터를 둬서 LottoService의 속성을 이용하지 않도록 한다
    }

    public static WinnigNumber winnigLotto() {
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
