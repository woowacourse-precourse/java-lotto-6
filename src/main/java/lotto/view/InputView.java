package lotto.view;

public abstract class InputView {
    protected abstract String read();

    protected abstract void println(final String text);

    public int getInputMoney() {
        println("구입금액을 입력해 주세요.");
        final String input = read();
        return convertStringToInt(input);
    }

    private int convertStringToInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수만 입력할 수 있습니다.", e);
        }
    }
}
