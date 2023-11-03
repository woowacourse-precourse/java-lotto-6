package lotto.controller.user;

import lotto.controller.Controller;
import lotto.service.UserService;
import lotto.view.BasicView;
import lotto.view.View;

public class UserSaveController implements Controller {
    private final UserService userService;

    public UserSaveController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public View process(String input) {
        int amount = Integer.parseInt(input);
        userService.saveUser(amount);
        return new BasicView();
    }

    private void validate(String input) {

    }

}
