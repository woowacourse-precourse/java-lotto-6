package lotto;

import lotto.adapter.ConsoleOutputAdapter;
import lotto.adapter.UserInputAdapter;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        DrawController drawController = new DrawController(new UserInputAdapter(), new ConsoleOutputAdapter());
        drawController.draw();
    }
}
