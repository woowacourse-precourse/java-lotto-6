package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoGameMachine {

    final Calculator calculator = new Calculator();

    public int insertLottoPayment() {
        int insertAmount = 0;
        while (true) {
            try {
                System.out.println("구입금액을 입력해주세요.");
                insertAmount = Integer.parseInt(Console.readLine());
                validateLottoPayment(insertAmount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 금액은 1000원 단위로 입력해주세요.");
            }
        }
        return insertAmount / 1000;
    }

    public void validateLottoPayment(int insertAmount) {
        if (insertAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로 입력해주세요.");
        }
    }

    public List<Lotto> issueLotto(int insertAmount) {
        System.out.println(insertAmount + "개를 구매했습니다.");
        List<Lotto> lottos = new ArrayList<>();
        // 받은 숫자만큼 로또 발행
        for (int i = 0; i < insertAmount; i++) {
            List<Integer> lottoNumbers = createNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    public void arrangeAscendingOrder(List<Lotto> issuedLottoNumbers) {
        for (Lotto lotto : issuedLottoNumbers) {
            System.out.println(lotto.toString());
        }

    }

    public List<Integer> createNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();
        while (lottoNumbers.size() < 6) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!lottoNumbers.contains(randomNumber)) {
                lottoNumbers.add(randomNumber);
            }
        }
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public List<Integer> insertWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumberInput = Console.readLine();
        return makingListFromString(winningNumberInput);
    }

    public List<Integer> makingListFromString(String winningNumberInput) {
        List<Integer> winningLottoNumber = new ArrayList<>();
        String[] input = winningNumberInput.split(",");
        for (String inputValue : input) {
            int number = Integer.parseInt(inputValue);
            winningLottoNumber.add(number);
        }
        return winningLottoNumber;
    }

    public int insertBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public Map<Lotto, Integer> compareNumbers(List<Integer> winningLottoNumber, List<Lotto> issuedLottoNumbers) {
        Map<Lotto, Integer> hitNumberLottoMap = new HashMap<>();
        for (Lotto lotto : issuedLottoNumbers) {
            int count = 0;
            for (int i = 0; i < winningLottoNumber.size(); i++) {
                if (lotto.getNumbers().contains(winningLottoNumber.get(i))) {
                    count++;
                }
            }
            hitNumberLottoMap.put(lotto, count);
        }
        return hitNumberLottoMap;
    }

    public Map<Integer, Integer> printResult(Map<Lotto, Integer> hitNumberLottoMap, int bonusNumber) {
        System.out.println("\n당첨 통계\n---");
        Map<Integer, Integer> winningHistory = calculator.calculateWinningHistory(hitNumberLottoMap, bonusNumber);
        calculator.printWinningHistory(winningHistory);
        return winningHistory;
    }


}
