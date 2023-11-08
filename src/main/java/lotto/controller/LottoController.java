package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

/*
- [v] 로또 구입 금액을 입력받는 기능
    - [v] "구입금액을 입력해 주세요." 메시지를 출력하는 기능
- [v] 랜덤 메서드를 이용해서 중복되지 않는 숫자를 뽑는 기능 -> 컨트롤러에서 하기
- [v] 뽑은 숫자를 저장하는 기능 -> 이것도 컨트롤러
- [v] 로또를 발행하는 기능 -> 이것도 컨트롤러
- [ ] 당첨 번호를 입력받는 기능 -> 컨트롤러
    - [ ] 당첨 번호를 입력해 주세요. 메시지를 출력하는 기능
- [ ] 보너스 번호를 입력받는 기능 -> 컨트롤러
    - [ ] 보너스 번호를 입력해 주세요. 메시지를 출력하는 기능
- [ ] 당첨 여부와 등수를 계산하는 기능 -> 이건 계산 클래스에서 하자
- [ ] 수익률을 계산 하는 기능 -> 이것도 계산 클래스
- [ ] 당첨 통계를 출력하는 기능 -> 이건 컨트롤러(뷰에서 할까?)
    - [ ] 수익률을 출력하는 기능
- [ ] 예외가 발생했을 때 에러 메시지를 처리 하는 기능 -> 일단 컨트롤러에서 하고, 예외 클래스를 따로 둘지 생각해보기
- [ ] 예외가 발생한 다음 다시 입력을 받는 기능 */
// 이 컨트롤러에서는 로또 구입 금액 입력, 로또 발행(데이터 전달)을 구현
// 로또 구입 금액이 로또 클래스에 필요할까? ㄴㄴ, 로또 구입 금액은 로또컨트롤러에서만 필요
public class LottoController {
    final static int LOTTO_COUNTS = 6;
    final static int BONUS_COUNTS = 1;
    final static int MOD_VALUE = 1000;
    final static int MAX_LOTTO_PRICES = 2147483000;
    final static int MIN_LOTTO_PRICES = 1000;
    List<Lotto> lottos = new ArrayList<>();
    int lottoCounts;

    public void setLottoCounts(int lottoCounts) {
        this.lottoCounts = lottoCounts;
    }

    public String printLottoPrices() {
        return "[ERROR] 구입금액을 입력해 주세요.";
    }
    public int inputLottoPrices() {
        String confirmString = "";
        int lottoPrices = isInteger(confirmString);
        if(!isPriceLowerThanMax(lottoPrices)) {
            throw new IllegalArgumentException("[ERROR] 최대 구입 가능 금액은 " + MAX_LOTTO_PRICES + "원 입니다.");
        }
        if(!isPriceBiggerThanMin(lottoPrices)) {
            throw new IllegalArgumentException("[ERROR] 최소 구입 가능 금액은 " + MIN_LOTTO_PRICES + "원 입니다.");
        }
        if(!isPriceModZero(lottoPrices)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 " + MOD_VALUE + "원 단위 여야 합니다.");
        }
        setLottoCounts(lottoPrices % MOD_VALUE);
        return lottoPrices;
    }
    public int isInteger(String confirmString) {
        try {
            return Integer.parseInt(confirmString);
        } catch (NumberFormatException numberFormatException) {
        throw new IllegalArgumentException("[ERROR] 숫자만 입력하실 수 있습니다");
        }
    }
    public boolean isPriceLowerThanMax(int confirmInteger) {
        return confirmInteger < MAX_LOTTO_PRICES;
    }
    public boolean isPriceBiggerThanMin(int confirmInteger) {
        return confirmInteger >= MIN_LOTTO_PRICES;
    }
    public boolean isPriceModZero(int confirmInteger) {
        return confirmInteger % MOD_VALUE == 0;
    }

    public List<Integer> GenerateRandomNumber() {
        List<Integer> lottoNumbers = new ArrayList<>();
        lottoNumbers = pickUniqueNumbersInRange(1,45,6);
        return lottoNumbers;
    }
    public void saveLottoNumbers(List<Integer> lottoNumbers) {
        lottos.add(new Lotto(lottoNumbers));
    }
    public void iterateLottos() {
        for (int i = 0; i < lottoCounts; i++) {
            saveLottoNumbers(GenerateRandomNumber());
        }
    }
    public String printPrizeNumbers() {
        return "당첨 번호를 입력해 주세요.";
    }
    public List<Integer> inputPrizeNumbers() {
        List<Integer> prizeNumbers = new ArrayList<>();
        try {
            String confirmString = Console.readLine();
            prizeNumbers.addAll(splitPrizeNumbers(confirmString));
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하실 수 있습니다.");
        }
        return prizeNumbers;
    }
    public List<Integer> splitPrizeNumbers(String confirmString) {
        List<String> testing = List.of(confirmString.split(","));
        List<Integer> prizeNumbers = new ArrayList<>();
        for (String splited:
                testing) {
            if(!isInRangeNumber(Integer.parseInt(splited))) {
                throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자만 입력하실 수 있습니다.");
            }
            prizeNumbers.add(Integer.parseInt(splited));
        }
        return prizeNumbers;
    }
    public String printBonusNumber() {
        return "보너스 번호를 입력해 주세요.";
    }
    public boolean isInRangeNumber(int confirmInteger) {
        return confirmInteger >= 1 && confirmInteger <= 45;
    }

    public void run() {
        System.out.println(printLottoPrices());
        inputLottoPrices();
        iterateLottos();

        System.out.println(printPrizeNumbers());
        inputPrizeNumbers();
        System.out.println(printBonusNumber());
    }



    // 순서 - 상수, 클래스 변수
    // 인스턴스 변수
    // 생성자
    // 메서드
}
