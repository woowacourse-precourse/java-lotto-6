package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;

public class Application {
    public static void main(String[] args) {
        List<Lotto> lottos = buyingLotto();
        printLotto(lottos);
        Lotto winningLottoNumbers = createWinningLotto();
        WinningLotto winningLotto = winningLottoGenerating(winningLottoNumbers);
        당첨_통계(lottos, winningLotto);
    }

    public static List<Lotto> buyingLotto() {
        boolean successInput = false;
        List<Lotto> lottos = null;
        while (!successInput) {
            try {
                lottos = lottoGenerating(paymentInput());
                successInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
        }
        return lottos;
    }

    public static String paymentInput() {
        System.out.println("구입금액을 입력해 주세요.");
        String payment = Console.readLine();
        // Todo : payment에 대해 공백, 숫자 외 문자에 대한 검증하기
        return payment;
    }

    public static List<Lotto> lottoGenerating(String payment) {
        return new LottoGenerator(Integer.parseInt(payment)).getLottos();
    }

    public static void printLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public static WinningLotto winningLottoGenerating(Lotto winningLottoNumbers) {
        WinningLotto winningLotto = null;
        boolean successInput = false;
        while (!successInput) {
            try {
                int bonusNumber = bonusNumberGenerating(bonusNumberInput());
                winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);
                successInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
        }
        return winningLotto;
    }

    public static Lotto createWinningLotto() {
        boolean successInput = false;
        Lotto lotto = null;
        while (!successInput) {
            try {
                lotto = winningLottoGenerating(winningLottoInput());
                successInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
        }
        return lotto;
    }

    public static String winningLottoInput() {
        System.out.println("당첨번호를 입력해 주세요.");
        String numbers = Console.readLine();
        // Todo : numbersInput에 대해 공백, 구분자, 숫자 외 입력에 대한 검증
        return numbers;
    }

    public static Lotto winningLottoGenerating(String numbers) {
        return new Lotto(
                Arrays.stream(numbers.trim().split(","))
                        .map(it -> Integer.parseInt(it.trim()))
                        .collect(Collectors.toList())
        );
    }

    public static String bonusNumberInput() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        // Todo : numbersInput에 대해 공백, 구분자, 숫자 외 입력에 대한 검증
        return bonusNumber;
    }

    public static int bonusNumberGenerating(String bonusNumber) {
        return Integer.parseInt(bonusNumber);
    }

    public static void 당첨_통계(List<Lotto> lottos, WinningLotto winningLotto) {
        LottoResult lottoResult = new LottoResult(lottos.size() * 1000);
        lottoResult.calculateWinningResult(winningLotto, lottos);
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(lottoResult);
    }
}
