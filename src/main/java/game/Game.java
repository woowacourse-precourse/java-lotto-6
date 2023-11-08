package game;

import static game.Judgement.checkOneLottoNumber;

import camp.nextstep.edu.missionutils.Randoms;
import io.Input;
import io.Output;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.Lotto;

public class Game {

    public void run() {
        Integer BuyMoney;
        int LottoTicketsCount;
        int specialNumber;
        List<Integer> hitNumberList;

        Output output = new Output();
        Input input = new Input();
        Judgement judgement = new Judgement();

        Output.printMessage(output.introduceGameMessage());

        while (true) {
            try {
                String stringBuyMoney = input.scan();
                Judgement.checkBuyMoneyIsValid(stringBuyMoney);
                BuyMoney = Integer.parseInt(stringBuyMoney);
                LottoTicketsCount = judgement.isDivisibleByTicketPrice(BuyMoney);
                break;
            } catch (IllegalArgumentException e) {
                Output.printMessage(e.getMessage());
            }

        }

        List<Lotto> lottoTickets = new ArrayList<>();
        generateLotto(LottoTicketsCount, lottoTickets);
        printOutLottoInformation(lottoTickets);

        Output.printMessage(output.insertLottoNumberMessage());

        while (true) {
            try {
                String hitNumbersStrings = input.scan();
                hitNumberList = new ArrayList<>();
                inputHitNumbersCheckFunction(hitNumbersStrings, hitNumberList);
                break;
            } catch (IllegalArgumentException e) {
                Output.printMessage(e.getMessage());
            }

        }

        Output.printMessage(output.insertBonusLottoNumberMessage());

        while (true) {
            try {
                String stringSpecialNumber = input.scan();
                specialNumber = checkOneLottoNumber(stringSpecialNumber);
                break;
            } catch (IllegalArgumentException e) {
                Output.printMessage(e.getMessage());
            }
        }
        Output.printMessage(output.hitAverageMessage());
        int totalAmountMoney = judgement.resultHitLottoCheck(hitNumberList, specialNumber,
                lottoTickets);
        judgement.calculateLottoProfit(BuyMoney, totalAmountMoney);

    }

    public void generateLotto(int LottoTicketsCount, List<Lotto> lottoTickets) {
        for (int i = 0; i < LottoTicketsCount; i++) {
            List<Integer> randomNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> sortedList = randomNumber.stream().sorted().collect(Collectors.toList());
            Lotto lotto = new Lotto(sortedList);
            lottoTickets.add(lotto);
        }
    }

    public void printOutLottoInformation(List<Lotto> lottoTickets) {
        Output.printMessage(Output.buyLottoMessage(lottoTickets.size()));
        for (Lotto lotto : lottoTickets) {
            List<Integer> numbers = lotto.getNumbers();
            Output.printMessage(numbers.toString());
        }
    }

    public void inputHitNumbersCheckFunction(String hitNumbersStrings,
            List<Integer> hitNumberList) {
        String[] hitNumbers = hitNumbersStrings.split(",");
        isinputHitNumbersDuplicateCheck(hitNumbers, hitNumberList);
        isinputHitNumberIs6Check(hitNumbers);
        isinputHitNumber1to45(hitNumbers);
    }

    public void isinputHitNumbersDuplicateCheck(String[] hitNumbers, List<Integer> hitNumberList) {
        Set<Integer> numberSet = new HashSet<>();
        for (String numStr : hitNumbers) {
            try {
                int number = Integer.parseInt(numStr);
                if (numberSet.contains(number)) {
                    throw new IllegalArgumentException(Output.errorSameNumberInInputMessage);
                }
                hitNumberList.add(number);
                numberSet.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(Output.errorCanNotDivideMessage);

            }
        }
    }

    public void isinputHitNumber1to45(String[] hitNumbers) {
        for (String number : hitNumbers) {
            checkOneLottoNumber(number);
        }
    }


    public void isinputHitNumberIs6Check(String[] hitNumbers) {
        if (hitNumbers.length != 6) {
            throw new IllegalArgumentException(Output.errorHitNumberCountIsNotValidMessage);
        }

    }


}

