package lotto;

public class Inputter {
    private static Inputter inputter;

    private Inputter() {}

    public static Inputter getInputter() {
        if (inputter == null) {
            inputter = new Inputter();
        }
        return inputter;
    }

}
