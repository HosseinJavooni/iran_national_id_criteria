import java.util.regex.Pattern;

public class ActualNationalCodeCriteria {
    public String isLegalNationalCodeOk(String ActualNationalCode) {
        //Suppose national code is 10 digit like this 'abcdefghij'

        //Step1: check that national code is 10 digit or not
                Pattern pattern = Pattern.compile("^[0-9]{10}$");
                boolean criteria = pattern.matcher(ActualNationalCode).matches();
                if (!criteria)
                    return "The national code( " + ActualNationalCode + " ) is not OK!";
        //Step1 end.

        //Step2: check structure of national code
                char[] nationalCodeArray = ActualNationalCode.toCharArray();
                int numberInLocationSum = 0;
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

                int remainder = numberInLocationSum % 11;

                // j in location 1 is control digit
                int controlDigit = Integer.parseInt(String.valueOf(nationalCodeArray[9]));

                if (remainder < 2)
                    if (remainder == controlDigit)
                        return "The national code( " + ActualNationalCode + " ) is OK!";
                if (remainder >= 2)
                    if (11 - remainder == controlDigit)
                        return "The national code( " + ActualNationalCode + " ) is OK!";
        //Step2 end

            return "The national code( " + ActualNationalCode + " ) is not OK!";
    }
}
