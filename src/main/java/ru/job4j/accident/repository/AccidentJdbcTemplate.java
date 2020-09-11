package ru.job4j.accident.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import ru.job4j.accident.model.Accident;

import java.util.List;

//@Repository
public class AccidentJdbcTemplate {
    private final JdbcTemplate jdbc;

    public AccidentJdbcTemplate(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Accident save(Accident accident) {
        jdbc.update("insert into accident (name, address, carnumber, describe, photo, status) "
                        + "values (?, ?, ?, ?, ?, ?)",
                accident.getName(), accident.getAddress(), accident.getCarNumber(),
                accident.getDescribe(), accident.getPhoto(), accident.getStatus());
        return accident;
    }

    public Accident getAccidentById(int id) {
        return jdbc.queryForObject("select * from accident where id = ?",
                (rs, row) -> {
                    Accident accident = new Accident();
                    accident.setId(rs.getInt("id"));
                    accident.setName(rs.getString("name"));
                    accident.setAddress(rs.getString("address"));
                    accident.setCarNumber(rs.getInt("carnumber"));
                    accident.setDescribe(rs.getString("describe"));
                    accident.setPhoto(rs.getString("photo"));
                    accident.setStatus(rs.getString("status"));
                    return accident;
                }, id);
    }

    public void update(Accident accident) {
        String query = "update accident set name = ?, address = ?, carNumber = ?, describe = ?, photo = ?, status = ? where id = ?";
        jdbc.update(query,
                accident.getName(), accident.getAddress(), accident.getCarNumber(),
                accident.getDescribe(), accident.getPhoto(), accident.getStatus(), accident.getId());
    }

    public List<Accident> getAll() {
        return jdbc.query("select * from accident",
                (rs, row) -> {
                    Accident accident = new Accident();
                    accident.setId(rs.getInt("id"));
                    accident.setName(rs.getString("name"));
                    accident.setAddress(rs.getString("address"));
                    accident.setCarNumber(rs.getInt("carnumber"));
                    accident.setDescribe(rs.getString("describe"));
                    accident.setPhoto(rs.getString("photo"));
                    accident.setStatus(rs.getString("status"));
                    return accident;
                });
    }
}
