package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PositiveNumberExtractor {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_FRONT = "//";
    private static final String CUSTOM_DELIMITER_END = "\\n";
    private static final int FRONT_DELIMITER_LENGTH = CUSTOM_DELIMITER_FRONT.length();
    private static final int END_DELIMITER_LENGTH = CUSTOM_DELIMITER_END.length();

    private static final int MIN_NUMBER = 0;

    public List<Double> extract(String inputString) {
        String delimiter = DEFAULT_DELIMITER;

        if (inputString.startsWith(CUSTOM_DELIMITER_FRONT)) {
            int endIndex = inputString.indexOf(CUSTOM_DELIMITER_END);
            String customDelimiter = "|" + inputString.substring(FRONT_DELIMITER_LENGTH, endIndex);
            delimiter += customDelimiter;
            inputString = inputString.substring(endIndex+END_DELIMITER_LENGTH);
        }

        String[] split = inputString.split(delimiter);
        for (String input : split) {
            System.out.println("input = " + input);
        }

        return Arrays.stream(inputString.split(delimiter))
                .filter(number -> !number.isEmpty())
                .map(this::parseToDouble)
                .collect(Collectors.toList());
    }

    private Double parseToDouble(String number) {
        try {
            System.out.println("number = " + number);
            Double parsedNumber = Double.parseDouble(number);
            System.out.println("parsedNumber = " + parsedNumber);
            validate(parsedNumber);
            return parsedNumber;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("Error");
        }
    }

    private void validate(Double parsedNumber) {
        if (parsedNumber < MIN_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

}
