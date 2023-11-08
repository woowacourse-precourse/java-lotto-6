package lotto.config;

import camp.nextstep.edu.missionutils.Console;
import java.text.NumberFormat;
import java.util.Arrays;
import lotto.Controller;
import lotto.CustomLotteryRanking;
import lotto.Input;
import lotto.InputConverter;
import lotto.InputInterface;
import lotto.InputValidator;
import lotto.LotteryResultRenderer;
import lotto.MissionLottoRandom;
import lotto.Output;
import lotto.OutputInterface;
import lotto.ReceiptRenderer;
import lotto.domain.LotteryRound;

public class Configuration {

    private static InputInterface getInputInterface(Input input, Output output) {
        InputValidator validator = new InputValidator();
        InputConverter converter = new InputConverter(validator);
        return new InputInterface(input, output, converter);
    }

    private static OutputInterface getOutputInterface(Output out) {
        NumberFormat numberFormat = NumberFormat.getIntegerInstance();
        ReceiptRenderer receiptRenderer = new ReceiptRenderer();
        LotteryResultRenderer lotteryResultRenderer = new LotteryResultRenderer(numberFormat);
        return new OutputInterface(out, receiptRenderer,
                lotteryResultRenderer);
    }


    public static Controller getController(String username) {

        ControllerBuilder builder = new ControllerBuilder();

        return builder.setOperator(new LotteryRound(1),
                Arrays.asList(CustomLotteryRanking.values()))
                .setUserService(username)
                .setPurchaseLotteryService(new MissionLottoRandom())
                .setInputInterface(getInputInterface(Console::readLine, System.out::println))
                .setOutputInterface(getOutputInterface(System.out::println))
                .build();

    }
}
