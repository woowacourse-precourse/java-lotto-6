# ✨ 프로젝트 소개

이 프로젝트는

**<span style="color:royalblue">우아한 테크코스 6기 프리코스</span>**

**<span style="color:red">(3주차 미션) 로또 프로젝트</span>**  입니다.

<br>

```
<로또 프로젝트 간단 설명>

사용자가 로또를 구매할 금액을 입력하면 (예: 자동 5000원)

로또 번호 조합을 5개 생성하고 

그 결과를 출력합니다. 

그 후에 당첨 번호가 발표되면

사용자의 당첨 결과 및 수익률을 계산해서 보여주는 프로젝트 입니다.
```

![참고](https://velog.velcdn.com/images/rednada1486_/post/c5376df4-334e-44e1-b328-81011f2de109/image.gif)

<br><br><br>

# ✨ 프로젝트 구조

(미숙하지만.. ^^)

**<span style="color:red">MVC 패턴을 적용해서</span>**

프로젝트를 만들어 보았습니다.

![프로젝트 구조](https://velog.velcdn.com/images/rednada1486_/post/af376d1c-489e-48e3-874b-5ccadb3170cd/image.png)

<br>

💼 Model : 비즈니스 로직을 담당
```
domain
    ㄴ Lotto : 로또 번호 한조(6개의 숫자)에 관련된 기능을 모아 놓음
    ㄴ Ranking(enum) : 등수와 관련된 상수값을 모아놓은 enum 클래스
    
service
    ㄴ LottoService : 로또 판매와 관련된 비즈니스 로직을 담당 (로또 생성, 당첨 결과 계산 ,수익률 계산 등)
```

<br>

👁️ View : 사용자에게 데이터를 시각적으로 표시하는 부분

```
view
    ㄴ InputView : 사용자에게 입력을 받는 화면을 구성하는 역할을 담당
    ㄴ OutputView : 사용자에게 보여줄 화면을 구성하는 역할을 담당
```

<br>

🕹️ Controller : Model과 View 사이의 상호작용을 조정하고 제어하는 부분

``` 
controller
    ㄴ LottoController : 사용자의 입력을 바탕으로 로또 구매 및 당첨 결과를 출력하는 역할을 담당
```

<br>

🔧 기타 : 프로젝트를 할 때 유용한 기능 모음

```
utils 
     ㄴ StringUtils : 문자열과 관련된 기능들을 모아놓음
     ㄴ CalculationUtils : 숫자 계산과 관련된 기능들을 모아놓음
```


# ✨ 기능 구현  목록

<br>

📕 domain.Lotto :

    ✏️ 기능1. 로또를 하나 발행한다. ➡ Lotto() (생성자)
    
        ✏️ 기능2. 로또를 발행하기 위해 입력된 숫자의 조합을 검증한다. ➡ validate()

            ✏️ 기능3. 로또를 발행하기 위해 입력된 숫자의 개수가 6개인지 체크한다. ➡ 기본 메서드 사용
    
            ✏️ 기능4. 로또를 발행하기 위해 입력된 각 숫자가 1 ~ 45 범위에 있는지 체크한다. ➡ 기능30 사용
            
            ✏️ 기능5. 로또를 발행하기 위해 입력된 각 숫자에 중복이 있는지 체크한다. ➡ 기능31 사용

    ✏️ 기능6. 발행된 숫자 조합에 보너스 번호가 있는지 확인한다. ➡ isNumberIn()

    ✏️ 기능7. 정답 조합에 포함되는 숫자의 개수를 반환한다. ➡ countMatchingNumber()

    ✏️ 기능33. 로또가 가지고 있는 숫자 조합을 String으로 반환한다. ➡ getNumbers()

<br>

📕 service.LottoService :

    ✏️ 기능34. 로또 구매 결과에 대한 출력문을 작성한다. ➡ makePurchaseResultOutputStatement()

    ✏️ 기능9. 기능10 에서 생성된 숫자 조합으로 로또를 발행한다. ➡ generateLotto() 
            
        ✏️ 기능10. 로또를 발행하기 위한 6자리 숫자 조합을 생성한다. ➡ generateLottoCombination()

    ✏️ 기능35. 로또 당첨 결과에 대한 출력문을 작성한다. ➡ makeStatisticsResultOuputStatement()

        ✏️ 기능11. 로또 당첨 결과를 Map 형태의 자료구조에 담아둔다. ➡ calculateWinningResult() 

            ✏️ 기능36. 로또 결과 반환을 위해 Map을 초기화한다. ➡ ininWinningResult()
    
            ✏️ 기능12. 로또 한 조합의 등수를 계산한다. ➡ calculateRanking()

        ✏️ 기능13. 수익률을 계산한다. ➡ calculteProfitRate()

            ✏️ 기능14. 수익률을 소수점 둘째 자리에서 반올림한다. ➡ 기능39 사용

<br>

📕 controller.LottoController :

    ✏️ 기능15. 로또 구입 금액을 입력 받는다. ➡ recieveMoney() 

        ✏️ 기능16. 구입 금액을 제대로 입력했는지 검증한다. ➡ validateReceivedMoney() 

            ✏️ 기능17. 입력된 값이 숫자가 아니면 예외가 발생한다. ➡ 기능37 사용
    
            ✏️ 기능18. 로또 구입 금액이 1000원 단위인지 체크한다. ➡ 기능32 사용
        
        ✏️ 기능19. 검증을 통과하면 로또 구입금액을 숫자로 반환한다 ➡ 기능37 사용

    ✏️ 기능8. 로또 구매 개수만큼 로또를 구매한다. ➡ generateLottoList() 

    ✏️ 기능20. 로또 구매 결과를 출격한다. ➡ showPurchaseResult()  

    ✏️ 기능21. 로또 당첨 번호를 입력받는다. ➡ registerWinningLottoCombination() 

        ✏️ 기능22. 당첨 번호를 변환할 때 공백을 제거한다. ➡ 기본 메서드 사용

        ✏️ 기능23. 당첨 번호 중에 정수가 아닌 값이 있으면 예외를 발생시킨다. ➡ validateLottoNumber()

        ✏️ 기능38. 당첨 번호 중에 1~45 범위에 있지 않은 숫자가 있으면 예외를 발생시킨다. ➡ validateLottoNumber()

    ✏️ 기능24. 보너스 번호를 입력받는다. ➡ registerBonusNumber()

        ✏️ 기능25. 입력된 값이 숫자가 아니면 예외가 발생한다. ➡ validateLottoNumber()

        ✏️ 기능26. 입력된 값이 1 ~ 45 범위 내에 있는지 확인한다. ➡ validateLottoNumber()

        ✏️ 기능40. 입력된 숫자는 정답 로또 조합에 없는 값이어야 한다. ➡ validateBonusLottoNumber()

    ✏️ 기능27. 당첨통계를 보여준다. ➡ showStatisticsResult()

    ✏️ 기능28. 사용자 입력값을 받다가 예외 발생한 경우 값을 다시 입력받는다. ➡ receiveInputUntilPass()

<br>

📕 utils.StringUtils :

    ✏️ 기능29. 문자열에서 특정 문자열이 몇 번 등장하는지 세어준다. ➡ countOccurrences() 

    ✏️ 기능37. 문자열을 정수형 숫자로 변환한다. ➡ parseInt() 

<br>

📕 utils.CalculationUtils :

    ✏️ 기능30. 숫자가 특정 범위에 있는지 확인한다. ➡ isNumberInRange()

    ✏️ 기능31. List에 중복된 숫자가 있는지 확인한다. ➡ hasDuplicates() 
    
    ✏️ 기능32. 어떤 숫자가 특정 숫자의 배수인지 확인한다. ➡ isDivisible()

    ✏️ 기능39. 소수점 둘째 자리에서 반올림한다. ➡ roundToDecimalPlace()



<br><br><br>

# ✨ 이번 프로젝트에서 중점을 둔 부분

이번 프로젝트에서는 다음 사항을 지키려고 노력하면서 프로그래밍을 진행하였습니다.

    📌 MVC 패턴 적용해서 기능별로 클래스 분리
    
    📌 메서드가 하나의 역할만 수행할 수 있도록 최대한 기능을 분리하기

        - 메서드의 indent(들여쓰기) depth가 3이 넘지 않도록 하기

        - 메서드의 길이가 15라인을 넘어가지 않도록 하기
    
    📌 단위 테스트 코드 작성