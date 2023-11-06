package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.view.InputView;

//TODO : 클래스 작성 컨벤션 확인하기
class LottoService {
    private Client client;
    private Lotto winningNumber;

    public LottoService() {
        provideWinningNumber();
        this.winningNumber = setWinningNumber();
    }

    public void getResult() {
        //TODO : client의 속성에 접근하기 위해 당첨번호와 로또번호를 나타내기 위한 클래스를 만든다 -> 로또 시스템을 나타내는 도메인을 따로 뺀다
    }

    public Lotto setWinningNumber() {
        List<Integer> winningNumber = provideWinningNumber();
        return new Lotto(winningNumber);
    }

    private List<Integer> provideWinningNumber() {
        String inputWinningNumberString = inputWinningNumber();
        List<Integer> inputNumber = Stream.of(inputWinningNumberString.split(",\\s*"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return inputNumber;
    }

    private String inputWinningNumber() {
        String inputNumber = InputView.inputWinningLottoNumber();
        return inputNumber;
    }
}
