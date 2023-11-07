package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.ArrayList;

public class LottoShop {
	private static final int LOTTO_PROCE = 1000;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;
	private static final int LOTTO_LENGTH = 6;
	private ArrayList<Lotto> lottos = new ArrayList<>();
	private final List<Integer> winningNumbers;
	private final int bonusNumber;
	public static int buyLotto(){
		System.out.println("구입금액을 입력해 주세요.");
		String payment = Console.readLine();
		int numberOfLotto = Checker.checkPayment(payment);
		Console.close();
		return numberOfLotto;
	}

	public List<Integer> decideWinningNumbers() {
		System.out.println("당첨 번호를 입력해 주세요.");
		String winningInput = Console.readLine();
		List<Integer> winningNumbers = Chekcer.checkWinningInput(winningInput);
		this.winningNumbers = winningNumbers;
		return this.winningNumbers;
	}

	public int decideBonusNumber() {
		System.out.println("보너스 번호를 입력해 주세요.");
		String bonusInput = Console.readLine();
		int bonusNumber = Checker.checkBonusInput(bonusInput);
		this.bonusNumber = bonusNumber;
		return this.bonusNumber;
	}
	
	private List<Lotto>generateLotto(){
		//TODO 로또 generate 구현
	}
}
