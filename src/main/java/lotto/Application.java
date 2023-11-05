package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class Application {

	public static void main(String[] args) {
		ValidateInput validate = new ValidateInput();
		LottoNumberFactory factory = new LottoNumberFactory();
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

		List<Lotto> lottos = factory.makeLotto(count);

		System.out.println();
		System.out.println("당첨 번호를 입력해주세요.");
		String winningInput = readLine();
		List<Integer> winningNumbers = validate.validateWinningNumber(winningInput);

		System.out.println();
		System.out.println("보너스 번호를 입력하세요.");

		final int bonus = validate.validateBonus(readLine());

		List<Result> results = lottos.stream().map(lotto -> lotto.checkRank(winningNumbers, bonus)).toList();
		int total = results.stream().mapToInt(Result::getPrize).sum();

		double profitRate = ((double) (total * 100) / (count * 1000));
		profitRate = Math.round(profitRate * 100.0) / 100.0;

		List<Result> first = results.stream().filter(result -> result.getRank() == RankEnum.FIRST).toList();
		List<Result> second = results.stream().filter(result -> result.getRank() == RankEnum.SECOND).toList();
		List<Result> third = results.stream().filter(result -> result.getRank() == RankEnum.THIRD).toList();
		List<Result> forth = results.stream().filter(result -> result.getRank() == RankEnum.FORTH).toList();
		List<Result> fifth = results.stream().filter(result -> result.getRank() == RankEnum.FIFTH).toList();

		System.out.println();
		System.out.println("당첨 통계");
		System.out.println("---");
		System.out.println("3개 일치 (5,000원) - " + fifth.size() + "개");
		System.out.println("4개 일치 (50,000원) - " + forth.size() + "개");
		System.out.println("5개 일치 (1,500,000원) - " + third.size() + "개");
		System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + second.size() + "개");
		System.out.println("6개 일치 (2,000,000,000원) - " + first.size() + "개");
		System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
	}

}
