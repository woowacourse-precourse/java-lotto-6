package lotto;

import java.util.List;

@FunctionalInterface
interface InputSupplierInt {
    int get();

}

@FunctionalInterface
interface InputSupplierList {
    List<Integer> get();
}

@FunctionalInterface
interface InputSupplierPlayer {
    Player get();
}

public class InputController {

    public static int getValidInput(InputSupplierInt inputSupplierInt) {
        while (true) {
            try {
                return inputSupplierInt.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> getValidInput(InputSupplierList inputSupplierList) {
        while (true) {
            try {
                return inputSupplierList.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Player getValidInput(InputSupplierPlayer inputSupplierPlayer) {
        while (true) {
            try {
                return inputSupplierPlayer.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
