package lotto.user;

import lotto.converter.ConvertService;

public class UserController {

    private final UserView userView;
    private final ConvertService convertService;
    private final UserService userService;
    public UserController(ConvertService convertService, UserView userView, UserService userService){
        this.userView = userView;
        this.convertService = convertService;
        this.userService = userService;
    }

    public void buyLotto(){
        String inputAssetRequest = userView.inputUserMoney();
        int asset = convertService.stringToIntegerConverter(inputAssetRequest);
        User user = createUserFromAsset(asset);
        userService.buyAllPurchasableLotto(user);
    }

    private User createUserFromAsset(int asset){
        return userService.createUser(asset);
    }



}
