public class main {
    public static void main(String[] args) {
        ActualNationalCodeCriteria actualNationalCodeCriteria = new ActualNationalCodeCriteria();

        //sample of ok actual national code:  0012225681
        //sample of ok actual national code:  0043168681
        //sample of ok actual national code:  0073583790
        //sample of ok actual national code:  0492750068
        //sample of ok actual national code:  1720067058

        System.out.println(actualNationalCodeCriteria.isLegalNationalCodeOk("10460114292", true));
    }
}
