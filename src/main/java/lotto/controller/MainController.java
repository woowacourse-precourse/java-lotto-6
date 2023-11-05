package lotto.controller;

import java.util.List;
import java.util.stream.Collectors;
import lotto.controller.subcontroller.IssueLottoController;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.repository.BonusNumberRepository;
import lotto.domain.repository.WinningLottoRepository;
import lotto.view.InputView;
import lotto.view.OutputView;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;
    private IssueLottoController issueLottoController;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        initializeControllers();
    }

    private void initializeControllers() {
        issueLottoController = new IssueLottoController(inputView, outputView);
    }

    public void start() {
        issueLottoController.process();
        {
            List<Integer> winnings = inputView.inputWinningNumber();
            WinningLottoRepository.add(new Lotto(winnings));

            int bonus = inputView.inputBonusNumber();
            BonusNumberRepository.add(new BonusNumber(bonus));
        }
        {
            List<Integer> winnings = WinningLottoRepository.findWinningNumbers();
            System.out.println("\n당첨 번호: " + String.join(
                    ",", winnings.stream()
                            .map(String::valueOf)
                            .collect(Collectors.toList()))
            );

            int bonus = BonusNumberRepository.findBonusNumber();
            System.out.println("보너스 번호: " + bonus);
        }
    }
}
