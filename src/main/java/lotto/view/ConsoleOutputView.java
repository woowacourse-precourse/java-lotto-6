package lotto.view;

import lotto.dto.LottoDto;
import lotto.dto.LottoProfitResult;

import java.text.DecimalFormat;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class ConsoleOutputView implements OutputView {

    private static final String INTEGER_FORMAT = "#,###";
    private static final String DOUBLE_FORMAT = "#.##";

    @Override
    public void showLotto(LottoDto lottoDto) {
        List<Integer> numbersList = lottoDto.numbers();
        String result = numbersList.stream()
                .map(String::valueOf)
                .collect(joining(", ", "[", "]"));

        System.out.println(result);
    }

    @Override
    public void showMessage() {
        showMessage("");
    }


    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void showErrorMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void showResult(LottoProfitResult lottoProfitResult) {
        System.out.println("\n당첨 통계\n---");

        lottoProfitResult.profits().forEach(info -> System.out.println(formatResult(info)));

        String formattedPercent = formatNumber(lottoProfitResult.profitPercent());
        System.out.println("총 수익률은 " + formattedPercent + "%입니다.");
    }

    private String formatResult(LottoProfitResult.Info info) {
        String message = info.rank() + "개 일치";
        if (info.withBonus()) {
            message += ", 보너스 볼 일치";
        }
        message += " (" + formatNumber(info.price()) + "원) - " + info.count() + "개";
        return message;
    }

    private String formatNumber(Integer value) {
        DecimalFormat decimalFormat = new DecimalFormat(INTEGER_FORMAT);
        return decimalFormat.format(value);
    }

    private String formatNumber(Double value) {
        DecimalFormat decimalFormat = new DecimalFormat(DOUBLE_FORMAT);
        return decimalFormat.format(value);
    }

}
