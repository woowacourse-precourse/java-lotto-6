package lotto.user;

import lotto.converter.ConvertService;

public class UserController {

    private final UserView userView;
    private final ConvertService convertService;

    public UserController(ConvertService convertService, UserView userView){
        this.userView = userView;
        this.convertService = convertService;
    }

    public void inputMyAsset(){
        createUserFromAsset();
    }

    private User createUserFromAsset(){
        String inputAssetRequest = userView.inputUserMoney();
        return User.fromAsset(convertService.stringToIntegerConverter(inputAssetRequest));
    }



}
