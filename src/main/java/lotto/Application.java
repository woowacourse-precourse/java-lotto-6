package lotto;

import lotto.controller.MachineController;

public class Application {
    public static void main(String[] args) {
        MachineController machineController = new MachineController();
        machineController.execution();
    }
}
