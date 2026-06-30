package collection.maps;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Maps {

        //Map <TipoClave, tipo valor>
        public Map<String, Integer> construirHashMap(){ // no permite duplicados y no garantiza orden
           Map<String, Integer> map = new HashMap<>();
           
            map.put("A", 10);
            map.put("B", 20);
            map.put("C", 30);
            map.put("A", 50);
            
            System.out.println(map.size());
            System.out.println(map);
            System.out.println(map.values().toArray());


            
            for (int i = 0; i < map.size(); i++) {

                // MAP -> V -> Valores -> Array -> Array[pos]
                System.out.println(map.values().toArray()[i]);
            }
            // MAP -> K -> Keys -> Set -> valor del set
                
            for(String key : map.keySet()){
                System.out.println(key);
            } // A,B,C

            
            for (Map.Entry<String,Integer> entry : map.entrySet()) {
                System.out.println(entry);
            }

            

            return map;
        }
        public LinkedHashMap<String,Integer> coLinkedHashMap(){
            LinkedHashMap<String,Integer> lMap = new LinkedHashMap<>();
            System.out.println("\n ==============00El linked set=========== ");
            
            lMap.put("A", 2);
            lMap.put("B", 3);
            lMap.put("A", 5);
            lMap.put("C", 50);
            lMap.put("D", 5);
            lMap.put("F", 3);
            lMap.put("G", 8);
            lMap.put("H", 85);
            lMap.put("I", 5);


            System.out.println(lMap);

            System.out.println(lMap.entrySet());
            return lMap;
        }

        public Map<String,Integer> coTreeMap(){
            LinkedHashMap<String,Integer> lMap = new LinkedHashMap<>();
            System.out.println("\n =================El arbol=================== ");
            
            lMap.put("A", 2);
            lMap.put("B", 3);
            lMap.put("A", 5);
            lMap.put("C", 50);
            lMap.put("D", 5);
            lMap.put("F", 3);
            lMap.put("G", 8);
            lMap.put("H", 85);
            lMap.put("I", 5);


            System.out.println(lMap);

            System.out.println(lMap.entrySet());
            return lMap;
        }

    }
