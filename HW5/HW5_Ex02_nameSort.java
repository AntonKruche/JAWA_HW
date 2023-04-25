package HW.HW5;
import java.util.*;
public class HW5_Ex02_nameSort {
    public static void main(String[] args) {
        Map<String, String> nameMap = new HashMap<String,String>();
        nameMap.put("Ivanov", "Ivan");
        nameMap.put("Urin", "Ivan");
        nameMap.put("Chezhov", "Ivan");
        nameMap.put("Mechnikov", "Ivan");
        nameMap.put("Petrova", "Svetlana");
        nameMap.put("Belova", "Kristina");
        nameMap.put("Musina", "Anna");
        nameMap.put("Krutova", "Anna");
        nameMap.put("Vladimirova", "Anna");
        nameMap.put("Likov", "Petr");
        nameMap.put("Chernishov", "Petr");
        nameMap.put("Petin", "Petr");
        nameMap.put("Chernov", "Pavel");
        nameMap.put("Fedorova", "Maria");
        nameMap.put("Savina", "Maria");
        nameMap.put("Rikova", "Maria");
        nameMap.put("Svetlova", "Marina");
        nameMap.put("Lugova", "Marina");
        Map<String, Integer> resultMap = new HashMap<String, Integer>();
        for(String name : nameMap.values()){
            if (resultMap.keySet().contains(name)){
                resultMap.put(name, resultMap.get(name) + 1);
            }
            else{
                resultMap.put(name, 1);
            }
        }
        // List<Integer> count = new ArrayList<>(resultMap.values());
        // Collections.sort(count, Collections.reverseOrder());
        // for(int i : count){
        //     for (String name : resultMap.keySet()){
        //         if (i == resultMap.get(name)){
        //             System.out.println(name);
        //             resultMap.remove(name);
        //         }
        //     }
        // }
        //System.out.println(count);
        resultMap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEach(System.out::println);
    }
}
