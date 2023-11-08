package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
//        System.out.println(List.of(8, 21, 23, 41, 42, 43).sort();
        View view = new View();
        view.printMessage(Cmd.START_CMD);                   // 구입금액을 입력해주세요.
        view.inputMoney();                                  // 구입금액 입력
        view.printMessage(Cmd.PRINT_NUMBEROFLOTTO);         // n개를 구매했습니다.
        Control.createLotto();                              // 로또 번호 생성
//        System.out.println(Control.lottos.get(0).getNumbers().getClass());
        view.printMessage(Cmd.PRINT_LOTTO_NUMBER);          // 로또 번호 출력
        view.printMessage(Cmd.PRINT_CORRECT_LOTTO_NUMBER);  // 당첨 번호를 입력해주세요.
        view.inputCorrectLottoNumber();                     // 당첨 번호 입력
        view.printMessage(Cmd.PRINT_BONUS_NUMBER);          // 보너스 번호를 입력해 주세요.
        view.inputBonusNumber();                            // 보너스 번호 입력
        Control.calculateLotto();                           // 결과 계산
        view.printMessage(Cmd.RESULT);                      // 결과 출력
    }
}
