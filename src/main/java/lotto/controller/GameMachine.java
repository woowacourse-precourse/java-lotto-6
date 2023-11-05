package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.RandomLottoNumbers;
import lotto.domain.WinningRank;

public class GameMachine {

    private final LottoNumbers lottoNumbers;

    public GameMachine() {
        this.lottoNumbers = new RandomLottoNumbers();
    }

    public void start() {
        // 사용자가 구입 금액 입력 , 1000으로 나눈다.
        System.out.println("구입금액을 입력해 주세요.");
        int inputPrice = Integer.parseInt(Console.readLine());
        int count = inputPrice / 1000;

        System.out.println();
        System.out.println(count + "개를 구매했습니다.");
        List<Lotto> lottos = new ArrayList<>();
        // 구입 금액 / 1000 만큼 발행 한다.
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(lottoNumbers.generateNumbers());

            lottos.add(lotto);
            System.out.println(lotto.getNumbers());
        }

        // 사용자가 당첨 번호 6자리를 입력.
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        List<String> inputWinningNumbers = List.of(Console.readLine().split(","));
        // 당첨 번호 int형 list로 변환
        List<Integer> winningNumbers = inputWinningNumbers.stream()
                .map(Integer::parseInt)
                .toList();

        // 보너스 번호 입력
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        int inputBonusNumber = Integer.parseInt(Console.readLine());

        // 사용자와 번호 비교
        for (Lotto lotto : lottos) {
            long matchCount = winningNumbers.stream()
                    .filter(lotto.getNumbers()::contains)
                    .count();

            boolean bonusMatch = lotto.getNumbers().contains(inputBonusNumber);

            for (WinningRank rank : WinningRank.values()) {
                if (rank.isMatch(matchCount, bonusMatch)) {
                    rank.increaseWinCount();
                    break;
                }
            }
        }

        // 당첨 통계 출력
        System.out.println("당첨 통계");
        System.out.println("---");
        int totalPrizeMoney = 0;
        for (WinningRank rank : WinningRank.values()) {
            totalPrizeMoney += rank.getTotalPrizeMoney();
            System.out.println(rank.getMessage());
        }

        // 총 수익률 출력
        System.out.printf("총 수익률은 %.1f%%입니다.\n", (double) totalPrizeMoney / inputPrice * 100.0);
    }

}