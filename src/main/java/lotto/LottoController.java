package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedList;
import java.util.List;

public class LottoController {

    private static int price;
    private static List<Integer> winNumber;
    private static IOController ioController;
    private static LottoGenerator lottoGenerator;
    private static List<Lotto> LottoList;
    private static int bonusNumber;

    private void generateLottoNumber() {
        int CountOfLotto = price/1000;

        System.out.println("\n"+CountOfLotto+InstructionMessage.PRINT_LOTTO_COUNT.getMessageText());

        for(int makeLotto=1;makeLotto<=CountOfLotto;makeLotto++){
            LottoList.add(new Lotto(makeRandomNumber()));
        }

        ioController.printUserLottoNumbers(LottoList);

    }

    public List<Integer> makeRandomNumber() {

        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
}
