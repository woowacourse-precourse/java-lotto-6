package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class Application {

	public static void main(String[] args) {
		ValidateInput validate = new ValidateInput();
		System.out.println("구입금액을 입력해 주세요.");

		int count = -1;

		while (count < 0){
			try {
				String moneyInput = readLine();
				count = validate.validateLottoPrice(moneyInput);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}

		System.out.println(count+"개를 구매했습니다.");

		List<Lotto> lottos = LottoNumberFactory.makeLotto(count);
		lottos.forEach(System.out::println);

		System.out.println();
		System.out.println("당첨 번호를 입력해주세요.");
		String winningInput = readLine();
		List<Integer> winningNumbers = validate.validateWinningNumber(winningInput);
		System.out.println();

		System.out.println("보너스 번호를 입력하세요.");
		final int bonus = validate.validateBonus(readLine(), winningNumbers);

		List<RankEnum> results = lottos.stream().map(lotto -> lotto.checkRank(winningNumbers,bonus)).toList();
		int total = results.stream().mapToInt(RankEnum::getPrize).sum();
		double profitRate = ((double) (total * 100) / (count * 1000));
		printResult(results, profitRate);
	}

	public static void printResult(List<RankEnum> results, double profitRate){
		System.out.println();
		System.out.println("당첨 통계");
		System.out.println("---");
		for (RankEnum rank : RankEnum.values()) {
			if (rank == RankEnum.NONE) continue;
			String message = "";
			if (rank.hasBonus()) message = ", 보너스 볼 일치";
			long countByRank = results.stream().filter(result -> result == rank).count();
			String prize = rank.getFormattedPrize();
			System.out.println(rank.getMatchCount() + "개 일치" + message + " (" + prize + "원) - " + countByRank + "개");
		}
		System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
	}

}
