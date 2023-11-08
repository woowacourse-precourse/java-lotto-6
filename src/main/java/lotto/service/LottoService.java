package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.dto.LottoResultAndProfitResponseDto;
import lotto.dto.LottoResultResponseDto;
import lotto.dto.ValidateAmountDto;
import lotto.dto.ValidateAmountResponseDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {

    public int inputAmountAndGetLottoCount(){
        boolean validate = true;
        ValidateAmountResponseDto validateAmountResponseDto = new ValidateAmountResponseDto(0,true);
        while (validate) {
            System.out.println("구입금액을 입력해 주세요.");
            String amountStr = Console.readLine();
            validateAmountResponseDto =validateAmount(ValidateAmountDto.of(validate, amountStr));
            validate = validateAmountResponseDto.isValidate();
        }
        return validateAmountResponseDto.getLottoCount();
    }
    public Lotto inputLottoNum(){
        System.out.println();
        System.out.println("당첨 번호를 입력해주세요.");
        List<Integer> winningLottoNumbers = new ArrayList<>();

        String inputStr = Console.readLine();
        String[] input = inputStr.split(",");

        for (String numberStr : input) {
            winningLottoNumbers.add(validateLottoNum(numberStr));
        }
        Lotto lotto = new Lotto(winningLottoNumbers);
        return lotto;
    }
    public List<Lotto> getUserLottoNum(int lottoCount){
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }

        System.out.println();
        System.out.println(lottoCount + "개를 구매했습니다.");

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }

        return lottos;
    }
    public int getBonusNum(){
        System.out.println();
        System.out.println("보너스 번호를 입력해주세요.");
        String inputStr = Console.readLine();
        int bonusNum = validateBonusNum(inputStr);
        return bonusNum;
    }

    public LottoResultAndProfitResponseDto getLottoResultResponse(List<Lotto> lottoList, Lotto winningNumbers, int bonusNumber) {
        int[] results = new int[Rank.values().length];
        List<Integer> userNumbers = winningNumbers.getNumbers();
        double count = 0;
        double totalPrizeAmount = 0;
        Rank rank = getRank(0,true);
        for (Lotto userLotto : lottoList) {
            int matchingCount = countMatchingNumbers(userLotto, winningNumbers);
            rank = getRank(matchingCount, userNumbers.contains(bonusNumber));
            results[rank.getResult()]++;
            count ++;
            totalPrizeAmount= totalPrizeAmount+rank.getPrizeAmount();
        }
        double totalProfitRate = totalPrizeAmount/(1000 * count);
        LottoResultResponseDto lottoResultResponseDto = LottoResultResponseDto.of(results,rank);
        return LottoResultAndProfitResponseDto.of(lottoResultResponseDto,totalProfitRate*100);
    }
    public void PrintResult(LottoResultAndProfitResponseDto lottoResultAndProfitResponseDto){
        LottoResultResponseDto lottoResultResponseDto = lottoResultAndProfitResponseDto.getLottoResultResponseDto();
        int[] results = lottoResultResponseDto.getResults();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+results[0]+"개");
        System.out.println("4개 일치 (50,000원) - "+results[1]+"개");
        System.out.println("5개 일치 (1,500,000원) - "+results[2]+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+results[3]+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+results[4]+"개");

        System.out.println("총 수익률은 "+lottoResultAndProfitResponseDto.getTotalProfitRate()+"% 입니다.");
    }

    private static Rank getRank(int matchingCount, boolean hasBonusNumber) {
        if (matchingCount == 6) {
            return Rank.FIRST;
        }
        if (matchingCount == 5 && hasBonusNumber) {
            return Rank.SECOND;
        }
        if (matchingCount == 5) {
            return Rank.THIRD;
        }
        if (matchingCount == 4) {
            return Rank.FOURTH;
        }
        if (matchingCount == 3) {
            return Rank.FIFTH;
        }
        return Rank.Null;
    }

    private int countMatchingNumbers(Lotto userLotto, Lotto winningLottoNumbers) {
        List<Integer> userNumbers = userLotto.getNumbers();
        List<Integer> winningNumbers = winningLottoNumbers.getNumbers();
        return (int) userNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }
    private int validateBonusNum(String inputStr){
        int number = 0;
        try {
            number = Integer.parseInt(inputStr);
            if(number<1 && number>45){
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 로또 번호입니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return number;
    }
    private Integer validateLottoNum(String numberStr){
        int number = 0;
        try {
            number = Integer.parseInt(numberStr);
            if(number<1 && number>45){
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 로또 번호입니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return number;
    }
    private ValidateAmountResponseDto validateAmount(ValidateAmountDto validateAmountDto){
        int lottoCount = 0;
        boolean validate = validateAmountDto.isValidate();
        try {
            int amount = Integer.parseInt(validateAmountDto.getAmountStr());
            if (amount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 금액입니다.");
            }
            lottoCount = amount/1000;
            validate = false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return ValidateAmountResponseDto.of(lottoCount, validate);
    }

}
