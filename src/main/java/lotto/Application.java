package lotto;

import lotto.component.LottoArgumentResolver;
import lotto.component.LottoController;
import lotto.component.LottoViewResolver;
import lotto.context.ApplicationContext;
import lotto.domain.result.Result;
import lotto.dto.LottoArgumentDTO;

public class Application {

    private static ApplicationContext context;

    static {
        context = ApplicationContext.of();
    }

    public static void main(String[] args) {
        LottoArgumentDTO lottoArgumentDTO = LottoArgumentResolver.of(
                        context.getInputView(),
                        context.getPrinter(),
                        context.getValidator())
                .resolve();

        LottoController controller = context.getLottoController();
        Result result = controller.run(lottoArgumentDTO.getLottos(), lottoArgumentDTO.getWinning());

        LottoViewResolver viewResolver = context.getViewResolver();
        viewResolver.showResult(result);
    }
}
