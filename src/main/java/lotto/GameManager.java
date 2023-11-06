package lotto;

import lotto.domain.LottoTickets;
import lotto.domain.LottoWinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameManager {

    private final InputView inputView;
    private final OutputView outputView;
    private LottoTickets lottoTickets;
    private LottoWinningNumbers lottoWinningNumbers;

    public GameManager(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void gameStart() {
        publishLottoTickets();
        generateLottoWinningNumbers();
    }

    private void publishLottoTickets() {
        try {
            int purchaseAmount = Integer.parseInt(inputView.readPurchaseAmount());
            lottoTickets = new LottoTickets(purchaseAmount);
            outputView.printPurchasedLottoTickets(lottoTickets);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            publishLottoTickets();
        }
    }

    private void generateLottoWinningNumbers() {
        try {
            String inputString = inputView.readWinningNumbers();
            List<String> splitInputString = Arrays.asList(inputString.split(","));
            List<Integer> winningNumbers = parseToIntegerList(splitInputString);
            lottoWinningNumbers = new LottoWinningNumbers(winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            generateLottoWinningNumbers();
        }
    }

    private List<Integer> parseToIntegerList(List<String> strings) {
        try {
            return strings.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 숫자로 입력해주세요.");
        }
    }
}
