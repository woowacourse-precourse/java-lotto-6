1. [x] constant
    * Comments
    * GameConstants
    * ErrorConstants
2. [x] view
    * InputView 
    * OutputView
3. [x] exception
    * ExceptionHandler
4. [x] model
    * Lotto: 로또 한장   
    * LottoNumber: 로또번호 전체   
    * WinningLotto : 당첨 로또 번호   
    * Rank: 당첨 등수 및 상금
5. [x] service
    * purchaseService: 로또 구입 금액에 따라 몇장인지 판단 서비스
    * RandomLottoCreService: 랜덤한 로또들 생성 서비스
    * WinningLottoService: 정답 로또 입력 서비스
    * ResultService: 정답 로또에 따른 결과 판단 서비스
    * returnService: 수익률 계산 서비스
6. [x] controller
    * GameController
7. [x] util
    * PurchasePriceValidUtil: 구입금액 확인
    * WinningLottoNumberValidUtil: 정답 로또 확인 서비스