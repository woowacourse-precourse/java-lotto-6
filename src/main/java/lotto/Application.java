package lotto;

public class Application {
    public static void main(String[] args) {
        View view = new View();
        view.printMessage(Cmd.START_CMD);                   // 구입금액을 입력해주세요.
        view.inputUser(Cmd.INPUT_MONEY);                    // 구입금액 입력
        view.printMessage(Cmd.PRINT_NUMBEROFLOTTO);         // n개를 구매했습니다.
        Control.createLotto();                              // 로또 번호 생성
        view.printMessage(Cmd.PRINT_LOTTO_NUMBER);          // 로또 번호 출력
        view.printMessage(Cmd.PRINT_CORRECT_LOTTO_NUMBER);  // 당첨 번호를 입력해주세요.
        view.inputUser(Cmd.INPUT_CORRECT_LOTTO_NUMBER);     // 당첨 번호 입력
        view.printMessage(Cmd.PRINT_BONUS_NUMBER);          // 보너스 번호를 입력해 주세요.
        view.inputUser(Cmd.INPUT_BONUS_NUMBER);             // 보너스 번호 입력
        Control.calculateLotto();                           // 결과 계산
        view.printMessage(Cmd.RESULT);                      // 결과 출력
        // TODO: 프로그램 구현
    }
}
