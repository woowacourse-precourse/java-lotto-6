package lotto;

import java.util.List;
import lotto.io.UserInput;
import lotto.io.UserOutput;

public class LottoGame {

    private final UserInput userInput;
    private final UserOutput userOutput;
    private final LottoMachine lottoMachine;

    public LottoGame(UserInput userInput, UserOutput userOutput, LottoMachine lottoMachine) {
        this.userInput = userInput;
        this.userOutput = userOutput;
        this.lottoMachine = lottoMachine;
    }

    public void play() {
        LottoPurchaseAmount lottoPurchaseAmount = createLottoPurchaseAmount();

        List<Lotto> lottos = createLottos(lottoPurchaseAmount);


    }

    private LottoPurchaseAmount createLottoPurchaseAmount() {
        userOutput.print("구입금액을 입력해 주세요.\n");

        String purchaseAmount = userInput.input();

        return new LottoPurchaseAmount(purchaseAmount);
    }

    private List<Lotto> createLottos(LottoPurchaseAmount lottoPurchaseAmount) {
        userOutput.print(String.format("%n%d개를 구매했습니다.%n", lottoPurchaseAmount.getTicketsCount()));

        List<Lotto> lottos = lottoMachine.issueAutomatically(lottoPurchaseAmount);

        lottos.forEach(lotto -> userOutput.print(lotto.toString() + "\n"));

        return lottos;
    }
}
