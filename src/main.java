public class main {
    public static void main(String[] args) {
        ActualNationalCodeCriteria actualNationalCodeCriteria = new ActualNationalCodeCriteria();

        //sample of ok actual national code:  0012225681
        //sample of ok actual national code:  0043168681
        //sample of ok actual national code:  0073583790
        //sample of ok actual national code:  0492750068
        //sample of ok actual national code:  1720067058

        //sample of ok legal national code:  10320845857 --> شرکت نوآوران فن آوازه
        //sample of ok legal national code:  10101138294 --> فولاد خوزستان
        //sample of ok legal national code:  10260648135 --> فولاد مبارکه اصفهان
        //sample of ok legal national code:  10103637809 --> شرکت توسن

        System.out.println(actualNationalCodeCriteria.isNationalCodeOk("10103637809", true));
    }
}
