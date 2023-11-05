package lotto.view;

public interface View {
    static View generateLottoInputView() {
        return new LottoInputView();
    }
}
