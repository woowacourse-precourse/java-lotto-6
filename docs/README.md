# ✨ 기능 구현  목록

<br>

📕 domain.Lotto :

    ✏️ 기능1. 로또를 하나 발행한다. ➡ Lotto() (생성자)
    
        ✏️ 기능2. 로또를 발행하기 위해 입력된 숫자의 조합을 검증한다. ➡ validate()

            ✏️ 기능3. 로또를 발행하기 위해 입력된 숫자의 개수가 6개인지 체크한다. ➡ 기본 메서드 사용
    
            ✏️ 기능4. 로또를 발행하기 위해 입력된 각 숫자가 1 ~ 45 범위에 있는지 체크한다. ➡ 기능30 사용
            
            ✏️ 기능5. 로또를 발행하기 위해 입력된 각 숫자에 중복이 있는지 체크한다. ➡ 기능31 사용

    ✏️ 기능6. 발행된 숫자 조합에 보너스 번호가 있는지 확인한다. ➡ isBonusNumberIn()

    ✏️ 기능7. 정답 조합에 포함되는 숫자의 개수를 반환한다. ➡ countMatchingNumber()

    ✏️ 기능33. 로또가 가지고 있는 숫자 조합을 String으로 반환한다. ➡ getNumbers()

<br>

📕 service.LottoService :

    ✏️ 기능34. 로또 구매 결과에 대한 출력문을 작성한다. ➡ makePurchaseResultOutputStatement()

        ✏️ 기능8. 지정된 갯수만큼 로또를 발행하고 List 형태로 반환한다. ➡ generateLottoList() 
        
            ✏️ 기능9. 기능10 에서 생성된 숫자 조합으로 로또를 발행한다. ➡ generateLotto() 
            
                ✏️ 기능10. 로또를 발행하기 위한 6자리 숫자 조합을 생성한다. ➡ generateLottoCombination()

    ✏️ 기능35. 로또 당첨 결과에 대한 출력문을 작성한다. ➡ makeWinningResultOuputStatement()

        ✏️ 기능11. 로또 당첨 결과를 Map 형태의 자료구조에 담아둔다. ➡ makeWinningResult() 

            ✏️ 기능36. 로또 결과 반환을 위해 Map을 초기화한다. ➡ ininWinningResult()
    
            ✏️ 기능12. 로또 한 조합의 등수를 계산한다. ➡ calculateRanking()

        ✏️ 기능13. 수익률을 계산한다. ➡ calculteProfitRate()

            ✏️ 기능14. 수익률을 소수점 둘째 자리에서 반올림한다. ➡ roundToDecimalPlace(int location 2)

<br>

📕 controller.LottoController :

    ✏️ 기능15. 로또 구입 금액을 입력 받는다. ➡ recieveMoney() 

        ✏️ 기능16. 구입 금액을 제대로 입력했는지 검증한다. ➡ validateMoney() 

            ✏️ 기능17. 입력된 값이 숫자가 아니면 예외가 발생한다.
    
            ✏️ 기능18. 로또 구입 금액이 1000원 단위인지 체크한다.
        
        ✏️ 기능19. 검증을 통과하면 로또 구매 개수를 반환한다 ➡ 기본 메서드 사용

    ✏️ 기능20. 로또 구매 개수만큼 로또를 구매하고 로또 구매 결과를 보여준다. ➡ showPurchaseResult() 

    ✏️ 기능21. 로또 당첨 번호를 입력받는다. ➡ registerWinningLottoCombination() 

        ✏️ 기능22. 사용자 입력값을 공백을 제거하고 쉼표 기준으로 구분한다. ➡ userInputToNumberArray() 

        ✏️ 기능23. 검증을 통과하면 Lotto 객체를 생성한다.

    ✏️ 기능24. 보너스 번호를 입력받는다. ➡ registerBonusNumber()

        ✏️ 기능25. 입력된 값이 숫자가 아니면 예외가 발생한다. 

        ✏️ 기능26. 입력된 값이 1 ~ 45 범위 내에 있는지 확인한다. ➡ 기능30 사용

    ✏️ 기능27. 당첨통계를 보여준다. ➡ showWinningResult()

    ✏️ 기능28. 사용자 입력값을 받다가 예외 발생한 경우 값을 다시 입력받는다. ➡ while 사용

<br>

📕 utils.StringUtils :

    ✏️ 기능29. 문자열에서 특정 문자열이 몇 번 등장하는지 세어준다. ➡ countOccurrences() 

    ✏️ 기능37. 문자열을 정수형 숫자로 변환한다. ➡ parseInt() 

<br>

📕 utils.CalculationUtils :

    ✏️ 기능30. 숫자가 특정 범위에 있는지 확인한다. ➡ isNumberInRange()

    ✏️ 기능31. List에 중복된 숫자가 있는지 확인한다. ➡ hasDuplicates() 
    
    ✏️ 기능32. 어떤 숫자가 특정 숫자의 배수인지 확인한다. ➡ isDivisibleBy()