package lotto.domain;

import lotto.io.InputPort;
import lotto.io.OutputPort;

public final class LottoServer {

    private final InputPort inputPort;
    private final OutputPort outputPort;

    public LottoServer(InputPort inputPort, OutputPort outputPort) {
        this.inputPort = inputPort;
        this.outputPort = outputPort;
    }

    public void run() {

    }
}
