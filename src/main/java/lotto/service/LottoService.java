package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
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
        System.out.println(lottoCount + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        return lottos;
    }
    public int getBonusNum(){
        System.out.println("보너스 번호를 입력해주세요.");
        String inputStr = Console.readLine();
        int bonusNum = validateBonusNum(inputStr);
        return bonusNum;
    }
    public LottoResultAndProfitResponseDto getLottoResultResponse(List<Lotto> lottoNumbers, Lotto winningLottoNumbers, int bonusNum){
        int threeMatchingPrizeCount = 0;
        int fourMatchingPrizeCount = 0;
        int fiveMatchingPrizeCount = 0;
        int fiveMatchingWithBonusBallPrizeCount = 0;
        int sixMatchingPrizeCount = 0;
        int matchingCount=0;
        LottoResultResponseDto lottoResultResponseDto = new LottoResultResponseDto();
        LottoResultResponseDto lottoResponseDto;
        for (Lotto userLotto : lottoNumbers) {
            matchingCount = countMatchingNumbers(userLotto, winningLottoNumbers);
            lottoResponseDto = calculatePrizeCount(matchingCount,userLotto,bonusNum);
            lottoResultResponseDto.setThreeMatchingPrizeCount(threeMatchingPrizeCount += lottoResponseDto.getThreeMatchingPrizeCount());
            lottoResultResponseDto.setFourMatchingPrizeCount(fourMatchingPrizeCount+= lottoResponseDto.getFourMatchingPrizeCount());
            lottoResultResponseDto.setFiveMatchingPrizeCount(fiveMatchingPrizeCount+= lottoResponseDto.getFiveMatchingPrizeCount());
            lottoResultResponseDto.setFiveMatchingWithBonusBallPrizeCount(fiveMatchingWithBonusBallPrizeCount += lottoResponseDto.getFiveMatchingWithBonusBallPrizeCount());
            lottoResultResponseDto.setSixMatchingPrizeCount(sixMatchingPrizeCount += lottoResponseDto.getSixMatchingPrizeCount());;
        }

        double totalProfitRate = calculateTotalProfitRate(lottoResultResponseDto);
        return LottoResultAndProfitResponseDto.of(lottoResultResponseDto,totalProfitRate);

    }
    public void PrintResult(LottoResultAndProfitResponseDto lottoResultAndProfitResponseDto){
        System.out.println("3개 일치 (5,000원) - "+lottoResultAndProfitResponseDto.getLottoResultResponseDto().getThreeMatchingPrizeCount()+"개");
        System.out.println("4개 일치 (50,000원) - "+lottoResultAndProfitResponseDto.getLottoResultResponseDto().getFourMatchingPrizeCount()+"개");
        System.out.println("5개 일치 (1,500,000원) - "+lottoResultAndProfitResponseDto.getLottoResultResponseDto().getFiveMatchingPrizeCount()+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+lottoResultAndProfitResponseDto.getLottoResultResponseDto().getFiveMatchingWithBonusBallPrizeCount()+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+lottoResultAndProfitResponseDto.getLottoResultResponseDto().getSixMatchingPrizeCount()+"개");
        System.out.println("총 수익률은 "+lottoResultAndProfitResponseDto.getTotalProfitRate()+"%입니다.");
    }
    private double calculateTotalProfitRate(LottoResultResponseDto lottoResultResponseDto) {
        int totalPurchasedLottos = lottoResultResponseDto.getThreeMatchingPrizeCount() + lottoResultResponseDto.getFourMatchingPrizeCount() + lottoResultResponseDto.getFiveMatchingPrizeCount() +
                lottoResultResponseDto.getFiveMatchingWithBonusBallPrizeCount() + lottoResultResponseDto.getSixMatchingPrizeCount();
        int totalPrizeAmount = 5000 * lottoResultResponseDto.getThreeMatchingPrizeCount() + 50000 * lottoResultResponseDto.getFourMatchingPrizeCount() +
                1500000 * lottoResultResponseDto.getFiveMatchingPrizeCount() + 30000000 * lottoResultResponseDto.getFiveMatchingWithBonusBallPrizeCount() +
                2000000000 * lottoResultResponseDto.getSixMatchingPrizeCount();;
        int totalPurchasedAmount = totalPurchasedLottos * 1000;
        double totalProfitRate = (double) totalPrizeAmount / totalPurchasedAmount;
        return totalProfitRate * 100;
    }

    private LottoResultResponseDto calculatePrizeCount(int matchingCount,Lotto userLotto,int bonusNum){
        List<Integer> userNumbers = userLotto.getNumbers();
        int threeMatchingPrizeCount = 0;
        int fourMatchingPrizeCount = 0;
        int fiveMatchingPrizeCount = 0;
        int fiveMatchingWithBonusBallPrizeCount = 0;
        int sixMatchingPrizeCount = 0;
        if (matchingCount == 3) {
            threeMatchingPrizeCount++;
            return LottoResultResponseDto.of(threeMatchingPrizeCount, fourMatchingPrizeCount, fiveMatchingPrizeCount, fiveMatchingWithBonusBallPrizeCount, sixMatchingPrizeCount);
        }
        if (matchingCount == 4) {
            fourMatchingPrizeCount++;
            return LottoResultResponseDto.of(threeMatchingPrizeCount, fourMatchingPrizeCount, fiveMatchingPrizeCount, fiveMatchingWithBonusBallPrizeCount, sixMatchingPrizeCount);
        }
        if (matchingCount == 5) {
            if (userNumbers.contains(bonusNum)) {
                fiveMatchingWithBonusBallPrizeCount++;
                return LottoResultResponseDto.of(threeMatchingPrizeCount, fourMatchingPrizeCount, fiveMatchingPrizeCount, fiveMatchingWithBonusBallPrizeCount, sixMatchingPrizeCount);
                }
            if(!userNumbers.contains(bonusNum)){
                fiveMatchingPrizeCount++;
                return LottoResultResponseDto.of(threeMatchingPrizeCount, fourMatchingPrizeCount, fiveMatchingPrizeCount, fiveMatchingWithBonusBallPrizeCount, sixMatchingPrizeCount);
            }
        }
        if (matchingCount == 6) {
            sixMatchingPrizeCount++;
            return LottoResultResponseDto.of(threeMatchingPrizeCount, fourMatchingPrizeCount, fiveMatchingPrizeCount, fiveMatchingWithBonusBallPrizeCount, sixMatchingPrizeCount);
        }
        return LottoResultResponseDto.of(threeMatchingPrizeCount, fourMatchingPrizeCount, fiveMatchingPrizeCount, fiveMatchingWithBonusBallPrizeCount, sixMatchingPrizeCount);
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
