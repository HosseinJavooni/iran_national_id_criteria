import java.util.regex.Pattern;

public class ActualNationalCodeCriteria {
    public String isLegalNationalCodeOk(String nationalCode, boolean isLegal) {

        char[] nationalCodeArray;
        int numberInLocationSum = 0;
        int remainder = 0;
        int controlDigit = 0;

        if (isLegal) {
            //Step1: check that legal national code is 11 digit
            Pattern pattern = Pattern.compile("^[0-9]{11}$");
            boolean criteria = pattern.matcher(nationalCode).matches();
            if (!criteria)
                return "The legal national code( " + nationalCode + " ) is not OK!";
            //Step1 end.

            nationalCodeArray = nationalCode.toCharArray();
            int[] coefficientArray = {29, 27, 23, 19, 17, 29, 27, 23, 19, 17};
            int a = Integer.parseInt(String.valueOf(nationalCodeArray[9])) + 2;
            for(int i = 0; i < 10; i++){
                numberInLocationSum = numberInLocationSum + (Integer.parseInt(String.valueOf(nationalCodeArray[i])) + a) * coefficientArray[i];
            }

            remainder = numberInLocationSum % 11;
            controlDigit = Integer.parseInt(String.valueOf(nationalCodeArray[10]));

            if(remainder == 10) {
                if (controlDigit == 0)
                    return "legal national code (" + nationalCode + " ) is OK!";
            }
            else {
                if (remainder == controlDigit)
                    return "legal national code (" + nationalCode + " ) is OK!";
            }

            return "The legal national code( " + nationalCode + " ) is not OK!";
        } else {
            //Suppose national code is 10 digit like this 'abcdefghij'

            //Step1: check that national code is 10 digit
            Pattern pattern = Pattern.compile("^[0-9]{10}$");
            boolean criteria = pattern.matcher(nationalCode).matches();
            if (!criteria)
                return "The national code( " + nationalCode + " ) is not OK!";
            //Step1 end.

            //Step2: check structure of national code
            nationalCodeArray = nationalCode.toCharArray();
            for (int i = 0; i < 9; i++) {
                numberInLocationSum = numberInLocationSum + Integer.parseInt(String.valueOf(nationalCodeArray[i])) * (10 - i);
            }
            //
            // a     b     c     d     e     f     g     h     i     j
            // *     *
            // 10    9     8     7     6     5     4     3     2
            //
            // numberInLocationSum = (a * 10) + (b * 9) + (b * 8) + ... + (i * 2)
            // where location of 'a' = 10 , location of 'b' = 9, location of 'c' = 8 ... location of i = 2

            remainder = numberInLocationSum % 11;

            // j in location 1 is control digit
            controlDigit = Integer.parseInt(String.valueOf(nationalCodeArray[9]));

            if (remainder < 2)
                if (remainder == controlDigit)
                    return "The national code( " + nationalCode + " ) is OK!";
            if (remainder >= 2)
                if (11 - remainder == controlDigit)
                    return "The national code( " + nationalCode + " ) is OK!";
            //Step2 end

            return "The national code( " + nationalCode + " ) is not OK!";
        }
    }
}
