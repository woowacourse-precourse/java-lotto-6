package lotto;

import java.util.List;
import lotto.generator.InputGenerator;
import lotto.generator.LottoGenerator;
import lotto.input.Input;
import lotto.result.LottoResult;
import lotto.result.LottoResultType;
import lotto.shop.LottoShop;
import lotto.validate.Validate;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Validate validate = new Validate();
        Input input = new Input(new InputGenerator(), validate);

        final String ERROR_MESSAGE = "[ERROR]";

        int money = 0;
        List<Lotto> lottos;
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                money = input.inputLottoMoney();
                System.out.println();

                LottoShop lottoShop = new LottoShop(new LottoGenerator(), new Validate());
                lottos = lottoShop.buyLotto(money);
                System.out.println();

                break;
            } catch (IllegalArgumentException ex) {
                System.out.println(ERROR_MESSAGE + " " + ex.getMessage());
            }
        }

        Lotto winningLotto;
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                winningLotto = new Lotto(input.inputWinningNumber());
                System.out.println();

                break;
            } catch (IllegalArgumentException ex) {
                System.out.println(ERROR_MESSAGE + " " + ex.getMessage());
            }
        }

        int bonusNumber;
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                bonusNumber = input.bonusNumber();
                System.out.println();

                break;
            } catch (IllegalArgumentException ex) {
                System.out.println(ERROR_MESSAGE + " " + ex.getMessage());
            }
        }

        // 로또의 당첨 갯수 계산
        LottoResult lottoResult = new LottoResult();
        for(Lotto lotto: lottos) {
            int correctNumber = lotto.calculateCorrectCount(winningLotto);
            boolean checkBonus = lotto.numberInLotto(bonusNumber);

            LottoResultType lottoResultType = LottoResultType.findByCorrectNumberAndBonus(correctNumber, checkBonus);

            if(lottoResultType != null) {
                lottoResult.incrementCount(lottoResultType);
            }
        }

        // 당첨 통계 출력
        lottoResult.printWinnigStatistics(money);
    }
}
