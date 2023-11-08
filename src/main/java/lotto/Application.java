package lotto;

import lotto.component.LottoArgumentResolver;
import lotto.component.LottoController;
import lotto.component.LottoViewResolver;
import lotto.context.ApplicationContext;
import lotto.domain.result.Result;
import lotto.dto.LottoArgument;

public class Application {

    private static ApplicationContext context;

    static {
        context = ApplicationContext.of();
    }

    public static void main(String[] args) {
        LottoArgument lottoArgument = LottoArgumentResolver.of(
                        context.getInputView(),
                        context.getPrinter(),
                        context.getValidator())
                .resolve();

        LottoController controller = context.getLottoController();
        Result result = controller.run(lottoArgument.getLottos(), lottoArgument.getWinning());

        LottoViewResolver viewResolver = context.getViewResolver();
        viewResolver.showResult(result);
    }
}
