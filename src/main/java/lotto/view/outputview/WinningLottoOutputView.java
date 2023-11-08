package lotto.view.outputview;

import lotto.dto.OutputDto;
import lotto.view.OutputView;
import lotto.view.ParameterConfig;

import java.util.Map;

public final class WinningLottoOutputView implements OutputView {
    private final Map<String, Runnable> methods = Map.ofEntries(
            Map.entry(ParameterConfig.WINNING_LOTTO_NUMBERS, this::viewWinningNumberText),
            Map.entry(ParameterConfig.BONUS_NUMBER, this::viewBonusNumberText)
    );

    @Override
    public void view(Map<String, OutputDto> model) {
        model.keySet().forEach(this::runMethod);
    }

    private void viewWinningNumberText() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    private void viewBonusNumberText() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    private void runMethod(String key) {
        if (methods.containsKey(key)) {
            methods.get(key).run();
        }
    }
}
