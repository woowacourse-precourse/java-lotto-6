package lotto;

import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lib.constant.LottoConstants;
import lib.enumeration.LottoWinnerRule;

public class LottoGame {
    PrintStream printStream = System.out;
    private List<Lotto> lottos;
    private Lotto winnerNumbers;
    private int bonusWinnerNumber;
    private int price;

    public LottoGame() {
        this.lottos = new ArrayList<Lotto>();
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    private int validateNumber(String input) {
        String REGEXP_ONLY_NUM = "^[0-9]*$";

        if (!Pattern.matches(REGEXP_ONLY_NUM, input)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
        }

        return Integer.parseInt(input);
    }

    private void setPrice(String _price) {
        int price = this.validateNumber(_price);

        if (price % LottoConstants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로만 입력할 수 있습니다.");
        }

        if (price / LottoConstants.LOTTO_PRICE == 0) {
            throw new IllegalArgumentException("[ERROR] 구입할 수 있는 금액이 아닙니다.");
        }

        this.price = price;
    } 

    private Lotto createLotto() {
        while(true) {
            try {
                List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LottoConstants.LOTTO_START_RANGE, LottoConstants.LOTTO_END_RANGE, LottoConstants.LOTTO_SIZE);
    
                return new Lotto(lottoNumbers);
            } catch (IllegalArgumentException e) {
                continue;
            }
        }
    }

    public void createLottos() {
        int count = this.price / LottoConstants.LOTTO_PRICE;

        for (int i = 0; i < count; ++i) {
            this.lottos.add(this.createLotto());
        }
    }

    public void enterPurchaseAmount() {
        while (true) {
            try {
                printStream.println("구입금액을 입력해 주세요.");
                String price = Console.readLine();
                
                this.setPrice(price);
                break;
            } catch (IllegalArgumentException e) {
                printStream.println(e.getMessage() + " 다시 입력해주세요.\n");
                continue;
            }
        }
        printStream.println();
    }

    public void enterWinnerNumbers() {
        while (true) {
            try {
                printStream.println("당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                List<Integer> winnerNumbers = Arrays.stream(input.split(",")).map(Integer::valueOf).collect(Collectors.toList());

                this.winnerNumbers = new Lotto(winnerNumbers);
                break;
            } catch (IllegalArgumentException e) {
                printStream.println(e.getMessage() + " 다시 입력해주세요.\n");
                continue;
            }
        }
        printStream.println();
    }

    public void enterBonusWinnerNumber() {
        while (true) {
            try {
                printStream.println("보너스 번호를 입력해 주세요.");
                String input = Console.readLine();
                int bonusWinnerNumber = this.validateNumber(input);

                this.bonusWinnerNumber = bonusWinnerNumber;
                break;
            } catch (IllegalArgumentException e) {
                printStream.println(e.getMessage() + " 다시 입력해주세요.\n");
                continue;
            }
        }
        printStream.println();
    }

    private void resultPut(Map<Integer, List<List<Integer>>> map, int key, List<Integer> value) {
        if (map.containsKey(key)) {
            map.get(key).add(value);
            return;
        }

        List<List<Integer>> results = new ArrayList<List<Integer>>();

        results.add(value);
        map.put(key, results);
    }

    public Map<Integer, List<List<Integer>>> getMatchedLottosResult() {
        Map<Integer, List<List<Integer>>> matchedLottosResult = new HashMap<Integer, List<List<Integer>>>();

        this.lottos.forEach(lotto -> {
            List<Integer> matchedLotto = lotto.getMatchedLotto(this.winnerNumbers.getNumbers(), this.bonusWinnerNumber);

            if (matchedLotto.size() == 6 && matchedLotto.contains(this.bonusWinnerNumber)) { this.resultPut(matchedLottosResult, LottoWinnerRule.SECOND.index(), matchedLotto); return; }
            if (matchedLotto.size() == 6) { this.resultPut(matchedLottosResult, LottoWinnerRule.FIRST.index(), matchedLotto); return; }
            if (matchedLotto.size() == 5) { this.resultPut(matchedLottosResult, LottoWinnerRule.THIRD.index(), matchedLotto); return; }
            if (matchedLotto.size() == 4) { this.resultPut(matchedLottosResult, LottoWinnerRule.FOURTH.index(), matchedLotto); return; }
            if (matchedLotto.size() == 3) { this.resultPut(matchedLottosResult, LottoWinnerRule.FIFTH.index(), matchedLotto); return; }
        });

        return matchedLottosResult;
    }
    
    public void printLottos() {
        printStream.println(this.lottos.size() + "개를 구매했습니다.");
        this.lottos.forEach(lotto -> printStream.println(lotto.toString()));
        printStream.println();
    }
}
