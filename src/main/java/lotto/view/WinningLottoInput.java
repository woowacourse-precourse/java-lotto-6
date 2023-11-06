package lotto.view;

public class WinningLottoInput {

    private static final String WINNIG_LOTTO_MESSAGE = "당첨 번호를 입력해 주세요.";

    public static void winnigLottoInput() {
        String numbers = UserInput.userInput();
        validateWinning(numbers);
    }

    public static void validateWinning(String numbers) {

    }

}
