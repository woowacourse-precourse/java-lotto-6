package lotto;

import lotto.io.ConsoleUserInterface;

public class Application {
    public static void main(String[] args) {
        LottoMission mission = new LottoMission();
        try {
            mission.run();
        } catch (IllegalArgumentException e) {
            ConsoleUserInterface.printMessage(e.getMessage());
        }
    }
}
