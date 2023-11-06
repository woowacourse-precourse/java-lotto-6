package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import lotto.domain.PurchasePrice;
import lotto.view.InputView;
import org.junit.jupiter.api.BeforeEach;

public abstract class InputTest {
    private InputView inputView;

    @BeforeEach
    protected final void setUp() {
        inputView = new InputView();
    }

    protected PurchasePrice inputPurchasePrice() {
        return inputView.inputPurchasePrice();
    }

    protected final void run(final String... args) {
        try {
            command(args);
            runMethod();
        } finally {
            Console.close();
        }
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    protected abstract void runMethod();
}
