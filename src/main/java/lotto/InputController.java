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
}
