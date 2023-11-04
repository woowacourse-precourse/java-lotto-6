package lotto.view;

import lotto.dto.LottoDto;

import java.util.List;

public class ConsoleOutputView implements OutputView {

    private static String USER_LOTTO_MESSAGE = "개를 구매했습니다.";

    private ConsoleOutputView() {
    }

    private static class ConsoleOutputViewHolder {
        private static ConsoleOutputView consoleOutputView = new ConsoleOutputView();
    }

    public static ConsoleOutputView getInstance() {
        return ConsoleOutputView.ConsoleOutputViewHolder.consoleOutputView;
    }

    @Override
    public void printUserLotto(List<LottoDto> lottoDtos) {
        print(lottoDtos.size() + USER_LOTTO_MESSAGE);
        lottoDtos.stream()
                .forEach(lottoDto -> print(lottoDto.getNumbers()));
    }
}
