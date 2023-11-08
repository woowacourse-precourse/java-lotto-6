package lotto;

import java.util.List;
import lotto.io.UserInput;
import lotto.io.UserOutput;

public class LottoGame {

    private final UserInput userInput;
    private final UserOutput userOutput;
    private final LottoMachine lottoMachine;
    private final LottoInputParser lottoInputParser;

    public LottoGame(UserInput userInput, UserOutput userOutput, LottoMachine lottoMachine,
            LottoInputParser lottoInputParser) {
        this.userInput = userInput;
        this.userOutput = userOutput;
        this.lottoMachine = lottoMachine;
        this.lottoInputParser = lottoInputParser;
    }

    public void play() {
        LottoPurchaseAmount lottoPurchaseAmount = createLottoPurchaseAmount();

        List<Lotto> lottos = createLottos(lottoPurchaseAmount);

        WinningLotto winningLotto = createWinningLotto();
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

    private WinningLotto createWinningLotto() {
        userOutput.print("\n당첨 번호를 입력해 주세요.\n");

        String inputWinningNumbers = userInput.input();
        List<Integer> winningNumbers = lottoInputParser.parseIntegerList(inputWinningNumbers);

        userOutput.print("보너스 번호를 입력해 주세요.\n");

        String inputBonusNumber = userInput.input();
        int bonusNumber = lottoInputParser.parseInt(inputBonusNumber);

        return new WinningLotto(winningNumbers, bonusNumber);
    }
}
