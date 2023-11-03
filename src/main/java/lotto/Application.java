package lotto;

import java.util.*;

import camp.nextstep.edu.missionutils.*;

public class Application {
	public static void main(String[] args) {
		// TODO: 프로그램 구현
		int price;
		int lottoCount;
		// 로또 구입 금액을 입력받는 기능
		while (true) {
			System.out.println("구입금액을 입력해 주세요.");
			String input = Console.readLine();
			try {
				price = Integer.parseInt(input);
				check1000Unit(price);
				break;

			} catch (NumberFormatException e) {
				System.out.println("[ERROR] 숫자를 입력해 주세요.");
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println();

		// 발행한 로또 수량 및 번호를 출력하는 기능
		lottoCount = price / 1000;
		System.out.println(lottoCount + "개를 구매했습니다.");
		Map<Integer, List<Integer>> lotto = getLotto(lottoCount);
		for (Map.Entry<Integer, List<Integer>> entry : lotto.entrySet()) {
			System.out.println(sortInAsd(entry.getValue()));
		}
		
		System.out.println();
		
		//당첨 번호를 입력받는 기능
		while(true) {
			
			try {
				System.out.println("당첨 번호를 입력해 주세요.");
				String inputWinNumbers = Console.readLine();
				List<String> winNumbers = splitComma(inputWinNumbers);
				List<Integer> newWinNumbers = convertToInt(winNumbers);
				Lotto winLotto = new Lotto(newWinNumbers);
				break;
			} catch (NumberFormatException e) {
				System.out.println("[ERROR] 숫자를 입력해 주세요.");
			} catch (IllegalArgumentException e ) {
				System.out.println("[ERROR] 당첨 번호는 6개의 숫자입니다.");
			} catch (IllegalStateException e) {
				System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
			}
			
		}
	}

	// 1000원으로 나누어 떨어지는지 확인하는 메소드
	private static void check1000Unit(int price) {
		if ((price % 1000) != 0) {
			throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야합니다.");
		}
	}

	// 개수를 입력받아 로또 생성 메소드
	private static Map<Integer, List<Integer>> getLotto(int lottoCount) {

		Map<Integer, List<Integer>> lotto = new LinkedHashMap<>();
		for (int i = 0; i < lottoCount; i++) {
			lotto.put(i, Randoms.pickUniqueNumbersInRange(1, 45, 6));
		}
		return lotto;
	}

	// 오름차순으로 정렬하는 메소드
	private static List<Integer> sortInAsd(List<Integer> numbers) {
		Collections.sort(numbers);
		return numbers;
	}
	
	//쉼표 기준으로 구분하는 메소드
	private static List<String> splitComma(String numbers) {
		String[] newNumbers = numbers.split(",");
		return Arrays.asList(newNumbers);
	}
	
	//List 타입 변환 메소드
	private static List<Integer> convertToInt (List<String> numbers) {
		
		List<Integer> winNumbers = new ArrayList<>();
		for (String number : numbers) {
			winNumbers.add(Integer.parseInt(number));
		}
		return winNumbers;
	}
}
