package lotto.view;

import java.util.List;
import lotto.resolver.ExceptionResolver;

public class InputViewProxy implements InputViewable {

    private final InputViewable subjectView;

    public InputViewProxy(final InputViewable subjectView) {
        this.subjectView = subjectView;
    }

    @Override
    public int inputBuyingPrice() {
        return ExceptionResolver.resolveInput(subjectView::inputBuyingPrice);
    }

    @Override
    public List<Integer> inputLottoNumbers() {
        return ExceptionResolver.resolveInput(subjectView::inputLottoNumbers);
    }

    @Override
    public int inputBonusNumber() {
        return ExceptionResolver.resolveInput(subjectView::inputBonusNumber);
    }
}
