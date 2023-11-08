package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.ArrayList;

public class LottoShop {
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;
	private static final int LOTTO_LENGTH = 6;
	
	private ArrayList<Lotto> lottos = new ArrayList<>();
	private final List<Integer> winningNumbers;
	private final int bonusNumber;

	public LottoShop() {
		int numberOfLotto = buyLotto();
		this.winningNumbers = decideWinningNumbers();
		this.bonusNumber = decideBonusNumber();
		generateLotto(numberOfLotto);
		System.out.println(this.getLottos().size() + "개를 구매했습니다.");
        for (Lotto lotto : this.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
		Console.close();
	}
    private int buyLotto() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String payment = Console.readLine();
                return Checker.checkPayment(payment);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                // 예외가 발생하면 사용자에게 다시 입력을 요청합니다.
            }
        }
    }

    private List<Integer> decideWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String winningInput = Console.readLine();
                return Checker.checkWinningInput(winningInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                // 예외가 발생하면 사용자에게 다시 입력을 요청합니다.
            }
        }
    }

    private int decideBonusNumber() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String bonusInput = Console.readLine();
                return Checker.checkBonusInput(this.winningNumbers, bonusInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                // 예외가 발생하면 사용자에게 다시 입력을 요청합니다.
            }
        }
    }
	
	private void generateLotto(int numberOfLotto){
		for (int i = 0; i < numberOfLotto; i++) {
			List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_LENGTH);
			Lotto lotto = new Lotto(numbers);
			this.lottos.add(lotto);
		}
	}

	public List<Integer> getWinningNumbers() {
		return this.winningNumbers;
	}

	public ArrayList<Lotto> getLottos() {
		return this.lottos;
	}

	public int getBonusNumber() {
		return this.bonusNumber;
	}
}
