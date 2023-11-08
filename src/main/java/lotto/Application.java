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



        int money = 0;
        List<Lotto> lottos;
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                money = input.inputLottoMoney();
                System.out.println();

                // 로또 발행
                LottoShop lottoShop = new LottoShop(new LottoGenerator(), new Validate());
                lottos = lottoShop.buyLotto(money);
                System.out.println();

                break;
            } catch (IllegalArgumentException ex) {
                System.out.println(LottoConstants.ERROR_MESSAGE + " " + ex.getMessage());
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
                System.out.println(LottoConstants.ERROR_MESSAGE + " " + ex.getMessage());
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
                System.out.println(LottoConstants.ERROR_MESSAGE + " " + ex.getMessage());
            }
        }

        // 로또의 당첨 갯수 계산
        LottoResult lottoResult = new LottoResult(money);
        for(Lotto lotto: lottos) {
            int correctNumber = lotto.calculateCorrectCount(winningLotto);
            boolean checkBonus = lotto.numberInLotto(bonusNumber);

            // 당첨 갯수와 보너스 번호에 따른 LottoResultType 검색
            LottoResultType lottoResultType = LottoResultType.findByCorrectNumberAndBonus(correctNumber, checkBonus);

            // 당첨 타입에 맞는 갯수 증가
            if(lottoResultType != null) {
                lottoResult.incrementCount(lottoResultType);
            }
        }

        // 당첨 통계 출력
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n" ).append("---");
        System.out.println(sb);

        // 전체 당첨 갯수 출력
        lottoResult.printAllLottoResult();

        // 수익률 출력
        lottoResult.printRateOfReturn();
    }
}
