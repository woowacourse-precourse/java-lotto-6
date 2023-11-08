package lotto.global.factory;

import lotto.module.console.Console;
import lotto.module.console.LottoConsoleManager;
import lotto.module.console.input.ConsoleReader;
import lotto.module.console.input.impl.ConsoleReaderImpl;
import lotto.module.console.input.validation.InputValidation;
import lotto.module.console.output.ConsoleWriter;
import lotto.module.console.output.composer.ConsoleMessageComposer;
import lotto.module.console.output.impl.ConsoleWriterImpl;

public class LottoConsoleManagerFactory {
    private static LottoConsoleManager lottoConsoleManager;
    private static Console console;
    private static ConsoleMessageComposer consoleMessageComposer;
    private static ConsoleWriter consoleWriter;
    private static ConsoleReader consoleReader;
    private static InputValidation inputValidation;

    private LottoConsoleManagerFactory() {
    }

    protected static LottoConsoleManager getSingletonLottoConsoleManager() {
        if (lottoConsoleManager == null) {
            lottoConsoleManager = LottoConsoleManager.of(getSingletonConsole(), getSingletonConsoleMessageComposer());
        }
        return lottoConsoleManager;
    }

    private static Console getSingletonConsole() {
        if (console == null) {
            console = Console.of(getSingletonConsoleReaderImpl(), getSingletonConsoleWriterImpl());
        }
        return console;
    }

    private static ConsoleMessageComposer getSingletonConsoleMessageComposer() {
        if (consoleMessageComposer == null) {
            consoleMessageComposer = ConsoleMessageComposer.newInstance();
        }
        return consoleMessageComposer;
    }

    private static ConsoleReader getSingletonConsoleReaderImpl() {
        if (consoleReader == null) {
            consoleReader = ConsoleReaderImpl.newInstance(getSingletonInputValidation());
        }
        return consoleReader;
    }

    private static ConsoleWriter getSingletonConsoleWriterImpl() {
        if (consoleWriter == null) {
            consoleWriter = ConsoleWriterImpl.newInstance();
        }
        return consoleWriter;
    }

    private static InputValidation getSingletonInputValidation() {
        if (inputValidation == null) {
            inputValidation = InputValidation.newInstance();
        }
        return inputValidation;
    }

}
