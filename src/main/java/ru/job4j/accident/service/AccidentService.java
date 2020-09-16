package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentMem;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AccidentService {
    private final AccidentMem mem;
    private final AtomicInteger id = new AtomicInteger(0);

    public AccidentService(AccidentMem mem) {
        this.mem = mem;
    }

    public Map<Integer, Accident> getMem() {
        return mem.getStore();
    }

    public void save(Accident accident) {
        int id = this.id.incrementAndGet();
        accident.setId(id);
        getMem().put(id, accident);
    }

    public Accident findAccidentById(int id) {
        return getMem().get(id);
    }

    public void updateAccident(Accident accident) {
        getMem().put(accident.getId(), accident);
    }
}
