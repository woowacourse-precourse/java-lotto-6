````mermaid
    graph LR
    APPLICATION --> LottoController --> inputMoney --> validMoney -- null --> validMoney
    validMoney -- true --> GenerateLotto
    GenerateLotto --> LottoNumbers -- return --> LottoController
    LottoController --> inputNumber --> validNumber -- null --> validNumber -- true --> LottoController
    LottoController --> inputBonusBall --> validBonusBall -- null --> validBonusBall -- true --> LottoController
    LottoController --> result
````