package lotto;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException();
		}
	}

	public static int make_num() { // 구매 수량 얻기
		System.out.println("구매금액을 입력해 주세요.");
		String n = Console.readLine();
		int money = Integer.parseInt(n); // 구매 금액

		if (money % 1000 != 0) { // 1000원으로 나눠떨어지지 않을 경우
			throw new IllegalArgumentException();
		}

		int num = money / 1000; // 구매 수량
		System.out.println();
		System.out.println(num + "개를 구매했습니다.");
		return num;
	}

	public static List<Integer>[] make_lotto(int num) { // 로또 번호 받기
		List<Integer>[] lottoArray = new List[num];
		for (int i = 0; i < num; i++) {
			lottoArray[i] = Randoms.pickUniqueNumbersInRange(1, 45, 6);
			Collections.sort(lottoArray[i]);
			System.out.println(lottoArray[i]);
		}
		return lottoArray;
	}

	public static int[] get_num() { // 사용자 당첨 번호 입력값 받기
		System.out.println();
		System.out.println("당첨 번호를 입력해 주세요.");
		String n = Console.readLine();
		String[] num = n.split(",");
		if (num.length != 6) { // 6개 이외의 값을 넣었을 경우
			throw new IllegalArgumentException();
		}
		int[] money = new int[6];
		for (int i = 0; i < 6; i++) {
			money[i] = Integer.parseInt(num[i]);
		}
		return money;
	}

	public static int get_bonus() { // 사용자 보너스번호 입력값 받기
		System.out.println();
		System.out.println("보너스 번호를 입력해 주세요.");
		String n = Console.readLine();
		int bonus = Integer.parseInt(n);
		return bonus;
	}

	public static int[] compare_num(List<Integer>[] lotto, int[] num) { // 로또확인(들여쓰기 2이내 수정)
		int[] result = Arrays.stream(lotto)
				.mapToInt(list -> (int) list.stream()
						.filter(numValue -> Arrays.stream(num).anyMatch(numItem -> numItem == numValue)).count())
				.toArray();
		return result;
	}

	public static int[] compare_bonus(List<Integer>[] lotto, int bonus) { // 보너스 확인
		int[] boresult = Arrays.stream(lotto)
				.mapToInt(list -> (int) list.stream().filter(numValue -> numValue == bonus).count()).toArray();
		return boresult;
	}

	public static int[] make_result(int[] result, int[] boresult) {
		int[] count = new int[5];
		for (int i = 0; i < result.length; i++) {
			if (result[i] == 3) {
				count[0]++;
			}
			if (result[i] == 4) {
				count[1]++;
			}
			if (result[i] == 5 && boresult[i] == 0) {
				count[2]++;
			}
			if (result[i] == 5 && boresult[i] == 1) {
				count[3]++;
			}
			if (result[i] == 6) {
				count[4]++;
			}
		}
		return count;
	}

	public static void print_result(int[] count) {
		System.out.println();
		System.out.println("당첨통계");
		System.out.println("---");
		System.out.println("3개 일치 (5,000원) - " + count[0] + "개");
		System.out.println("4개 일치 (50,000원) - " + count[1] + "개");
		System.out.println("5개 일치 (1,500,000원) - " + count[2] + "개");
		System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + count[3] + "개");
		System.out.println("6개 일치 (2,000,000,000원) - " + count[4] + "개");
	}

	public static void print_percent(int[] count, int user) {
		int money = 0;
		for (int i = 0; i < count.length; i++) {
			if (i == 0) {
				money += 5000 * count[i];
			}
			if (i == 1) {
				money += 50000 * count[i];
			}
			if (i == 2) {
				money += 1500000 * count[i];
			}
			if (i == 3) {
				money += 30000000 * count[i];
			}
			if (i == 4) {
				money += 2000000000 * count[i];
			}
		}
		double moresult = (double) money / (double) user / 10;
		String formattedNumber = String.format("%.1f", moresult);
		System.out.println("총 수익률은 " + formattedNumber + "% 입니다.");
	}

	public enum lotto_result {
		Co3, Co4, Co5, Co5Bo, Co6
	}

}
