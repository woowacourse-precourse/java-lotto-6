package lotto.domain.user;

import lotto.domain.converter.ConvertService;

public class UserController {
    private final ConvertService convertService;
    private final UserService userService;
    public UserController(ConvertService convertService,  UserService userService){
        this.convertService = convertService;
        this.userService = userService;
    }

    public User createUserWithAssets(String userInput){
        int asset = convertService.stringToIntegerConverter(userInput);
        return createUserFromAsset(asset);
    }

    public UserLottoResponse buyLotto(User user){
        return userService.buyAllPurchasableLotto(user);
    }

    private User createUserFromAsset(int asset){
        return userService.createUser(asset);
    }



}
