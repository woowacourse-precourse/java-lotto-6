package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
    public void lottoStart() {
        Money money = inputMoney();

        LottoList lottoList = randomLotto(money.getLottoCount());

        Lotto input_lotto = inputLotto();
        List<Integer> compare_lotto = lottoList.compareLotto(input_lotto);

        BonusLotto bonus_lotto = inputBonusLotto(input_lotto);
        List<Boolean> compare_bonus_lotto = lottoList.compareBonusLotto(bonus_lotto);

        Result result = new Result(compare_lotto, compare_bonus_lotto);
        result.calculateRateOfReturn(money.getMoney());
        result.printResult();
    }

    private LottoList randomLotto(int lottoCount) {
        LottoNumbers lottoNumbers = new LottoNumbers();
        LottoList lottoList = new LottoList(lottoNumbers.makeLottoList(lottoCount));
        lottoList.printLottoCount();
        lottoList.printLottoList();
        return lottoList;
    }

    public static Money inputMoney() {
        while (true) {
            System.out.println("\n구입금액을 입력해 주세요");
            String input = Console.readLine();
            try {
                return new Money(Integer.parseInt(input));
            } catch (NumberFormatException e) {
                System.out.println(ExceptionList.MONEYEXCEPTION.content());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Lotto inputLotto() {
        while (true) {
            System.out.println("\n당첨 번호를 입력해 주세요.");
            String input = Console.readLine();
            try {
                List<String> input_lotto = List.of(input.split(","));
                List<Integer> winning_lotto = input_lotto.stream().map(x -> Integer.parseInt(x))
                        .collect(Collectors.toList());
                return new Lotto(winning_lotto);
            } catch (NumberFormatException e) {
                System.out.println(ExceptionList.LOTTOEXCEPTION.content());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static BonusLotto inputBonusLotto(Lotto lotto) {
        while (true) {
            System.out.println("\n보너스 번호를 입력해 주세요.");
            String input = Console.readLine();
            try {
                BonusLotto bonusLotto = new BonusLotto(Integer.parseInt(input));
                bonusLotto.validateDuplicate(lotto, bonusLotto.getBonus());
                return bonusLotto;
            } catch (NumberFormatException e) {
                System.out.println(ExceptionList.BONUSLOTTOEXCETPION.content());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
