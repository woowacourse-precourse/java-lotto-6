package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        HashMap<LottoGrade, Integer> lottoResult = initLottoResultGrade();
        int inputTry = readInputPrice();
        List<Lotto> lottoList = makeLottoNumber(inputTry);
        Lotto correctNumber = readInputCorrectNumber();
        int bonusNumber = readBonusNumber(correctNumber);
        checkLottoResult(lottoResult, lottoList, correctNumber, bonusNumber);
    }

    private static void checkLottoResult(HashMap<LottoGrade, Integer> lottoResult, List<Lotto> lottoList, Lotto correctNumber, int bonusNumber) {
        for (Lotto userlotto : lottoList) {
            int correct = Lotto.countSameElements(userlotto, correctNumber);
            List<LottoGrade> lottoCalculatorList =
                    Arrays.stream(LottoGrade.values())
                            .filter(lotto -> lotto.getCorrect()==correct).collect(Collectors.toList());
            LottoGrade lottoGrade = getLottoGrade(bonusNumber, userlotto, lottoCalculatorList);
            lottoResult.put(lottoGrade, lottoResult.getOrDefault(lottoGrade, 0) + 1);
        }
    }

    private static LottoGrade getLottoGrade(int bonusNumber, Lotto userlotto, List<LottoGrade> lottoCalculatorList) {
        if((lottoCalculatorList.size()>1)){
            if(bonusNumberCorrect(bonusNumber, userlotto)){
                return LottoGrade.second;
            }
            return LottoGrade.third;
        }
        return lottoCalculatorList.get(0);
    }

    private static HashMap<LottoGrade, Integer> initLottoResultGrade() {
        HashMap<LottoGrade, Integer> lottoResult = new HashMap<>();
        lottoResult.put(LottoGrade.first, 0);
        lottoResult.put(LottoGrade.second, 0);
        lottoResult.put(LottoGrade.third, 0);
        lottoResult.put(LottoGrade.forth, 0);
        lottoResult.put(LottoGrade.fifth, 0);
        lottoResult.put(LottoGrade.sixth, 0);
        lottoResult.put(LottoGrade.seventh, 0);
        lottoResult.put(LottoGrade.zero, 0);
        return lottoResult;
    }

    private void initLottoResult() {

    }

    private static boolean bonusNumberCorrect(int bonusNumber, Lotto userlotto) {
        return userlotto.contains(bonusNumber);
    }

    private static int readBonusNumber(Lotto correctNumberList) {
        int bonusNumber;
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String inputBonusNumber = readLine();
                bonusNumber = Integer.parseInt(inputBonusNumber);
                validateOverLap(correctNumberList.contains(bonusNumber), "보너스와 당첨번호가 중복됩니다.");
                validateOverNumber45(bonusNumber);
                System.out.println("보너스번호를 추가합니다.");
                System.out.println(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    private static void validateOverLap(boolean contains, String s) {
        if (contains) {
            throw new IllegalArgumentException(s);
        }
    }

    private static Lotto readInputCorrectNumber() {
        List<Integer> correctNumberList = new ArrayList<>();
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String inputCorrectNumber = readLine();
                for (String correctNumber : inputCorrectNumber.split(",")) {
                    int correctNum = Integer.parseInt(correctNumber);
                    validateOverNumber45(correctNum);
                    correctNumberList.add(correctNum);
                }
                validateListSizeIs6(correctNumberList.size(), 6, "[ERROR] 6개의 당첨번호를 입력해주세요");
                return new Lotto(correctNumberList);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    private static void validateListSizeIs6(int size, int i, String s) {
        validateOverLap((size) != i, s);
    }

    private static void validateOverNumber45(int correctNum) {
        validateOverLap(correctNum > 45, "[ERROR] 45이하의 숫자를 선택해주세요");
    }

    private static List<Lotto> makeLottoNumber(int inputTry) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < inputTry; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> orderedList = new ArrayList<>(numbers);
            Collections.sort(orderedList);
            Lotto lotto = new Lotto(numbers);
            lottoList.add(lotto);
        }

        for (Lotto lottonum : lottoList) {
            System.out.println(lottonum.getNumbers());
        }
        return lottoList;
    }

    private static int readInputPrice() {
        int inputTry;
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int inputPrice = Integer.parseInt(readLine());
                validateThousandUnit(inputPrice);
                inputTry = (inputPrice / 1000);
                System.out.printf("\n%d개를 구매했습니다.\n", inputTry);
                return inputTry;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    private static void validateThousandUnit(int inputPrice) {
        validateListSizeIs6(inputPrice % 1000, 0, "[ERROR] 구입금액 단위는 1000원으로 나누어 떨어져야 합니다.");
    }
}
