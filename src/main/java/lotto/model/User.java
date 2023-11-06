package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoValue;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Price;
import lotto.domain.UserLottos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    public Price requestPurchasePrice() {
        while (true) {
            try {
                Price price = new Price(Console.readLine());
                return price;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 가격 만큼 로또 장 수 발행
    public UserLottos generateAllLottos(Price price) {
        int totalLottoCnt = price.getPrice() / LottoValue.PRICE_PER_PIECE.getValue(); // 사용자가 구매한 로또 장 수

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < totalLottoCnt; i++) {
            Lotto lotto = generateLotto();
            lottos.add(lotto);
        }

        return new UserLottos(lottos);
    }

    // 로또 한 장 발행
    private Lotto generateLotto() {
        int startRange = LottoValue.MIN_VALUE.getValue();
        int endRange = LottoValue.MAX_VALUE.getValue();
        int cnt = LottoValue.WINNING_NUMBER_CNT.getValue();

        return new Lotto(pickRandNums(startRange, endRange, cnt));
    }

    private List<Integer> pickRandNums(int start, int end, int cnt) {
        return Randoms.pickUniqueNumbersInRange(start, end, cnt);

    }

    // 당첨 번호 입력 받기
    public Lotto requestWinningNums() {
        while (true) {
            try {
                String[] userInput = Console.readLine().split(",");
                Lotto winningNums = new Lotto(Arrays.stream(userInput).map(e -> Integer.parseInt(e)).collect(Collectors.toList()));

                return winningNums;
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.NOT_NUMBER.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 보너스 번호 입력 받기
    public LottoNumber requestBonusNum(Lotto winningNums) {
        while (true) {
            try {
                LottoNumber bonusNum = new LottoNumber(Console.readLine());
                validateDuplicate(winningNums, bonusNum);

                return bonusNum;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 보너스 번호 중복 검사
    private void validateDuplicate(Lotto winningNums, LottoNumber bonusNum) {
        if(winningNums.getNumbers().contains(bonusNum)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUM.getMessage());
        }
    }
}
