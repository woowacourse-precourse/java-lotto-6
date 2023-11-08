package lotto;

public final class Constants {
    public static final int MIN = 1;
    public static final int MAX = 45;
    public static final int LOTTONUMBER = 6; // 로또 1 번 할 때 뽑는 숫자의 갯수
    public static final int LOTTOCOST = 1000;
    public static final String ERROR_MESSAGE = "[ERROR]";
    public static final String MESSAGE_INSTRUCTION = ERROR_MESSAGE +
            " " + Constants.LOTTONUMBER +
            " 개의 서로 다른 숫자를 쉼표로 구분하여 입력해 주세요(" +
            Constants.MIN + " ~ " + Constants.MAX + ").";
    public static final String MESSAGE_INSTRUCTION_BONUS = ERROR_MESSAGE +
            " 당첨 번호와 중복되지 않는 하나의 숫자를 입력해야 합니다(" +
            Constants.MIN +
            " ~ "+ Constants.MAX+
            ").";
}
