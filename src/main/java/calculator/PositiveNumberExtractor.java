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
            String customDelimiter = "|" + getCustomDelimiter(inputString);
            delimiter += customDelimiter;

            int endIndex = inputString.indexOf(CUSTOM_DELIMITER_END);
            inputString = inputString.substring(endIndex+END_DELIMITER_LENGTH);
        }

        return Arrays.stream(inputString.split(delimiter))
                .filter(number -> !number.isEmpty())
                .map(this::parseToDouble)
                .collect(Collectors.toList());
    }

    private String getCustomDelimiter(String inputString) {
        int endIndex = inputString.indexOf(CUSTOM_DELIMITER_END);
        if (endIndex == -1) {
            throw new IllegalArgumentException();
        }

        String customDelimiter = inputString.substring(FRONT_DELIMITER_LENGTH, endIndex);
        if (customDelimiter.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return customDelimiter;
    }

    private Double parseToDouble(String number) {
        try {
            Double parsedNumber = Double.parseDouble(number);
            validate(parsedNumber);
            return parsedNumber;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
    }

    private void validate(Double parsedNumber) {
        if (parsedNumber < MIN_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

}
