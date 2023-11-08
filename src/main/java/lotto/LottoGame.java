package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.io.UserInput;
import lotto.io.UserOutput;

public class LottoGame {

    private final UserInput input;
    private final UserOutput output;
    private final LottoMachine lottoMachine;
    private final LottoInputParser lottoInputParser;
    private final LottoComparator lottoComparator;

    public LottoGame(UserInput input,
            UserOutput output,
            LottoMachine lottoMachine,
            LottoInputParser lottoInputParser,
            LottoComparator lottoComparator) {
        this.input = input;
        this.output = output;
        this.lottoMachine = lottoMachine;
        this.lottoInputParser = lottoInputParser;
        this.lottoComparator = lottoComparator;
    }

    public void play() {
        LottoPurchaseAmount lottoPurchaseAmount = createLottoPurchaseAmount();

        List<Lotto> lottos = createLottos(lottoPurchaseAmount);

        WinningLotto winningLotto = createWinningLotto();

        List<LottoResult> lottoResults = compareLottos(winningLotto, lottos);
    }

    public UserOutput getOutput() {
        return output;
    }

    private LottoPurchaseAmount createLottoPurchaseAmount() {
        output.print("구입금액을 입력해 주세요.\n");

        String purchaseAmount = input.input();

        return new LottoPurchaseAmount(purchaseAmount);
    }

    private List<Lotto> createLottos(LottoPurchaseAmount lottoPurchaseAmount) {
        output.print(String.format("%n%d개를 구매했습니다.%n", lottoPurchaseAmount.getTicketsCount()));

        List<Lotto> lottos = lottoMachine.issueAutomatically(lottoPurchaseAmount);

        lottos.forEach(lotto -> output.print(lotto.toString() + "\n"));

        return lottos;
    }

    private WinningLotto createWinningLotto() {
        output.print("\n당첨 번호를 입력해 주세요.\n");

        String inputWinningNumbers = input.input();
        List<Integer> winningNumbers = lottoInputParser.parseIntegerList(inputWinningNumbers);

        output.print("보너스 번호를 입력해 주세요.\n");

        String inputBonusNumber = input.input();
        int bonusNumber = lottoInputParser.parseInt(inputBonusNumber);

        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private List<LottoResult> compareLottos(WinningLotto winningLotto, List<Lotto> lottos) {
        List<LottoResult> lottoResults = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottoResults.add(lottoComparator.compare(winningLotto, lotto));
        }
        return lottoResults;
    }
}
