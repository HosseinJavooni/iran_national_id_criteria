public class main {
    public static void main(String[] args) {
        ActualNationalCodeCriteria actualNationalCodeCriteria = new ActualNationalCodeCriteria();
        //sample of ok national code:  0012225681
        //sample of ok national code:  0043168681
        //sample of ok national code:  0073583790

        System.out.println(actualNationalCodeCriteria.isLegalNationalCodeOk("0073583790"));
    }
}
