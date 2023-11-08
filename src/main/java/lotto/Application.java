package lotto;

import console.Input;
import console.Output;

public class Application {
    public static void main(String[] args) {
        LottoController controller = LottoController.create(Input.create(), Output.create());
        controller.running();
    }
}
