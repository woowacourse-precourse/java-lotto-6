package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGame {

    private int purchaseAmount;
    private int numberOfPurchase;
    private LottoRepository lottoRepository = new LottoRepository();
    private String[] winningNumbers;
    private int bonusNumber;

    public void start() {
        System.out.println("구입 금액을 입력해주세요.");
        inputPurchaseAmount();
        printNumberOfPurchase();
        setRandomLottoNumber(this.numberOfPurchase);
        printRandomLottoNumber();
        inputWinningNumber();
        inputBonusNumber();

    }

    private void inputPurchaseAmount() {
        setPurchaseAmount(Integer.parseInt(readLine()));
    }

    private void setPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("1000원 단위로만 입력이 가능합니다.");
        } else if (purchaseAmount % 10 == 0) {
            this.purchaseAmount = purchaseAmount;
            this.numberOfPurchase = purchaseAmount / 1000;
        }
    }

    private void checkPurchaseAmount() {
        if (this.purchaseAmount % 10 != 0) {
            throw new IllegalArgumentException("1000원 단위로만 입력이 가능합니다.");
        }
    }

    private int getNumberOfPurchase() {
        return this.numberOfPurchase;
    }

    public void setNumberOfPurchase() {
        if (this.purchaseAmount % 10 == 0) {
            this.numberOfPurchase = purchaseAmount / 1000;
        }
    }

    private void printNumberOfPurchase() {
        System.out.println(getNumberOfPurchase() + "개를 구매했습니다.");
    }

    private void printRandomLottoNumber() {
        lottoRepository.printLottoNumbers();
        //System.out.println(lottoRepository.printLottoNumbers());
        //for(int i = 0 ; i < l)
        //System.out.println(lotto.getLotto());

    }

    private void setRandomLottoNumber(int numberOfPurchase) {
        for (int i = 0; i < numberOfPurchase; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            setLotto(numbers);
        }
    }

    private void setLotto(List<Integer> numbers) {
        Lotto lotto = new Lotto(numbers);
        lottoRepository.add(lotto);

        //System.out.println(lotto.getLotto());
    }

    private void inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumber;
        winningNumber = readLine();
        winningNumbers = winningNumber.split(",");
    }

    private void inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber = Integer.parseInt(readLine());
    }
}
