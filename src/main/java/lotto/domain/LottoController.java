package lotto.domain;
import lotto.domain.UserInput;
import lotto.ui.OutputView;

public class LottoController {
    private int lottoAmount;
    public void startGame() {
        UserInput userInput = new UserInput();
        lottoAmount = userInput.setAmount();
        // 로또들 생성
        OutputView.printLotto(lottoAmount);
        // 당첨 번호 및 보너스 번호 입력
        // 당첨 통계 출력
    }
}
