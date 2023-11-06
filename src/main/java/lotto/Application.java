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

        System.out.println("구입금액을 입력해 주세요.");
        int money = input.inputLottoMoney();
        System.out.println();

        LottoShop lottoShop = new LottoShop(new LottoGenerator(), new Validate());
        List<Lotto> lottos = lottoShop.buyLotto(money);
        System.out.println();

        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto winningLotto = new Lotto(input.inputWinningNumber());
        System.out.println();

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = input.bonusNumber();
        System.out.println();

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
