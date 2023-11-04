package Controller;


import Model.InputModel;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.*;
import java.util.stream.Collectors;

public class LottoController {
    List<Integer> winningLottoNumber;
    Map<String, Integer> correctLottoNumber = new HashMap<>();
    List<Lotto> lottoNumbers = new ArrayList<>();
    int payment, countOfLotto, bonusNumber;
    double total;

    InputManger inputManger;
    InputModel  inputModel;

    public LottoController(InputManger inputManger, InputModel inputModel) {
        this.inputManger = inputManger;
        this.inputModel = inputModel;
    }

    public void run() {
        initializeCorrectLottoNumberMap();
        System.out.println("구입금액을 입력해 주세요.");
        payment = inputManger.getPayment(Console.readLine());
        countOfLotto = payment / 1000;
        for(int i = 0; i < countOfLotto; i++) {
            lottoNumbers.add(createLotto());
            }
        System.out.println(countOfLotto + "개를 구매했습니다.");
        for(Lotto lotto : lottoNumbers) {
            System.out.println(lotto.getLottoArray());
        }
        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto lotto = gettingLottoWinningNumbers(Console.readLine());
        winningLottoNumber = lotto.getLottoArray();
        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber = Integer.parseInt(Console.readLine());
        winningLottoNumber.add(bonusNumber);
        System.out.println("당첨 통계");
        System.out.println("---");
        for(Lotto lottoNumber : lottoNumbers) {
            total += checkLottoNumber(lottoNumber);
        }
        for(String key : correctLottoNumber.keySet()) {
            System.out.println(key + " - " + correctLottoNumber.get(key) + "개");
        }
        System.out.println("총 수익률은 " + calculateAverage(total) + "%입니다.");
    }

    private String calculateAverage(double total) {
        return String.format("%.1f", total / payment * 100);
    }



    private double checkLottoNumber(Lotto lottoNumber) {
        List<Integer> checkLottoNumber = lottoNumber.getLottoArray();
        int count = 0;
        for (int i = 0; i < winningLottoNumber.size(); i++) {
            if (checkLottoNumber.contains(winningLottoNumber.get(i))) {
                count++;
            }
        }
        if (count == 6) {
            correctLottoNumber.put("6개 일치 (2,000,000,000원)", correctLottoNumber.get("6개 일치 (2,000,000,000원)") + 1);
            return 2000000000;
        } else if (count == 5 && checkLottoNumber.contains(bonusNumber)) {
            correctLottoNumber.put("5개 일치, 보너스 볼 일치 (30,000,000원)", correctLottoNumber.get("5개 일치, 보너스 볼 일치 (30,000,000원)") + 1);
            return 30000000;
        } else if (count == 5) {
            correctLottoNumber.put("5개 일치 (1,500,000원)", correctLottoNumber.get("5개 일치 (1,500,000원)") + 1);
            return 1500000;
        } else if (count == 4) {
            correctLottoNumber.put("4개 일치 (50,000원)", correctLottoNumber.get("4개 일치 (50,000원)") + 1);
            return 50000;
        } else if (count == 3) {
            correctLottoNumber.put("3개 일치 (5,000원)", correctLottoNumber.get("3개 일치 (5,000원)") + 1);
            return 5000;
        }
        return 0;
    }

    public void initializeCorrectLottoNumberMap() {
        correctLottoNumber.put("3개 일치 (5,000원)", 0);
        correctLottoNumber.put("4개 일치 (50,000원)", 0);
        correctLottoNumber.put("5개 일치 (1,500,000원)", 0);
        correctLottoNumber.put("5개 일치, 보너스 볼 일치 (30,000,000원)", 0);
        correctLottoNumber.put("6개 일치 (2,000,000,000원)", 0);
    }

    private Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public Lotto gettingLottoWinningNumbers(String lottoNumbers) {
        List<Integer> lottoNumbersArray = Arrays.stream(lottoNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new Lotto(lottoNumbersArray);

    }
}
