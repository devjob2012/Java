package co.uk.java12;

public class Dummy {
    public static void main(String[] args) {
        int i = 0100, j = 020;

        //System.out.println(Dummy.countingValleys(8, "UDDDUDUU"));
        //System.out.println(Dummy.isFibo(15, 0, 1));
        //Dummy.validateCheckSum("9310040334082");
    }





    public static boolean validateCheckSum(String idNumber) {
        //TODO: Use the Luhn algorithm described above to validate the correctness of the idNumber
        int oddPositionSum = 0;
        int evenPosNumber = 0;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < idNumber.length() - 1; i++) {
            if (i % 2 == 0) {
                str.append(String.valueOf(idNumber.charAt(i)));
            } else {
                oddPositionSum = oddPositionSum + idNumber.charAt(i);
            }
        }
        evenPosNumber = Integer.valueOf(str.toString()) * 2;
        int sumEvenPosNumber = String.valueOf(evenPosNumber).chars().map(Character::getNumericValue).sum();
        int finalValue = oddPositionSum + sumEvenPosNumber;
        int valid = 10 - finalValue % 10;
        return valid == idNumber.charAt(idNumber.length()-1);
    }


    public static boolean isFibo(int valueToCheck, int previousValue, int currentValue) {

        return valueToCheck > currentValue ? true : valueToCheck == currentValue ? false : isFibo(valueToCheck, previousValue + currentValue, currentValue);
    }

    static int countingValleys(int n, String s) {
        int count = 0;
        int valley = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'D') {
                count++;
            }
            if (s.charAt(i) == 'U') {
                count--;
            }
            if (count == 0) {
                valley++;
            }
            System.out.println(count + " --> " + valley);
        }
        return valley;
    }
}
