package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoController {

    private static int price;
    private static List<Integer> winNumber;
    private static IOController ioController;
    private static LottoGenerator lottoGenerator;
    private static List<Lotto> lottoList;

    private static Map<Integer,Integer> winLottoCount;
    private static int bonusNumber;

    public LottoController() {
        init();
        input();
        compareTotalLottoList();
        printResult();

    }

    private void input() {
        price = ioController.inputPrice();
        generateLottoNumber();
        winNumber = ioController.inputWinNumber();
        bonusNumber = ioController.inputBonusNumber();
    }

    private void printResult() {
        // 결과 출력하는 메서드
        //ioController.printResult();
    }

    private void compareTotalLottoList() {
        for(Lotto lotto : lottoList){
            compareLotto(lotto);
        }
        System.out.println("winLottoCount:"+winLottoCount);
    }

    private void compareLotto(Lotto lotto) {
        int matchedNumbers = 0;
        for (int userNumber : lotto.getNumbers()) {
            if (winNumber.contains(userNumber)) {
                matchedNumbers++;
            }
        }
        winLottoCount.put(matchedNumbers, winLottoCount.getOrDefault(matchedNumbers,0)+1);
    }

    private void generateLottoNumber() {
        int CountOfLotto = price/1000;

        System.out.println("\n"+CountOfLotto+InstructionMessage.PRINT_LOTTO_COUNT.getMessageText());

        for(int makeLotto=1;makeLotto<=CountOfLotto;makeLotto++){
            lottoList.add(new Lotto(makeRandomNumber()));
        }

        ioController.printUserLottoNumbers(lottoList);

    }

    public List<Integer> makeRandomNumber() {

        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }

    public static void init() {
        //IOController에서 금액, 당첨번호, 보너스 번호 입력받기
        lottoList=new LinkedList<>();
        lottoGenerator= new LottoGenerator();
        ioController = new IOController();
        winLottoCount= new HashMap<>();

    }
}
