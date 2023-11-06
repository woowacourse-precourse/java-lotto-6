package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.Exception.LottoNumbersException;

public class Application {
    public static void main(String[] args) {

        LottoMachine lottoMachine = new LottoMachine();

        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        System.out.println();

        lottoMachine.insertMoney(input);
        List<Lotto> lottoBundle = lottoMachine.giveLottoBundle();
        checkLottoBundle(lottoBundle);
        System.out.println();

        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winNumbers = numbersSeparator(Console.readLine());
        LottoNumbersException.validatLottoNumbers(winNumbers);

    }

    static void checkLottoBundle(List<Lotto> lottoBundle) {
        Integer lottoCount = lottoBundle.size();
        System.out.println(lottoCount + "개를 구매했습니다.");

        for (Lotto lotto : lottoBundle) {
            System.out.println(lotto.lottoFormat());
        }
    }

    static List<Integer> numbersSeparator(String numberString) {
        List<String> separatedNumbersInString = List.of(numberString.split(","));

        List<Integer> separatedNumbers = new ArrayList<Integer>();
        for (String number : separatedNumbersInString) {
            separatedNumbers.add(Integer.parseInt(number));
        }

        return separatedNumbers;
    }


}
