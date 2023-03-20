package DatedMap.repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class DatedMapImpl implements DatedMap{


    private HashMap<String,DatedValue> datedMap = new HashMap<>();


    @Override
    public void put(String key, String value) {
        datedMap.put(key,new DatedValue(value,new Date()));
    }

    @Override
    public String get(String key) {
        if (datedMap.containsKey(key)){
            return datedMap.get(key).getValue();
        } else {
            return "Данные отсутствуют";
        }
    }

    @Override
    public boolean containsKey(String key) {
        return datedMap.containsKey(key);
    }

    @Override
    public void remove(String key) {
        datedMap.remove(key);
    }

    @Override
    public Set<String> keySet() {
        return datedMap.keySet();
    }

    @Override
    public Date getKeyLastInsertionDate(String key) {
        try {
            return datedMap.get(key).getDateAdd();
        } catch (NullPointerException ex){
            return null;
        }
    }

}
