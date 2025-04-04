package problems;

import java.util.*;

public class AmazonProblems {

    public static void main(String[] args) {
        int threshold = 2;
        List<String> logs = new ArrayList<>();
        logs.add("88 99 200");
        logs.add("88 99 300");
        logs.add("99 32 100");
        logs.add("12 12 15");
        logs.add("77 16 15");
        logs.add("20 77 15");
//        System.out.println(processLogs(logs, threshold));


        List<String> logs2 = new ArrayList<>();
        logs2.add("1 2 50");
        logs2.add("1 7 70");
        logs2.add("1 3 20");
        logs2.add("2 2 17");;
        System.out.println(processLogs(logs2, threshold));
    }
    public static List<String> processLogs(List<String> logs, int threshold){

        String sid = "";
        String rid = "";
        String amount = "";
        Map<String, Integer> map = new HashMap<>();
        List<String> arrList = new ArrayList<>();
        int count = -1;

        for(String s : logs){
            String[] str = s.split("\\s+");
            sid = str[0];
            rid = str[1];

            if(!sid.equals(rid)){
                map.put(sid, map.getOrDefault(sid, 0)+1);
                map.put(rid, map.getOrDefault(rid, 0)+1);
            } else{
                map.put(sid, map.getOrDefault(sid, 0)+1);
            }
        }

        System.out.println("ID\tTransations");
        System.out.println("__\t___________");
        for(Map.Entry<String, Integer> m : map.entrySet()){
            if(m.getValue() >= threshold){
                arrList.add(m.getKey());
            }
            System.out.println(m.getKey() + "\t" + m.getValue());
        }


//        arrList.sort(null);
//        System.out.println("arrList: " + arrList);

        return arrList;
    }
}
