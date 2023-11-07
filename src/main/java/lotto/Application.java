package lotto;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	public static void main(String[] args) {
		int countLotto = countLotto(inputMoney());
		// 금액과 발행 가능한 로또 개수 확인
		List<Lotto> lottoList = makeLotto(countLotto);
		// 구매 가능한 수만큼 로또 발행
		printLottoList(lottoList);
		// 발행한 로또 목록 출력
		
		System.out.println();
		Lotto lotto = inputUserLotto(); // 당첨 번호 생성
		
		System.out.println();
		int bonus = bonusInput(); // 보너스 번호
		
		System.out.println();
		printResult(lottoList); // 통계 결과 출력
	}

	public static int inputMoney() {
		System.out.println("구입금액을 입력해 주세요.");
		return Integer.parseInt(Console.readLine());
	}
	
	public static int countLotto(int money) { // 구매한 횟수 계산
		if (money % 1000 != 0)
			throw new IllegalArgumentException();

		System.out.println();
		System.out.println(money / 1000 + "개를 구매했습니다.");
		return money / 1000;
	}

	public static List<Integer> getLotto() {
		return Randoms.pickUniqueNumbersInRange(1, 45, 6);
	} // 로또 발행

	public static List<Lotto> makeLotto(int count) {
		List<Lotto> lottoRandomList = new ArrayList<Lotto>();

		for (int i = 0; i < count; i++) {
			lottoRandomList.add(new Lotto(getLotto()));
		}

		return lottoRandomList; // 발행 로또 목록
	}

	public static void printLottoList(List<Lotto> lottoList) {
		// 로또 리스트 출력
		for (Lotto lotto : lottoList) {
			System.out.println(lotto.toString());
		}
	}

	public static Lotto inputUserLotto() { // 당첨 로또 입력
		System.out.println("당첨 번호를 입력해 주세요.");
		List<Integer> number = new ArrayList<Integer>();

		for (String num : Console.readLine().split(","))
			number.add(Integer.parseInt(num));

		countSize(number);
		validate(number);
		Lotto lotto = new Lotto(number);

		return lotto;
	}

	public static List<Integer> validate(List<Integer> lottoNum) throws IllegalArgumentException {
		// 로또 번호 유효성 검사
		for (int temp : lottoNum)
			if (temp > 45)
				throw new IllegalArgumentException();
		
		return lottoNum;
	}

	public static void countSize(List<Integer> calculateSize) {
		// 로또 사이즈 검사
		if (calculateSize.size() > 6)
			throw new IllegalArgumentException();
	}

	public static int bonusInput() { // 보너스 번호 입력
		System.out.println("보너스 번호를 입력해 주세요.");
		return Integer.parseInt(Console.readLine());
	}

	public static void printResult(List<Lotto> lottoList) {
		System.out.println("당첨 통계");
		System.out.println("---");
		System.out.println();

		System.out.println("3개 일치 (5,000원) - " + num + "개");
		System.out.println("4개 일치 (50,000원) - " + num + "개");
		System.out.println("5개 일치 (1,500,000원) - " + num + "개");
		System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + num + "개");
		System.out.println("6개 일치 (2,000,000,000원) - " + num + "개");
		System.out.println("총 수익률은 " + percentage + "%입니다.");
	}
	
}
