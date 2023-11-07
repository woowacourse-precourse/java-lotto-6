# 미션 - 로또
## 기능 요구 사항
 - 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또 발행
 - 당첨 번호와 보너스 번호를 입력받음
 - 사용자의 로또 번호와 당첨 번호를 비교
 - 당첨 내역 및 수익률을 출력하고 로또 게임 종료
 - 잘못된 입력 값에 대한 예외 발생

## 기능 구현 목록
### LottoGameStarter Class
 - lottoGameStarter() 
### Input Class
 - customerWalletInput()
 - winNumberInput()
 - bonusNumberInput()
### Output Class
 - printCustomerLottos()
 - printCompareWinNumber()
 - printRateOfReturn()
### Lotto Class
 - List numbers
 - Lotto()
 - validate()
### Customer Class
 - List lottos
 - int wallet
 - compareWinlotto()
 - printRateOfReturn()
### WinLotto Class
 - List numbers
 - int bonusNumber
### LottoShop Class
 - Customer customer
 - WinLotto winlotto
 - compareWinlotto()