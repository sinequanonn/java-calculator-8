package calculator;

public class OutputView {

    private static final String RESULT_MESSAGE = "결과 : ";

    public void printResult(Double sum) {

        if (isInteger(sum)) {
            long intSum = sum.longValue();
            System.out.println(RESULT_MESSAGE + intSum);
            return;
        }
        System.out.println(RESULT_MESSAGE + sum);
    }

    private boolean isInteger(Double sum) {
        return sum % 1 == 0;
    }
}
