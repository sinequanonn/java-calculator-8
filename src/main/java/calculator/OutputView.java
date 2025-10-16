package calculator;

public class OutputView {

    private static final String RESULT_MESSAGE = "결과 : ";

    public void printResult(Integer sum) {
        System.out.println(RESULT_MESSAGE + sum);
    }
}
