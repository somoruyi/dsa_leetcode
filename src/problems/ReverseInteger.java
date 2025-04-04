package problems;

/**
 * <h3>Mathematical Manipulation </h3>
 */
public class ReverseInteger {
    public static void main(String[] args) {
        int i = Integer.MAX_VALUE;
        // System.out.println(reverse(1534236469)); // 0
        System.out.println(reverseBestSolution(453)); // 354

    }
    public static int reverse(int x) {
        int reversed = 0;

        //String s = Arrays.toString(x);
        if(x<Integer.MAX_VALUE && x>Integer.MIN_VALUE){
            int num = Math.abs(x);
            String str = num + "";
            StringBuffer sb = new StringBuffer(str);
            String s = sb.reverse().toString();
            try{
                if(x<0){
                    reversed = Integer.parseInt("-"+ s);
                }else{
                    reversed = Integer.parseInt(s);
                }
            }catch(Exception e){
                return reversed;
            }
        }

        return reversed;
    }

    /**
     *  Mathematical Manipulation for Digit Extraction and Reversal
     * @param x
     * @return int
     */
    public static int reverseBestSolution(int x) {
        int reversed = 0;
        long calc = reversed;
        while (x != 0) {
            calc = calc * 10 + x % 10;
            reversed = checkRange(calc, reversed * 10 + x % 10) == 0
                    ? 0
                    : checkRange(calc, reversed * 10 + x % 10);
            x /= 10;
        }
        return reversed;
    }
    public static int checkRange(long calc, int reversed){
        double max = Math.pow(2,31);
        double min = Math.pow(-2,31);
        return (calc > max-1 || calc < min ? 0 : reversed );
    }
}
