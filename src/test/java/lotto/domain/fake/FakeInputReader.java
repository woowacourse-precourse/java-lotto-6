package lotto.domain.fake;

import lotto.util.reader.ConsoleReader;

public class FakeInputReader implements ConsoleReader {
        private final String input;

        public FakeInputReader(String input) {
                this.input = input;
        }

        @Override
        public String readLine() {
                return input;
        }
}
