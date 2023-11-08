package lotto.controller;

import lotto.contants.OutputEnum;
import lotto.domain.*;
import lotto.domain.generators.RandomLottoGenerator;
import lotto.domain.generators.WinningNumberGenerator;
import lotto.domain.services.Account;
import lotto.domain.services.LottoDrawer;
import lotto.util.Printer;
import lotto.controller.view.Output;

import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoController {
    public void start(){
        LottoDrawer lottoDrawer = new LottoDrawer(new Output(new Printer()));
        RandomLottoGenerator lottoGenerator = new RandomLottoGenerator();
        WinningNumberGenerator winningNumberGenerator = new WinningNumberGenerator();
        Account account = new Account(new Output(new Printer()));
        final int lottoPrice = 1000;

        System.out.println("구입금액을 입력해 주세요.");
        int amount;
        while(true){
            try {
                amount = Integer.parseInt(readLine());
                break;
            }
            catch (NumberFormatException e){
                System.out.println(OutputEnum.output.ERR_AMOUNT_MUST_BE_NUMBER.getDescription());
            }
        }
        int boughtLottoSize = amount/lottoPrice;
        System.out.println(boughtLottoSize+"개를 구매했습니다.");
        Map<Integer, List<Integer>> lottos = lottoGenerator.generate(boughtLottoSize);
        for(List<Integer> lottoNumber : lottos.values()){
            System.out.println(lottoNumber);
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumber;
        while (true){
            try {
                 winningNumber = winningNumberGenerator.generator(readLine());
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                continue;
            }
            try {
                Lotto lotto = new Lotto(winningNumber);
                break;
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus;
        while(true){
            try {
                 bonus = Integer.parseInt(readLine());
            }
            catch (NumberFormatException e){
                System.out.println(OutputEnum.output.ERR_BONUS_MUST_BE_NUMBER.getDescription());
                continue;
            }
            try {
                Lotto lotto = new Lotto(winningNumber);
                lotto.validateBonusNumberRange(bonus);
                lotto.validateBonusNumberDuplicated(bonus);
                break;
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        lottoDrawer.draw(lottos, winningNumber, bonus);
        account.profitAccount(lottoDrawer.draw(lottos, winningNumber, bonus), amount);
    }
}
