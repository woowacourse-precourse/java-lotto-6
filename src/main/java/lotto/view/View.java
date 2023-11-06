package lotto.view;

public interface View {
    static View generateLottoInputView() {
        return new LottoInputView();
    }

    static View generateLottoOutputView() {
        return new LottoOutputView();
    }
}
