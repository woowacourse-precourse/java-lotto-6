package lotto.controller;

import lotto.domain.LottoAdmin;
import lotto.domain.LottoCalculater;
import lotto.domain.User;
import lotto.output.LottoRateOfReturn;
import lotto.output.LottoStatistics;

public class LottoController {

    public void lottoStart() {
        // 유저가 당첨 금액 입력
        User user = new User();
        inputMoney(user);

        System.out.println(user.getLottoCount() + "개를 구매했습니다.");
        // 발행한 로또 출력
        user.getLottos().forEach(System.out::println);
        System.out.println();

        // 로또 어드민이 당첨 번호 + 보너스 번호 입력
        LottoAdmin lottoAdmin = new LottoAdmin();
        inputWinningNumber(lottoAdmin);
        inputBonusNumber(lottoAdmin);

        LottoCalculater lottoCalculater = new LottoCalculater(user,lottoAdmin);
        lottoCalculater.calculateResult();
        // 로또 계산기가 당첨 통계 출력
        LottoStatistics.printStatistics(lottoCalculater);
        // 로또 계산기가 수익률 출력
        LottoRateOfReturn.printRateOfReturn(lottoCalculater);
    }

    private void inputMoney(User user) {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            user.inputMoney();
            System.out.println();
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputMoney(user);
        }
    }

    private void inputWinningNumber(LottoAdmin lottoAdmin) {
        try {
            System.out.println("당첨 번호를 입력해 주세요.");
            lottoAdmin.inputWinningNumber();
            System.out.println();
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputWinningNumber(lottoAdmin);
        }
    }

    private void inputBonusNumber(LottoAdmin lottoAdmin) {
        try {
            System.out.println("보너스 번호를 입력해 주세요.");
            lottoAdmin.inputBonusNumber();
            System.out.println();
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputBonusNumber(lottoAdmin);
        }
    }
}
