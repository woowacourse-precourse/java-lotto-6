package lotto.domain;

import java.util.List;
import lotto.common.consts.ErrorMessage;
import lotto.view.OutputView;

public class Lottos {
    private static final String LINE_WRAPPING = "\n";
    private final List<Lotto> lottos;


    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    private void validate(List<Lotto> lottos) {
        if (lottos == null) {
            OutputView.printError(ErrorMessage.NULL_ERROR_MESSAGE);
            throw new IllegalArgumentException(ErrorMessage.NULL_ERROR_MESSAGE);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto);
            sb.append(LINE_WRAPPING);
        }
        return sb.toString();
    }
}
