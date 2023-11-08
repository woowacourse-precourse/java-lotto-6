package lotto.controller;

import java.util.List;
import lotto.view.View;

public interface Controller {
    View process(List<String> input);
}
