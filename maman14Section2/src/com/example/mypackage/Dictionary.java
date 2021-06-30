package com.example.mypackage;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Dictionary {

    private final SortedMap<String, String> dictionary = new TreeMap<>();

    private final static String NULL_PINTERE="NOT EXIST IN OUR TREE MAP";

    public SortedMap<String, String> getDictionary() {
        return dictionary;
    }

    public void insert(String newKey, String newValue) {

       if (!dictionary.containsKey(newKey)) {
            dictionary.put(newKey, newValue);
       }else {
           System.out.println("your input " + newKey + " is exist");
       }

    }

    public String searchByKey(String ourKeyToSearch) {
        String ourKey = NULL_PINTERE;
        if (dictionary.containsKey(ourKeyToSearch)){
            ourKey = dictionary.get(ourKeyToSearch);
        }
        return ourKey;
    }

    public String illustrateSortList() {
        String result = " ";
        for (Map.Entry<String,String> m : dictionary.entrySet()) {
            result = result +"\n"+ m.getKey() + " - " + m.getValue();
        }
        return result;
    }

    public boolean removeTerm(String termMeaning){
        if (dictionary.containsKey(termMeaning)){
            dictionary.remove(termMeaning);
            return true;
        }else {
            return false;
        }
    }

    public boolean updateValueByKey(String termMeaning, String newMeaning){

        if (dictionary.containsKey(termMeaning)){
            dictionary.put(termMeaning,newMeaning);
            return true;
        }else {
            return false;
        }
    }

}
/*
*   for (Map.Entry m : map.entrySet()) {
     System.out.println(m.getKey() + " : " + m.getValue());
-    }
* */