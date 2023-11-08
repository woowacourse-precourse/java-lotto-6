package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.util.LottoVO;
import lotto.util.MatchType;
import lotto.util.UiVO;
import camp.nextstep.edu.missionutils.Console;

public class LottoServiceImpl implements LottoService {

    /**
     * 구입 금액 입력 받는 함수
     *
     * @return : 구입 금액
     */
    @Override
    public int inputPurchaseAmount() {

        while (true) {
            try {
                String purchaseAmountText = Console.readLine();

                int purchaseAmount = stringToInt(purchaseAmountText);

                validatePurchaseAmount(purchaseAmount);

                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 로또 개수 반환하는 함수
     *
     * @return : 로또 구입 개수
     */
    @Override
    public int calculatePurchaseCount(int purchaseAmount) {

        return calculateLottoCount(purchaseAmount);
    }

    /**
     * 랜덤 로또 값 생성해서 반환
     *
     * @return : 생성된 Lotto List
     */
    @Override
    public List<Lotto> generateLottos(int lottoCount) {

        return Stream.generate(this::generateLottoNumbers)
                .limit(lottoCount)
                .collect(Collectors.toList());
    }

    /**
     * 사용자로부터 당첨 번호 입력 받고 반환 1~45 예외 처리 필요
     *
     * @return : 당첨 번호
     */
    @Override
    public List<Integer> inputWinningNumbers() {

        while (true) {
            try {
                String inputText = Console.readLine();
                List<Integer> winningNumbers = convertStringToNumbers(inputText);

                validateDistinctNumbers(winningNumbers);
                validateEachNumber(winningNumbers);

                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 사용자로부터 보너스 번호 입력 받고 반환 1~45 예외 처리 필요
     *
     * @return : 보너스 번호
     */
    @Override
    public int inputBonusNumber(List<Integer> winningNumbers) {

        while (true) {
            try {
                String inputText = Console.readLine();
                int bonusNumber = stringToInt(inputText);

                validateBonusExclusion(bonusNumber, winningNumbers);
                validateBonusNumber(bonusNumber);

                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 당첨 통계 계산하기
     *
     * @param myLottos : Lotto 리스트
     * @return : 당첨 통계
     */
    @Override
    public Map<MatchType, Integer> calculateWinningStatistics(List<Lotto> myLottos,
                                                              List<Integer> winningNumbers,
                                                              int bonusNumber) {

        Map<MatchType, Integer> winningStatistics = new HashMap<>();

        for (Lotto lotto : myLottos) {
            int sameNumbersCount = lotto.countSameNumbers(winningNumbers);

            Optional<MatchType> matchTypeOpt =
                    MatchType.valueOf(sameNumbersCount, lotto.containsBonusNumber(bonusNumber));

            if (matchTypeOpt.isPresent()) {
                MatchType matchType = matchTypeOpt.get();
                winningStatistics.put(matchType, winningStatistics.getOrDefault(matchType, 0) + 1);
            }
        }

        return winningStatistics;
    }

    /**
     * 수익 계산하는 함수
     *
     * @param winningStatistics : 당첨 통계
     * @return : 수익
     */
    @Override
    public int calculateEarnings(Map<MatchType, Integer> winningStatistics) {

        int earnings = 0;

        for (MatchType matchType : winningStatistics.keySet()) {
            int prizeMoney = matchType.getPrizeMoney();
            Integer count = winningStatistics.get(matchType);
            earnings += prizeMoney * count;
        }

        return earnings;
    }

    /**
     * 수익률 계산하기
     *
     * @param earnings : 수익
     * @return : 수익률
     */
    @Override
    public double calculateReturnRate(int purchaseAmount, int earnings) {
        return ((double) earnings / purchaseAmount) * 100;
    }

    private int stringToInt(String str) {

        int result = 0;

        try {
            result = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(UiVO.getInputNumberFormatException());
        }

        return result;
    }

    private void validatePurchaseAmount(int amount) {

        if (!isGreaterThanThousand(amount)) {
            throw new IllegalArgumentException(UiVO.getPurchaseAmountInputMinException());
        }

        if (!isDivisibleByThousand(amount)) {
            throw new IllegalArgumentException(UiVO.getPurchaseAmountInputUnitsException());
        }
    }

    private boolean isDivisibleByThousand(int amount) {
        return amount % 1000 == 0;
    }

    private boolean isGreaterThanThousand(int amount) {
        return amount >= 1000;
    }

    private int calculateLottoCount(int amount) {

        int lottoPrice = LottoVO.getLottoPrice();
        return amount / lottoPrice;
    }

    private Lotto generateLottoNumbers() {

        try {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            return new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private List<Integer> convertStringToNumbers(String inputText) {

        try {
            String[] numberStrings = removeSpaces(inputText).split(",");
            return Arrays.stream(numberStrings)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException(UiVO.getWinningNumberFormatException());
        }
    }

    private String removeSpaces(String text) {
        return text.replaceAll(" ", "");
    }

    private void validateDistinctNumbers(List<Integer> numbers) {

        Set<Integer> distinctNumbers = new HashSet<>(numbers);

        if (distinctNumbers.size() != LottoVO.getLottoNumberCount()) {
            throw new IllegalArgumentException(UiVO.getWinningNumberCountException());
        }
    }

    private void validateEachNumber(List<Integer> numbers) {

        for (Integer number : numbers) {
            if (!isInRange(number)) {
                throw new IllegalArgumentException(UiVO.getLottoNumberException());
            }
        }
    }

    private boolean isInRange(int number) {
        return (number >= LottoVO.getLottoMinValue()) && (number <= LottoVO.getLottoMaxValue());
    }

    private void validateBonusExclusion(int bonusNumber, List<Integer> winningNumbers) {

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(UiVO.getBonusNumberExistsInWinningNumbersException());
        }
    }

    private void validateBonusNumber(int number) {

        if (!isInRange(number)) {
            throw new IllegalArgumentException(UiVO.getLottoNumberException());
        }
    }
}
