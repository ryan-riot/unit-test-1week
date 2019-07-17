public class CustomCalculator {
    public int add(int valueNum1, int valueNum2){
        return valueNum1 + valueNum2;
    }

    public int subtract(int valueNum1, int valueNum2){
        return valueNum1 - valueNum2;
    }

    public int multiply(int valueNum1, int valueNum2){
        return valueNum1 * valueNum2;
    }

    public int divide(int valueNum1, int valueNum2){
        if(valueNum2 == 0)
            logErrorMessage("cannot divide by 0\n");    //Kang chanhyuk

        return valueNum1 / valueNum2;
    }

    private void logErrorMessage(String errormessage) {
        System.out.println(errormessage);
        throw new RuntimeException();
    }

}

