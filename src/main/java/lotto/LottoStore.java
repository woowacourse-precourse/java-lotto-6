package lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.CommandLine.input;
import static lotto.CommandLine.showln;

public class LottoStore {

    private final Seller seller;
    private final LottoGenerateMachine generateMachine;
    private final LottoDrawMachine drawMachine;
    private final List<Lotto> lottos;

    public LottoStore(
            LottoGenerateMachine generateMachine,
            LottoDrawMachine drawMachine
    ) {
        this.seller = new Seller();
        this.generateMachine = generateMachine;
        this.drawMachine = drawMachine;
        this.lottos = new ArrayList<>();
    }

    public void startSelling() {
        this.lottos.addAll(
                generateMachine.generate(
                        seller.sellTickets()
                )
        );
    }

    public void drawSetup() {
        showln("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = inputWinningNumbers();

        showln("보너스 번호를 입력해 주세요.");
        Integer bonusNumber = inputBonusNumber();

        showln("");
        drawMachine.setup(winningNumbers, bonusNumber);
    }

    public void draw() {
        for (Lotto lotto : lottos) {
            this.drawMachine.draw(lotto);
        }
        this.drawMachine.showResult();
    }

    private Integer inputBonusNumber() {
        String input = input("");
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            showln("[ERROR] 숫자만 입력해주세요.");
            return inputBonusNumber();
        }
    }

    private List<Integer> inputWinningNumbers() {
        String input = input("");
        if (input.isBlank()) {
            showln("[ERROR] 공백은 입력할 수 없습니다.");
            return inputWinningNumbers();
        }

        String[] numbers = input.split(",");
        if (numbers.length != 6) {
            showln("[ERROR] 당첨 번호는 6개 입력 해야 합니다.");
            return inputWinningNumbers();
        }

        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : numbers) {
            int num = Integer.parseInt(number);
            if (num < 1 || num > 45) {
                showln("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                return inputWinningNumbers();
            }
            winningNumbers.add(num);
        }
        return winningNumbers;
    }
}
