package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.HashMap;
import java.util.Map;

@Repository
public class AccidentMem {
    private final Map<Integer, Accident> store = new HashMap<>();

    {
        store.put(1, new Accident(1, "Ivan", "text1", "Piter"));
        store.put(2, new Accident(2, "Petr", "text2", "Omsk"));
        store.put(3, new Accident(3, "Nick", "text3", "Moscow"));
        store.put(4, new Accident(4, "Alex", "text4", "Tomsk"));
        store.put(5, new Accident(5, "John", "text5", "Riga"));
    }

    public Map<Integer, Accident> getStore() {
        return store;
    }
}
