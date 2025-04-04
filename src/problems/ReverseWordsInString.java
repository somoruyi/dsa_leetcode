package problems;

import java.util.Arrays;

public class ReverseWordsInString {
    public static void main(String[] args) {

        String s = "  hello world  ";
        System.out.println(reverseWords(s));

        String player = "  lebron james is a player";
        System.out.println(reverseWords(player));

        String str = "Hi my name is lebron"; //  results = ih ym eman si norbel
        reverseLetters(str);

    }

    public static String reverseWords(String s) {
        String rs = "";
        String[] str = s.trim().split("\\s+");
        int len = str.length;
        for(int i=len-1; i>0; i--){
            rs += str[i] + " ";
        }

        rs += str[0];

        return rs;
    }

    /**
     * <p>Reverse Letters in a word</p>
     * <p>{@code String s = “Hi my name is lebron”}</p>
     * <p>{@code String rl = "ih ym eman si norbel"}</p>
     **/
    public static void reverseLetters(String str){
        String rl = "";
        String[] strArr = str.trim().split("\\s+");

        for(String s : strArr){
            StringBuffer sb = new StringBuffer(s);
            rl += sb.reverse() + " ";
        }

        System.out.println(rl);
        //System.out.println(Arrays.toString(strArr));
    }
}
